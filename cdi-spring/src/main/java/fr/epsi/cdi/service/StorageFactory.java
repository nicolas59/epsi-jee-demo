package fr.epsi.cdi.service;

import javax.enterprise.inject.Produces;

public class StorageFactory {

  @Produces
  public IStorageService createStorage() {
    return new S3StorageService();
  }
  
}
