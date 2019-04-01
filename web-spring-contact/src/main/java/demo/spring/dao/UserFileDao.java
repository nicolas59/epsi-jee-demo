package demo.spring.dao;

import static java.util.Collections.synchronizedCollection;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import demo.spring.bean.User;
import demo.spring.service.UserService;

@Named
@Alternative
public class UserFileDao implements IUserSource {

  private Collection<User> users = 
      synchronizedCollection(new ArrayList<>());
 
  @Override
  public Collection<User> findAll() {
    return users.stream()
      .sorted(Comparator.comparing(User::getIdentifier))
      .collect(toList());
  }

  @Override
  public void addUser(final User user) {
    if (user.getIdentifier() != null) {
      this.deleteUser(user.getIdentifier());
      this.users.add(user);
    } else {
      Long id = this.users.stream()
        .max(Comparator.comparing(User::getIdentifier))
        .map(item -> item.getIdentifier())
        .orElse(1L);
      user.setIdentifier(++id);
      this.users.add(user);
    }

  }

  @Override
  public void deleteUser(Long identifier) {
    this.users.removeIf(item -> item.getIdentifier() == identifier);
  }

  @Override
  public User findById(final Long id) {
    return this.users.stream()
      .filter(item -> item.getIdentifier() == id)
      .findFirst()
      .orElseThrow();
  }

  @PostConstruct
  public void init()  {
    try (
        Reader reader = Files.newBufferedReader(Paths.get(UserService.class.getResource("/mock.csv")
          .toURI()));) {
      @SuppressWarnings({"unchecked", "rawtypes"})
      CsvToBean<User> csvToBean = new CsvToBeanBuilder(reader).withType(User.class)
        .withIgnoreLeadingWhiteSpace(true)
        .build();
      csvToBean.iterator()
        .forEachRemaining(item -> users.add(item));
      ;
    }catch(URISyntaxException|IOException e) {
      throw new RuntimeException();
    }
  }

}
