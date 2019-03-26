package fr.epsi.demo.entity.vehicule;

import javax.persistence.Entity;

@Entity
public class Camion extends Vehicule {

  private Integer volume;

  public Integer getVolume() {
    return volume;
  }

  public void setVolume(Integer volume) {
    this.volume = volume;
  }
  
  
}
