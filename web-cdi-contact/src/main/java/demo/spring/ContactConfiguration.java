package demo.spring;

import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.cj.jdbc.MysqlDataSource;


@Configuration
public class ContactConfiguration {

  @Produces
  @Bean
  public DataSource dataSource() {
    final MysqlDataSource dataSource = new MysqlDataSource();
    dataSource.setUser("root");
    dataSource.setPassword("password");
    dataSource.setUrl("jdbc:mysql://192.168.99.100:3306/contact");
    return dataSource;
  }
}
