package es.rostan.hibernate.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

    private congregacion congregacion = new congregacion();

    private congregacion congregacionSelected = new congregacion();

    private List<congregacion> lstCongregaciones = new ArrayList<>();

    private String btnAccion;

//    CONSTRUCTOR
    public congregacionBean(){

    }

    @PostConstruct
    public void init(){
        this.limpiar();
    }

//    GETTER Y SETTERS
    public es.rostan.hibernate.entidades.congregacion getCongregacion() {
        return congregacion;
    }

    public void setCongregacion(es.rostan.hibernate.entidades.congregacion congregacion) {
        this.congregacion = congregacion;
    }

    public es.rostan.hibernate.entidades.congregacion getCongregacionSelected() {
        return congregacionSelected;
    }

    public void setCongregacionSelected(es.rostan.hibernate.entidades.congregacion congregacionSelected) {
        this.congregacionSelected = congregacionSelected;
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
        switch (this.btnAccion){
            case "Ingresar":
                this.limpiar();
                break;
            case "Actualizar":
                this.congregacionSelected = this.congregacion;
                break;
        }
    }

    //    METODOS
    public void listarCongregaciones(){
        congregacionDAO cd = new congregacionDAO();
        this.lstCongregaciones = cd.lstCongregaciones();
    }

    public void ingresarCongregacion(){
        congregacionDAO cd = new congregacionDAO();
        cd.ingresarCongregacion(this.congregacionSelected);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Congregación ingresada correctamente.","Exito"));
    }

    public void actualizarCongregacion(){
        congregacionDAO cd = new congregacionDAO();
        try {
            cd.actualizarCongregacion(this.congregacionSelected);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public void operar(){
        switch (btnAccion){
            case "Ingresar":
                this.ingresarCongregacion();
                this.limpiar();
                break;
            case "Actualizar":
                this.actualizarCongregacion();
                this.limpiar();
                break;
        }
    }

    private void limpiar(){
        this.congregacionSelected.setCngCodigo("");
        this.congregacionSelected.setCngNombre("");
        this.congregacionSelected.setCngEstado("A");
    }
}
