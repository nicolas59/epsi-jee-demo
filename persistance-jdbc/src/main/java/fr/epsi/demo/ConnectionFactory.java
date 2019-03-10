package fr.epsi.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionFactory {

  private static final ConnectionFactory INSTANCE = new ConnectionFactory();

  private String url;

  private String userName;

  private String password;

  private DataSource ds;

  private ConnectionFactory() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }

    ResourceBundle bundle = ResourceBundle.getBundle("application");
    this.url = bundle.getString("db.url");
    this.userName = bundle.getString("db.username");
    this.password = bundle.getString("db.password");

    //this.initializeWithDS();
    this.inializeWithJndi();
  }

  private void initializeWithDS() {
    MysqlDataSource mysqlDS = new MysqlDataSource();
    mysqlDS.setURL(this.url);
    mysqlDS.setPassword(this.password);
    mysqlDS.setUser(this.userName);
    this.ds = mysqlDS;
  }
  
  
  private void inializeWithJndi() {
    InitialContext context = null;
    try {
      context = new InitialContext();
      this.ds = (DataSource)context.lookup("java:/comp/env/jdbc/contact");
    } catch (NamingException e) {
      throw new RuntimeException(e);
    }finally {
      close(context);
    }
  }
  
  private void close(InitialContext context) {
    if(context!= null) {
      try {
        context.close();
      } catch (NamingException e) {
        e.printStackTrace();
      }
    }
  }

  public Connection getConnection() throws SQLException {
    /*
     * return DriverManager.getConnection(this.url, this.userName, this.password);
     */

    return ds.getConnection();

  }

  public static ConnectionFactory getInstance() {
    return INSTANCE;
  }

}
