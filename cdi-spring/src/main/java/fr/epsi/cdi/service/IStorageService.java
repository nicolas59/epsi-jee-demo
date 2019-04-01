package fr.epsi.cdi.service;

import java.io.InputStream;

public interface IStorageService {
  public void store(String name, InputStream inputtream);
}
