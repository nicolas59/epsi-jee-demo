package demo.spring.dao;

import java.util.Collection;

import demo.spring.bean.User;

public interface IUserSource {

  Collection<User> findAll();

  void addUser(User user);

  void deleteUser(Long identifier);

  User findById(Long id);

}