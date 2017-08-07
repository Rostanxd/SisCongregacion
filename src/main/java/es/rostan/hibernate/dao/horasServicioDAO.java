package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.horasServicio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostan on 02/06/2017.
 */
public class horasServicioDAO implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public Integer secuenciaHrsServicio(){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT COUNT(h) FROM horasServicio AS h");
        Long numRegistros = (Long) qry.getSingleResult();
        em.close();
        return numRegistros.intValue();
    }

    public List<horasServicio> lstHrsServicios(){
        List<horasServicio> lstHrsServicio;
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT h FROM horasServicio h");
        lstHrsServicio = qry.getResultList();
        return lstHrsServicio;
    }

    public void ingresarHrsServicio(horasServicio hs){
        Date date = Calendar.getInstance().getTime();
        Integer numRegistros = secuenciaHrsServicio();

        hs.setCngCodigo(hs.getCongregacion().getCngCodigo());
        hs.setAchNumRegistro(numRegistros + 1);
        hs.setAchFecRegistro(date);
        hs.setAchUsrRegistro("ADMIN");
        hs.setAchFecModifica(date);
        hs.setAchUsrModifica("ADMIN");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(hs);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarHrsServicio(horasServicio hsUpd) throws Exception{
        Date date = Calendar.getInstance().getTime();
        EntityManager em = emf.createEntityManager();
        try{
            Query qry = em.createQuery("SELECT h FROM horasServicio as h " +
                    "WHERE h.achNumRegistro = :numRegistro ");
            qry.setParameter("numRegistro", hsUpd.getAchNumRegistro());

            em.getTransaction().begin();
            horasServicio hs = (horasServicio) qry.getSingleResult();
            hs.setAchFecModifica(date);
            hs.setAchUsrModifica("ADMIN");

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
