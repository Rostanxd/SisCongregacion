package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.personaDAO;
import es.rostan.hibernate.entidades.persona;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rostan on 21/05/2017.
 */
@ManagedBean
@ViewScoped
public class personaBean {

    private persona persona = new persona();

    private List<persona> lstPersonas = new ArrayList<>();

    private String btnAccion;

    @PostConstruct
    private void init(){

    }

//    CONSTRUCTOR
    public personaBean(){

    }

//    GETTER Y SETTERS
    public es.rostan.hibernate.entidades.persona getPersona() {
        return persona;
    }

    public void setPersona(es.rostan.hibernate.entidades.persona persona) {
        this.persona = persona;
    }

    public List<es.rostan.hibernate.entidades.persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<es.rostan.hibernate.entidades.persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
    }

    //    METODOS
    public void listarPersonas(){
        personaDAO pd = new personaDAO();
        this.lstPersonas = pd.listarPersonas();
    }

    public void operar(){

    }
}
