package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.horasServicio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Rostan on 02/06/2017.
 */
public class horasServicioDAO implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<horasServicio> lstHrsServicios(){
        List<horasServicio> lstHrsServicio;
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT h FROM horasServicio h");
        lstHrsServicio = qry.getResultList();
        return lstHrsServicio;
    }

    public void ingresarHrsServicio(horasServicio hs){
        hs.setCngCodigo(hs.getCongregacion().getCngCodigo());

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(hs);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarHrsServicio(horasServicio hsUpd) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            Query qry = em.createQuery("SELECT h FROM horasServicio as h " +
                    "WHERE h.achAnio = :anio AND " +
                    "h.achAnioServ = :anioserv AND " +
                    "h.achMes = :mes AND " +
                    "h.cngCodigo = :cngCodigo");
            qry.setParameter("anio", hsUpd.getAchAnio());
            qry.setParameter("anioserv", hsUpd.getAchAnioServ());
            qry.setParameter("mes", hsUpd.getAchMes());
            qry.setParameter("cngCodigo", hsUpd.getCngCodigo());
            em.getTransaction().begin();
            horasServicio hs = (horasServicio) qry.getSingleResult();
            hs.setPersona(hsUpd.getPersona());
            hs.setAchNumPublicaciones(hsUpd.getAchNumPublicaciones());
            hs.setAchNumVideos(hsUpd.getAchNumVideos());
            hs.setAchHrsMinisterio(hsUpd.getAchHrsMinisterio());
            hs.setAchNumRevistas(hsUpd.getAchNumRevistas());
            hs.setAchHrsEstudio(hsUpd.getAchHrsEstudio());
            hs.setAchObservaciones(hsUpd.getAchObservaciones());
            em.getTransaction().commit();
        }catch (Exception e ){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
