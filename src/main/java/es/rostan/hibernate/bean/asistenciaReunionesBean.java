package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.asistenciaReunionesDAO;
import es.rostan.hibernate.entidades.asistenciaReuniones;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Rostan on 27/05/2017.
 */
@ManagedBean(name = "asistenciaBean")
@ViewScoped
public class asistenciaReunionesBean implements Serializable{

    private asistenciaReuniones asistencia = new asistenciaReuniones();

    private asistenciaReuniones asistenciaSelected = new asistenciaReuniones();

    private List<asistenciaReuniones> lstAsistencias = new ArrayList<>();

    private Map<Integer, String> lstMeses = new HashMap<Integer, String>();

    private Map<String, String> lstSemana = new HashMap<String, String>();

    private String mesSelected;

    private String btnAccion;

//    CONSTRUCTOR
    public asistenciaReunionesBean(){

    }

    @PostConstruct
    public void init(){
//        Enlistar Meses
        lstMeses = new HashMap<Integer, String>();
        lstMeses.put(1, "Enero");
        lstMeses.put(2, "Febrero");
        lstMeses.put(3, "Marzo");
        lstMeses.put(4, "Abril");
        lstMeses.put(5, "Mayo");
        lstMeses.put(6, "Junio");
        lstMeses.put(7, "Julio");
        lstMeses.put(8, "Agosto");
        lstMeses.put(9, "Septiembre");
        lstMeses.put(10, "Octubre");
        lstMeses.put(11, "Noviembre");
        lstMeses.put(12, "Dciembre");

//        Enlistar Semanas
        lstSemana = new HashMap<String, String>();
        lstSemana.put("Primera", "Primera");
        lstSemana.put("Segunda", "Segunda");
        lstSemana.put("Tercera", "Tercera");
        lstSemana.put("Cuarta", "Cuarta");
        lstSemana.put("Quinta", "Quinta");
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

    public Map<Integer, String> getLstMeses() {
        return lstMeses;
    }

    public void setLstMeses(Map<Integer, String> lstMeses) {
        this.lstMeses = lstMeses;
    }

    public Map<String, String> getLstSemana() {
        return lstSemana;
    }

    public void setLstSemana(Map<String, String> lstSemana) {
        this.lstSemana = lstSemana;
    }

    public String getMesSelected() {
        return mesSelected;
    }

    public void setMesSelected(String mesSelected) {
        this.mesSelected = mesSelected;
    }

    //    METODOS
    public void listarAsistencias(){
        asistenciaReunionesDAO ad = new asistenciaReunionesDAO();
        this.lstAsistencias = ad.lstAsistencias();
    }

    public void ingrearAsistencias(){
        this.asistenciaSelected.setAsrMes(this.buscaMesId(this.mesSelected));
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
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);

        this.asistenciaSelected.setAsrAnio(year);
        this.asistenciaSelected.setAsrAnioTeo(year);
        this.asistenciaSelected.setCongregacion(null);
        this.asistenciaSelected.setAsrMes(0);
        this.asistenciaSelected.setAsrNumReunion(0);
        this.asistenciaSelected.setReunion(null);
        this.asistenciaSelected.setAsrSemana("");
        this.asistenciaSelected.setAsrAsistencias(0);
    }

    public Integer buscaMesId(String mes){
        Integer key = 0;
        for (Map.Entry<Integer, String> e : this.lstMeses.entrySet()){
            if (e.getValue().equals(mes)){
                key = e.getKey();
                break;
            }
        }
        return key;
    }

    public String buscaMesNombre(Integer mes){
        String mesNombre = "";

        for (Map.Entry<Integer, String> e : this.lstMeses.entrySet()){
            if (e.getKey().equals(mes)){
                mesNombre = e.getValue();
                break;
            }
        }
        return mesNombre;
    }
}
