package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.horasServicioDAO;
import es.rostan.hibernate.entidades.horasServicio;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Rostan on 02/06/2017.
 */
@ManagedBean(name = "hrsServicioBean")
@ViewScoped
public class horasServicioBean implements Serializable{

    private horasServicio hrsServicio = new horasServicio();

    private horasServicio hrsServicioSelected = new horasServicio();

    private List<horasServicio> lstHrsServicio = new ArrayList<>();

    private Map<Integer, String> lstMeses = new HashMap<>();

    private String mesSelected;

    private String btnAccion;

    private FacesMessage message;

//    CONSTRUCTOR
    public horasServicioBean(){

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
    }

    public horasServicio getHrsServicio() {
        return hrsServicio;
    }

    public void setHrsServicio(horasServicio hrsServicio) {
        this.hrsServicio = hrsServicio;
    }

    public horasServicio getHrsServicioSelected() {
        return hrsServicioSelected;
    }

    public void setHrsServicioSelected(horasServicio hrsServicioSelected) {
        this.hrsServicioSelected = hrsServicioSelected;
    }

    public List<horasServicio> getLstHrsServicio() {
        return lstHrsServicio;
    }

    public void setLstHrsServicio(List<horasServicio> lstHrsServicio) {
        this.lstHrsServicio = lstHrsServicio;
    }

    public Map<Integer, String> getLstMeses() {
        return lstMeses;
    }

    public void setLstMeses(Map<Integer, String> lstMeses) {
        this.lstMeses = lstMeses;
    }

    public String getMesSelected() {
        return mesSelected;
    }

    public void setMesSelected(String mesSelected) {
        this.mesSelected = mesSelected;
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
                this.hrsServicioSelected = this.hrsServicio;
                break;
        }
    }

//    METODOS
    public void listarHrsServicio(){
        horasServicioDAO hrd = new horasServicioDAO();
        this.lstHrsServicio = hrd.lstHrsServicios();
    }

    public void ingresarHrsServicio() {
        System.out.println("Congregacion seleccionada..." + this.hrsServicioSelected.getCongregacion().getCngNombre());
        this.hrsServicioSelected.setAchMes(this.buscaMesId(this.mesSelected));
        horasServicioDAO hrd = new horasServicioDAO();
        hrd.ingresarHrsServicio(this.hrsServicioSelected);
    }

    public void actualizarHrsServicio(){
        horasServicioDAO hrd = new horasServicioDAO();
        try{
            hrd.actualizarHrsServicio(this.hrsServicioSelected);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public void operar(){
        switch (btnAccion){
            case "Ingresar":
                this.ingresarHrsServicio();
                this.limpiar();
                break;
            case "Actualizar":
                this.actualizarHrsServicio();
                this.limpiar();
                break;
        }
    }

    public void limpiar(){
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        this.hrsServicioSelected.setAchAnio(year);
        this.hrsServicioSelected.setAchAnioServ(year);
        this.hrsServicioSelected.setCongregacion(null);
        this.hrsServicioSelected.setAchMes(0);
        this.hrsServicioSelected.setPersona(null);
        this.hrsServicioSelected.setAchNumPublicaciones(0);
        this.hrsServicioSelected.setAchNumVideos(0);
        this.hrsServicioSelected.setAchHrsMinisterio(0.0);
        this.hrsServicioSelected.setAchNumRevistas(0);
        this.hrsServicioSelected.setAchHrsEstudio(0.0);
        this.hrsServicioSelected.setAchObservaciones("");
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
