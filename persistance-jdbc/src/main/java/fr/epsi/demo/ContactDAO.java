package fr.epsi.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.epsi.demo.bean.Contact;

public class ContactDAO {

  private static final Logger LOGGER = LoggerFactory.getLogger(ContactDAO.class);

  public List<Contact> findAll() {
    List<Contact> ret = new ArrayList<>();
    try (Connection conn = ConnectionFactory.getInstance()
      .getConnection(); Statement st = conn.createStatement(); 
        ResultSet rs = st.executeQuery("select identifier, last_name, first_name, phone_number from contact");) {

      LOGGER.debug(" ----------------------------- ");
      ResultSetMetaData rsMetaData = rs.getMetaData();
      for (int index = 1; index <= rsMetaData.getColumnCount(); index++) {
        LOGGER.debug(" Nom de la colonne  : {}", rsMetaData.getColumnName(index));
        LOGGER.debug(" Type de la colonne : {}", rsMetaData.getColumnType(index));
        LOGGER.debug(" Nom du type de la colonne : {}", rsMetaData.getColumnTypeName(index));
        LOGGER.debug(" Precision de la colonne : {}", rsMetaData.getPrecision(index));
      }
      LOGGER.debug(" ----------------------------- ");

      while (rs.next()) {
        Contact contact = new Contact();
        contact.setIdentifier(rs.getLong("identifier"));
        contact.setLastName(rs.getString("last_name"));
        contact.setFirstName(rs.getString("first_name"));
        contact.setPhoneNumber(rs.getString("phone_number"));
        ret.add(contact);

      }

    } catch (SQLException e) {
      LOGGER.error("Problem SQL", e);
    } 
    return ret;
  }

  public Contact save(Contact contact) {
    return this.saveAll(Arrays.asList(contact))
      .stream()
      .findFirst()
      .orElseThrow();
  }

  /**
   * Permet de sauvegarder une liste de contacts en exploitant le meme
   * preparedStatement
   * 
   * 
   * @param contacts
   * @return
   */
  public List<Contact> saveAll(List<Contact> contacts) {
    Connection conn = null;
    try {
      conn = ConnectionFactory.getInstance().getConnection();
      PreparedStatement ps = conn.prepareStatement("insert into contact(first_name, last_name, phone_number)values(?, ?, ?)"); 
      
      
      conn.setAutoCommit(false);
      
      for (Contact contact : contacts) {
        ps.setString(1, contact.getFirstName());
        ps.setString(2, contact.getLastName());
        ps.setString(3, contact.getPhoneNumber());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
          contact.setIdentifier(rs.getLong(1));
        }
        rs.close();

        LOGGER.debug("Création du contact : {}", contact.getIdentifier());
      }
      
      conn.commit();
    } catch (SQLException e) {
      LOGGER.error("Problem SQL", e);
    }
    return contacts;
  }

  public void deleteAll() {
    try (Connection conn = ConnectionFactory.getInstance()
      .getConnection(); Statement st = conn.createStatement()) {
      LOGGER.debug("Nettoyage de la base de données.");
      st.execute("delete from contact");
    } catch (SQLException e) {
      LOGGER.error("Problem SQL", e);
    }
  }
}
