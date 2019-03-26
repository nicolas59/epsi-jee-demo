package fr.epsi.demo;

import static java.util.stream.Collectors.toList;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import fr.epsi.demo.bean.Contact;

public class Main {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) throws Exception {
    try (Reader reader = Files.newBufferedReader(Paths.get(Main.class.getResource("/mock.csv")
      .toURI()));) {
      @SuppressWarnings("unchecked")
      CsvToBean<Contact> csvToBean = new CsvToBeanBuilder(reader).withType(Contact.class)
        .withIgnoreLeadingWhiteSpace(true)
        .build();

      List<Contact> contacts = StreamSupport.stream(Spliterators.spliteratorUnknownSize(csvToBean.iterator(), Spliterator.ORDERED), false)
        .collect(toList());

      ContactDAO dao =  new ContactDAO();
      dao.deleteAll();
      
      dao.saveAll(contacts);
      
      dao.findAll().stream().map(Contact::toString).forEach(LOGGER::debug);
    }
  }

}
