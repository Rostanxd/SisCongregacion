package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostan on 21/05/2017.
 */
public class personaDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<persona> listarPersonas(){
        List<persona> lstPersona = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT p FROM persona as p");
        lstPersona = (List<persona>) qry.getResultList();
        return lstPersona;
    }
}
