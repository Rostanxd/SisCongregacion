package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.persona;

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
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            throw e;
        }finally {
            em.close();
        }
    }
}
