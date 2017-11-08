package es.rostan.hibernate.dao;

import es.rostan.hibernate.entidades.grupo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Rostan on 22/05/2017.
 */
public class grupoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public grupo buscaGrupo(String grpCodigo){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT g FROM grupo AS g " +
                "WHERE g.grpCodigo =:gruCodigo");
        qry.setParameter("gruCodigo", grpCodigo);
        return (grupo)qry.getSingleResult();
    }

    public List<grupo> listarGrupos(){
        EntityManager em = emf.createEntityManager();
        Query qry = em.createQuery("SELECT g FROM grupo g");
        return (List<grupo>) qry.getResultList();
    }

    public void ingresarGrupo(grupo grupo){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(grupo);
        em.getTransaction().commit();
        em.close();
    }

    public void actualizarGrupo(grupo grupoUpd) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            grupo grupo = em.find(grupo.class, grupoUpd.getGrpCodigo());
            grupo.setGrpNombre(grupoUpd.getGrpNombre());
            grupo.setGrpEstado(grupoUpd.getGrpEstado());
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e.toString());
            throw e;
        }finally{
            em.close();
        }
    }
}
