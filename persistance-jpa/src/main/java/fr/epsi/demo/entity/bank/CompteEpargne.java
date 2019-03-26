package fr.epsi.demo.entity.bank;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CompteEpargne extends Compte{

  @Column
  private Double taux;

  public Double getTaux() {
    return taux;
  }

  public void setTaux(Double taux) {
    this.taux = taux;
  }
  
}
