package demo.spring.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import demo.spring.bean.User;
import demo.spring.dao.IUserSource;
import demo.spring.dao.QUserInMemory;

@Named
public class UserService {

  @Inject 
  @QUserInMemory
  private IUserSource userSource;
  
  public Collection<User> findAll() {
    return this.userSource.findAll();
  }

  public void addUser(final User user) {
    this.userSource.addUser(user);
  }

  public void deleteUser(Long identifier) {
    this.userSource.deleteUser(identifier);
  }

  public User findById(final Long id) {
   return this.userSource.findById(id);
  }
}


