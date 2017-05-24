package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.privilegio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Rostan on 22/05/2017.
 */
public class privilegioDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<privilegio> listarPrivilegios(){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT p FROM privilegio p");
        return (List<privilegio>) qry.getResultList();
    }
}
