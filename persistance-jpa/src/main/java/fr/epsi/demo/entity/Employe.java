package fr.epsi.demo.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employe {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  @ManyToMany
  private Collection<EspaceTravail> espacesTravail;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Collection<EspaceTravail> getEspacesTravail() {
    return espacesTravail;
  }

  public void setEspacesTravail(Collection<EspaceTravail> espacesTravail) {
    this.espacesTravail = espacesTravail;
  }
  
  
}
