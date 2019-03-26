package fr.epsi.demo.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class EspaceTravail {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  
  @ManyToMany(mappedBy="espacesTravail")
  private Collection<Employe> employes;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Collection<Employe> getEmployes() {
    return employes;
  }

  public void setEmployes(Collection<Employe> employes) {
    this.employes = employes;
  }
  
  
}
