package es.rostan.hibernate.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import es.rostan.hibernate.dao.congregacionDAO;
import es.rostan.hibernate.entidades.congregacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 22/05/2017.
 */
@ManagedBean
@ViewScoped
public class congregacionBean implements Serializable{

    private congregacion congregacion;

    private List<congregacion> lstCongregaciones = new ArrayList<>();

    private String btnAccion;

//    CONSTRUCTOR
    public congregacionBean(){

    }

//    GETTER Y SETTERS
    public es.rostan.hibernate.entidades.congregacion getCongregacion() {
        return congregacion;
    }

    public void setCongregacion(es.rostan.hibernate.entidades.congregacion congregacion) {
        this.congregacion = congregacion;
    }

    public List<es.rostan.hibernate.entidades.congregacion> getLstCongregaciones() {
        return lstCongregaciones;
    }

    public void setLstCongregaciones(List<es.rostan.hibernate.entidades.congregacion> lstCongregaciones) {
        this.lstCongregaciones = lstCongregaciones;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
    }

    //    METODOS
    public void listarCongregaciones(){
        congregacionDAO cd = new congregacionDAO();
        this.lstCongregaciones = cd.lstCongregaciones();
    }

    public void ingresarCongregacion(){
        congregacionDAO cd = new congregacionDAO();
        cd.ingresarCongregacion(this.congregacion);
    }

    public void operar(){
        System.out.println(congregacion.toString());
        this.ingresarCongregacion();
    }
}
