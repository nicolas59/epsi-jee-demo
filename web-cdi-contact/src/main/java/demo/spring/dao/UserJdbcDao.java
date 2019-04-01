package demo.spring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import demo.spring.bean.User;

@Named
@QUserJdbc
public class UserJdbcDao extends JdbcDaoSupport 
  implements IUserSource {

  @Inject
  private DataSource dataSource;

  @Override
  public Collection<User> findAll() {
    return this.getJdbcTemplate()
      .query("select identifier, first_name, last_name, phone_number from contact", (rs, index) -> {
        User user = new User();
        user.setIdentifier(rs.getLong("identifier"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setPhoneNumber(rs.getString("phone_number"));
        return user;
      });
  }

  @Override
  public void addUser(User user) {
    final String query = user.getIdentifier() != null ? "update contact set first_name=?, last_name=?, phone_number=? where identifier=?"
        : "insert into contact(first_name, last_name, phone_number) values(?, ?, ?)";

    this.getJdbcTemplate()
      .update((PreparedStatementCreator) (action -> {
        PreparedStatement ps = action.prepareStatement(query);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setString(3, user.getPhoneNumber());
        if (user.getIdentifier() != null) {
          ps.setLong(4, user.getIdentifier());
        }
        return ps;
      }));
  }

  @Override
  public void deleteUser(Long identifier) {
    this.getJdbcTemplate()
      .update((PreparedStatementCreator) (action -> {
        PreparedStatement ps = action.prepareStatement("delete from contact where identifier=?");
        ps.setLong(1, identifier);
        return ps;
      }));
  }

  @Override
  public User findById(Long id) {
    return this.getJdbcTemplate()
      .execute((PreparedStatementCreator) (conn -> {
        PreparedStatement ps = conn.prepareStatement("select identifier, first_name, last_name, phone_number from contact where identifier = ?");
        ps.setLong(1, id);
        return ps;
      }), action -> {
        ResultSet rs = action.executeQuery();
        User user = null;
        if (rs.next()) {
          user = new User();
          user.setIdentifier(rs.getLong("identifier"));
          user.setFirstName(rs.getString("first_name"));
          user.setLastName(rs.getString("last_name"));
          user.setPhoneNumber(rs.getString("phone_number"));
        }
        return user;
      });
  }

  @PostConstruct
  public void init() {
    setDataSource(this.dataSource);
  }

}
