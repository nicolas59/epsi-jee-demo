package fr.epsi.cdi.controller;

import javax.inject.Inject;

import fr.epsi.cdi.service.ContactService;

public class ContactController {

  private ContactService contactService;

  @Inject
  public void setContactService(ContactService contactService) {
    this.contactService = contactService;
  }

  /** Methodes... */  
}
