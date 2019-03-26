package fr.epsi.demo.entity.vehicule;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Car extends Vehicule{

  @Column
  private Integer nbPortes;

  public Integer getNbPortes() {
    return nbPortes;
  }

  public void setNbPortes(Integer nbPortes) {
    this.nbPortes = nbPortes;
  }
}
