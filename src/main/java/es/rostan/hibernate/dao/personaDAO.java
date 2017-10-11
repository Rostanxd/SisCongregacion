package es.rostan.hibernate.dao;

import es.rostan.hibernate.bean.Util;
import es.rostan.hibernate.bean.registroPublicador;
import es.rostan.hibernate.entidades.persona;
import es.rostan.servicio.Utils;

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

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public List<persona> listarPersonas(){
        List<persona> lstPersona = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT p FROM persona as p");
        lstPersona = (List<persona>) qry.getResultList();
        return lstPersona;
    }

    public void ingresarPersona(persona persona){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarPersona(persona personaUpd) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            persona persona = em.find(persona.class, personaUpd.getPrsCodigo());
            persona.setPrsNombres(personaUpd.getPrsNombres());
            persona.setPrsApellidos(personaUpd.getPrsApellidos());
            persona.setPrsGenero(personaUpd.getPrsGenero());
            persona.setPrsTelefono(personaUpd.getPrsTelefono());
            persona.setPrsCelular(personaUpd.getPrsCelular());
            persona.setPrsFecNacimiento(personaUpd.getPrsFecNacimiento());
            persona.setPrsFecBautismo(personaUpd.getPrsFecBautismo());
            persona.setPrsEstado(personaUpd.getPrsEstado());
            persona.setCongregacion(personaUpd.getCongregacion());
            persona.setPrivilegio(personaUpd.getPrivilegio());
            persona.setGrupo(personaUpd.getGrupo());
            persona.setPrsNpr(personaUpd.getPrsNpr());
            persona.setPrsFrp(personaUpd.getPrsFrp());
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }

    public persona buscaPrsCodigo(String prsApellidos){
        persona p = new persona();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT p FROM persona AS p WHERE p.prsApellidos LIKE '%:prsApellidos%'");
        qry.setParameter(prsApellidos, "prsApellidos");
        qry.setMaxResults(1);
        em.getTransaction().begin();
        p = (persona) qry.getSingleResult();
        return p;
    }

    public List<Integer> aniosServicioPersona(persona persona){
        List<Integer> anios = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT distinct h.achAnioServ " +
                "FROM horasServicio as h " +
                "WHERE h.persona.prsCodigo = :prsCodigo");
        qry.setParameter("prsCodigo", persona.getPrsCodigo());
        anios = (List<Integer>) qry.getResultList();

//        System.out.println("Anios de la persona:");
//        for (Integer anio : anios){
//            System.out.println(anio.toString());
//        }
        return anios;
    }

    public List<registroPublicador> registrosPublicadorPrs(Integer anioSrv, persona persona){
        List<registroPublicador> registros = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT h.achMes ," +
                "SUM(h.achNumPublicaciones) ," +
                "SUM(h.achNumVideos) ," +
                "SUM(h.achHrsMinisterio) ," +
                "SUM(h.achNumRevistas) ," +
                "SUM(h.achHrsEstudio)" +
                "FROM horasServicio AS h " +
                "WHERE h.persona.prsCodigo = :prsCodigo " +
                "AND h.achAnioServ = :anioSrv " +
                "GROUP BY h.achMes");
        qry.setParameter("prsCodigo", persona.getPrsCodigo());
        qry.setParameter("anioSrv", anioSrv);

        List<Object[]> lstObj = (List<Object[]>) qry.getResultList();
        for(Object[] o : lstObj){
            registroPublicador registroPublicador = new registroPublicador();
            registroPublicador.setMesOrden(1);

            registroPublicador.setMesNombre(Utils.setMesNombreInt((Integer)o[0]));

            Long pub = (Long) o[1];
            registroPublicador.setNumPublicaciones(pub.intValue());

            Long vid = (Long) o[2];
            registroPublicador.setNumVideos(vid.intValue());

            Double hrs = (Double) o[3];
            registroPublicador.setNumHoras(hrs.intValue());

            Long rev = (Long) o[4];
            registroPublicador.setNumRevistas(rev.intValue());

            Double cur = (Double) o[5];
            registroPublicador.setNumCursos(cur.intValue());

            registros.add(registroPublicador);
        }

        System.out.println("Registros de Publicacion de " + persona.getPrsApellidos());
        for (registroPublicador r : registros){
            System.out.println("- " + r.toString());
        }

        return registros;
    }

}
