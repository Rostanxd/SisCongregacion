package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.reunion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 27/05/2017.
 */
public class reunionDAO implements Serializable{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<reunion> lstReuniones(){
        List<reunion> lstReuniones = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT r FROM reunion r");
        lstReuniones = (List<reunion>) qry.getResultList();
        return lstReuniones;
    }

    public void ingresarReunion(reunion reunion){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(reunion);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarReunion(reunion reunionUpd) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            reunion reunion = em.find(reunion.class, reunionUpd.getRenCodigo());
            reunion.setRenNombre(reunionUpd.getRenNombre());
            reunion.setRenEstado(reunionUpd.getRenEstado());
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
}
