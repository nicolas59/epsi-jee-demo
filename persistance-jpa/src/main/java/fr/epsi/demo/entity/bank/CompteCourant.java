package fr.epsi.demo.entity.bank;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CompteCourant extends Compte{

  @Column
  private Long decouvert;

  public Long getDecouvert() {
    return decouvert;
  }

  public void setDecouvert(Long decouvert) {
    this.decouvert = decouvert;
  }

 
  
  
}
