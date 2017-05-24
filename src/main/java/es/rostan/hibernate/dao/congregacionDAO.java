package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.congregacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 22/05/2017.
 */
public class congregacionDAO implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<congregacion> lstCongregaciones(){
        List<congregacion> lstCongregaciones = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT c FROM congregacion c");
        lstCongregaciones = (List<congregacion>) qry.getResultList();
        return lstCongregaciones;
    }

    public void ingresarCongregacion(congregacion congregacion){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(congregacion);
        em.getTransaction().commit();
        em.close();
    }
}
