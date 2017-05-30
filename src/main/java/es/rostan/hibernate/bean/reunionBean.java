package es.rostan.hibernate.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import es.rostan.hibernate.dao.reunionDAO;
import es.rostan.hibernate.entidades.reunion;

/**
 * Created by Rostan on 27/05/2017.
 */
@ManagedBean
@ViewScoped
public class reunionBean implements Serializable{

    private reunion reunion = new reunion();

    private reunion reunionSelected = new reunion();

    private List<reunion> lstReuniones = new ArrayList<>();

    private String btnAccion;

//    CONSTRUCTOR
    public reunionBean(){

    }

    @PostConstruct
    public void init(){

    }

//    GETTER Y SETTERS
    public es.rostan.hibernate.entidades.reunion getReunion() {
        return reunion;
    }

    public void setReunion(es.rostan.hibernate.entidades.reunion reunion) {
        this.reunion = reunion;
    }

    public es.rostan.hibernate.entidades.reunion getReunionSelected() {
        return reunionSelected;
    }

    public void setReunionSelected(es.rostan.hibernate.entidades.reunion reunionSelected) {
        this.reunionSelected = reunionSelected;
    }

    public List<es.rostan.hibernate.entidades.reunion> getLstReuniones() {
        return lstReuniones;
    }

    public void setLstReuniones(List<es.rostan.hibernate.entidades.reunion> lstReuniones) {
        this.lstReuniones = lstReuniones;
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
                this.reunionSelected = this.reunion;
                break;
        }
    }

//    METODOS
    public void listarReuniones(){
        reunionDAO rd = new reunionDAO();
        this.lstReuniones = rd.lstReuniones();
    }

    public void ingresarReunion(){
        reunionDAO rd = new reunionDAO();
        rd.ingresarReunion(this.reunionSelected);
    }

    public void actualizarReunion(){
        reunionDAO rd = new reunionDAO();
        try{
            rd.actualizarReunion(this.reunionSelected);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void operar(){
        switch (btnAccion){
            case "Ingresar":
                this.ingresarReunion();
                this.limpiar();
                break;
            case "Actualizar":
                this.actualizarReunion();
                this.limpiar();
                break;
        }
    }

    private void limpiar(){
        this.reunionSelected.setRenCodigo("");
        this.reunionSelected.setRenNombre("");
        this.reunionSelected.setRenEstado("A");
    }
}
