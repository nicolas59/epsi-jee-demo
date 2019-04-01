package fr.epsi.cdi.service;

import java.io.InputStream;

import javax.inject.Named;

@Named("S3")
public class S3StorageService implements IStorageService {

  public void store(String name, InputStream inputtream) {
  }
}
