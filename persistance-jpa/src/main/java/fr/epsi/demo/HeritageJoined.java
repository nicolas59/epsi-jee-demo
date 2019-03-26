package fr.epsi.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.epsi.demo.entity.bank.CompteCourant;
import fr.epsi.demo.entity.bank.CompteEpargne;

public class HeritageJoined {
  public static void main(String... args) {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
    EntityManager em = factory.createEntityManager();
    em.getTransaction()
      .begin();

    CompteCourant cc = new CompteCourant();
    cc.setSolde(1000l);
    cc.setDecouvert(-500L);
    em.persist(cc);

    CompteEpargne ce = new CompteEpargne();
    ce.setSolde(5000l);
    ce.setTaux(0.75);
    em.persist(ce);

    ;

    em.flush();

    em.getTransaction()
      .commit();

  }
}
