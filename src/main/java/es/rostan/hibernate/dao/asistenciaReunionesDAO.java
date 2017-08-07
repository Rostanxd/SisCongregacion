package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.asistenciaReuniones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Rostan on 27/05/2017.
 */
public class asistenciaReunionesDAO implements Serializable{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public Integer secuenciaAsistencia(){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT COUNT(a) FROM asistenciaReuniones AS a");
        Long numRegistros = (Long) qry.getSingleResult();
        em.close();
        return numRegistros.intValue();
    }

    public List<asistenciaReuniones> lstAsistencias(){
        List<asistenciaReuniones> lstAsistencia = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT a FROM asistenciaReuniones a");
        lstAsistencia = (List<asistenciaReuniones>) qry.getResultList();
        return lstAsistencia;
    }

    public void ingresarAsistencia(asistenciaReuniones asistenciaReuniones){
        Date date = Calendar.getInstance().getTime();
        Integer numRegistros = secuenciaAsistencia();
        System.out.println("ingresarAsistencia - numRegistro -> " + numRegistros.toString());

        asistenciaReuniones.setCongregacion(asistenciaReuniones.getCongregacion());
        asistenciaReuniones.setReunion(asistenciaReuniones.getReunion());
        asistenciaReuniones.setAsrNumRegistro(numRegistros + 1);
        asistenciaReuniones.setAsrFecRegistro(date);
        asistenciaReuniones.setAsrUsrRegistro("ADMIN");
        asistenciaReuniones.setAsrFecModifica(date);
        asistenciaReuniones.setAsrUsrModifica("ADMIN");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(asistenciaReuniones);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarAsistencia(asistenciaReuniones asisUpd){
        Date date = Calendar.getInstance().getTime();
        EntityManager em = emf.createEntityManager();
        try{
            Query qry = em.createQuery("SELECT a FROM asistenciaReuniones as a WHERE a.asrNumRegistro = :asrNumRegistro");
            qry.setParameter("asrNumRegistro", asisUpd.getAsrNumRegistro());

            em.getTransaction().begin();
            asistenciaReuniones asis = (asistenciaReuniones) qry.getSingleResult();
            asis.setAsrNumReunion(asisUpd.getAsrNumReunion());
            asis.setReunion(asisUpd.getReunion());
            asis.setAsrSemana(asisUpd.getAsrSemana());
            asis.setAsrAsistencias(asisUpd.getAsrAsistencias());
            asis.setAsrFecModifica(date);
            asis.setAsrUsrModifica("ADMIN");

            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
