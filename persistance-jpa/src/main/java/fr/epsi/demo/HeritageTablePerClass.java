package fr.epsi.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.epsi.demo.entity.vehicule.Camion;
import fr.epsi.demo.entity.vehicule.Car;
import fr.epsi.demo.entity.vehicule.Vehicule;

public class HeritageTablePerClass {
public static void main(String... args) {
    
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
    EntityManager em = factory.createEntityManager();
    em.getTransaction().begin();
  
    Camion camion = new Camion();
    camion.setImmatriculation("EP-001-SI");
    camion.setVolume(10);
    em.persist(camion);
    
    Car car = new Car();
    car.setImmatriculation("EP-002-SI");
    car.setNbPortes(5);
    em.persist(car);
    
    em.flush();
    
    em.getTransaction().commit();
    
    List<Vehicule> vehicules =(List<Vehicule>)em.createQuery("select v from Vehicule v").getResultList(); 
    vehicules.stream().map(Vehicule::getImmatriculation).forEach(System.out::println);
  
    Query query = em.createQuery("select c from Car c where c.immatriculation=:immatriculation");
    query.setParameter("immatriculation", "EP-002-SI");
    Car result = (Car)query.getSingleResult();
    System.out.println(result.getNbPortes());
  }
  
}
