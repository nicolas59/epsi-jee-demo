package fr.epsi.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.epsi.demo.entity.geo.Circle;
import fr.epsi.demo.entity.geo.Rectangle;

public class HeritageSingleTable {

  public static void main(String...args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
    EntityManager em = factory.createEntityManager();
    em.getTransaction().begin();
  
    Rectangle r = new Rectangle();
    r.setHeight(4);
    r.setWidth(10);
    
    em.persist(r);
    
    Circle circle = new Circle();
    circle.setRadius(6);
    em.persist(circle);
    
    em.detach(circle);
    
    em.getTransaction().commit();
  }
}
