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

    public privilegio buscaPrivilegio(String prvCodigo){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT p FROM privilegio AS p " +
                "WHERE p.prvCodigo =:prvCodigo");
        qry.setParameter("prvCodigo", prvCodigo);
        return (privilegio) qry.getSingleResult();
    }

    public List<privilegio> listarPrivilegios(){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT p FROM privilegio p");
        return (List<privilegio>) qry.getResultList();
    }

    public void ingresarPrivilegio(privilegio privilegio){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(privilegio);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarPrivilegio(privilegio privilegioUpd){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            privilegio privilegio = em.find(privilegio.class, privilegioUpd.getPrvCodigo());
            privilegio.setPrvNombre(privilegioUpd.getPrvNombre());
            privilegio.setPrvEstado(privilegioUpd.getPrvEstado());
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
