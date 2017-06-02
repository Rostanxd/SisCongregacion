package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.asistenciaReuniones;

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
public class asistenciaReunionesDAO implements Serializable{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<asistenciaReuniones> lstAsistencias(){
        List<asistenciaReuniones> lstAsistencia = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT a FROM asistenciaReuniones a");
        lstAsistencia = (List<asistenciaReuniones>) qry.getResultList();
        return lstAsistencia;
    }

    public void ingresarAsistencia(asistenciaReuniones asistenciaReuniones){
        asistenciaReuniones.setCngCodigo(asistenciaReuniones.getCongregacion().getCngCodigo());

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(asistenciaReuniones);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarAsistencia(asistenciaReuniones asisUpd){
        EntityManager em = emf.createEntityManager();
        try{
            Query qry = em.createQuery("SELECT a FROM asistenciaReuniones as a " +
                    "WHERE a.asrAnio = :anio AND a.asrAnioTeo = :anioTeo AND " +
                    "a.cngCodigo = :cng AND a.asrMes = :mes");
            qry.setParameter("anio", asisUpd.getAsrAnio());
            qry.setParameter("anioTeo", asisUpd.getAsrAnioTeo());
            qry.setParameter("cng", asisUpd.getCngCodigo());
            qry.setParameter("mes", asisUpd.getAsrMes());

            em.getTransaction().begin();
            asistenciaReuniones asis = (asistenciaReuniones) qry.getSingleResult();
            asis.setAsrNumReunion(asisUpd.getAsrNumReunion());
            asis.setReunion(asisUpd.getReunion());
            asis.setAsrSemana(asisUpd.getAsrSemana());
            asis.setAsrAsistencias(asisUpd.getAsrAsistencias());
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
