package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.grupoDAO;
import es.rostan.hibernate.entidades.grupo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 22/05/2017.
 */
@ManagedBean
@ViewScoped
public class grupoBean implements Serializable{

    private grupo grupo;

    private List<grupo> lstGrupo = new ArrayList<>();

    private String btnAccion;

//    CONSTRUCTOR
    public grupoBean(){

    }

//    METODOS
    public void listarGrupos(){
        grupoDAO gd = new grupoDAO();
        this.lstGrupo = gd.listarGrupos();
    }

    public void operar(){

    }

//    GETTER Y SETTERS
    public es.rostan.hibernate.entidades.grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(es.rostan.hibernate.entidades.grupo grupo) {
        this.grupo = grupo;
    }

    public List<es.rostan.hibernate.entidades.grupo> getLstGrupo() {
        return lstGrupo;
    }

    public void setLstGrupo(List<es.rostan.hibernate.entidades.grupo> lstGrupo) {
        this.lstGrupo = lstGrupo;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
    }
}
