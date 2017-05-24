package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.grupo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Rostan on 22/05/2017.
 */
public class grupoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<grupo> listarGrupos(){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT g FROM grupo g");
        return (List<grupo>) qry.getResultList();
    }
}
