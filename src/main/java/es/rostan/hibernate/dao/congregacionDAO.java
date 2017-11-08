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

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<congregacion> lstCongregaciones(){
        List<congregacion> lstCongregaciones;
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

    public void actualizarCongregacion(congregacion congregacion) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            congregacion cng = em.find(congregacion.class, congregacion.getCngCodigo());
            cng.setCngNombre(congregacion.getCngNombre());
            cng.setCngEstado(congregacion.getCngEstado());
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public congregacion buscaCongregacion(String cngCodigo){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT c FROM congregacion AS c " +
                "WHERE c.cngCodigo =:cngCodigo");
        qry.setParameter("cngCodigo", cngCodigo);
        return (congregacion) qry.getSingleResult();
    }

    public congregacion buscaCongregacionPorNombre(String cngNombre){
        System.out.println("buscaCongregacionPorNombre <- " + cngNombre);
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT c FROM congregacion AS c WHERE c.cngNombre = :cngNombre");
        qry.setParameter("cngNombre", cngNombre);
        congregacion congregacion = (congregacion) qry.getSingleResult();
        System.out.println("buscaCongregacionPorNombre -> " + congregacion.getCngNombre());
        return congregacion;
    }
}
