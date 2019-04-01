package fr.epsi.cdi.controller;

import java.io.InputStream;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import fr.epsi.cdi.service.IStorageService;

public class UploadController {

  @Inject @Any
  private Instance<IStorageService> storageServices;
  
  public void store(String name, InputStream inputStream) {
     for(IStorageService storageService: storageServices) {
       storageService.store(name, inputStream);
     }
  }
}
