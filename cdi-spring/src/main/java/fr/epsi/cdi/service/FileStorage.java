package fr.epsi.cdi.service;

import java.io.InputStream;

import javax.inject.Named;

@Named("filesystem")
public class FileStorage implements IStorageService {

  public void store(String name, InputStream inputtream) {
  }

}
