package fr.epsi.demo.entity.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

  @Id
  @GeneratedValue( strategy=GenerationType.IDENTITY)
  private Long id;
  
  @Column
  private Long solde;

  public Long getSolde() {
    return solde;
  }

  public void setSolde(Long solde) {
    this.solde = solde;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
