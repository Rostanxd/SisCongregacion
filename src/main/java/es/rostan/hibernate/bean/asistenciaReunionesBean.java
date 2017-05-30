package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.asistenciaReunionesDAO;
import es.rostan.hibernate.entidades.asistenciaReuniones;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 27/05/2017.
 */
@ManagedBean(name = "asistenciaBean")
@ViewScoped
public class asistenciaReunionesBean implements Serializable{

    private asistenciaReuniones asistencia = new asistenciaReuniones();

    private asistenciaReuniones asistenciaSelected = new asistenciaReuniones();

    private List<asistenciaReuniones> lstAsistencias = new ArrayList<>();

    private String btnAccion;

//    CONSTRUCTOR
    public asistenciaReunionesBean(){

    }

    @PostConstruct
    public void init(){

    }

//    GETTER Y SETTERS
    public asistenciaReuniones getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(asistenciaReuniones asistencia) {
        this.asistencia = asistencia;
    }

    public asistenciaReuniones getAsistenciaSelected() {
        return asistenciaSelected;
    }

    public void setAsistenciaSelected(asistenciaReuniones asistenciaSelected) {
        this.asistenciaSelected = asistenciaSelected;
    }

    public List<asistenciaReuniones> getLstAsistencias() {
        return lstAsistencias;
    }

    public void setLstAsistencias(List<asistenciaReuniones> lstAsistencias) {
        this.lstAsistencias = lstAsistencias;
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
                this.asistenciaSelected = this.asistencia;
                break;
        }
    }

//    METODOS
    public void listarAsistencias(){
        asistenciaReunionesDAO ad = new asistenciaReunionesDAO();
        this.lstAsistencias = ad.lstAsistencias();
    }

    public void ingrearAsistencias(){
        asistenciaReunionesDAO ad = new asistenciaReunionesDAO();
        ad.ingresarAsistencia(this.asistenciaSelected);
    }

    public void actualizarAsistencia(){
        asistenciaReunionesDAO ad = new asistenciaReunionesDAO();
        try{
            ad.actualizarAsistencia(this.asistenciaSelected);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public void operar(){
        switch (btnAccion){
            case "Ingresar":
                this.ingrearAsistencias();
                this.limpiar();
                break;
            case "Actualizar":
                this.actualizarAsistencia();
                this.limpiar();
                break;
        }
    }

    public void limpiar(){
        this.asistenciaSelected.setAsrAnio(0);
        this.asistenciaSelected.setAsrAnioTeo(0);
        this.asistenciaSelected.setCongregacion(null);
        this.asistenciaSelected.setAsrMes(0);
        this.asistenciaSelected.setAsrNumReunion(0);
        this.asistenciaSelected.setReunion(null);
        this.asistenciaSelected.setAsrSemana("");
        this.asistenciaSelected.setAsrAsistencias(0);
    }
}
