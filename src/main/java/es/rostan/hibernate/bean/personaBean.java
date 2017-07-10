package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.congregacionDAO;
import es.rostan.hibernate.dao.grupoDAO;
import es.rostan.hibernate.dao.personaDAO;
import es.rostan.hibernate.entidades.congregacion;
import es.rostan.hibernate.entidades.grupo;
import es.rostan.hibernate.entidades.persona;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.*;

/**
 * Created by Rostan on 21/05/2017.
 */
@ManagedBean
@ViewScoped
public class personaBean {

    private persona persona = new persona();

    private persona personaSelected = new persona();

    private List<persona> lstPersonas = new ArrayList<>();

    private List<congregacion> lstCongregaciones = new ArrayList<>();

    private String btnAccion = "";

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
        switch (this.btnAccion){
            case "Ingresar":
                this.limpiar();
                break;
            case "Actualizar":
                this.personaSelected = this.persona;
//                System.out.println(this.personaSelected.getCongregacion().toString());
                break;
        }
    }

    public es.rostan.hibernate.entidades.persona getPersonaSelected() {
        return personaSelected;
    }

    public void setPersonaSelected(es.rostan.hibernate.entidades.persona personaSelected) {
        this.personaSelected = personaSelected;
    }

    public List<congregacion> getLstCongregaciones() {
        return lstCongregaciones;
    }

    public void setLstCongregaciones(List<congregacion> lstCongregaciones) {
        this.lstCongregaciones = lstCongregaciones;
    }

    //    METODOS
    public void listarPersonas(){
        personaDAO pd = new personaDAO();
        this.lstPersonas = pd.listarPersonas();
    }

    public void listarCongregaciones(){
        congregacionDAO cd = new congregacionDAO();
        this.lstCongregaciones = cd.lstCongregaciones();
    }

    public void operar(){
        switch (btnAccion){
            case "Ingresar":
                this.ingresarPersona();
                this.limpiar();
                break;
            case "Actualizar":
                this.actualizarPersona();
                this.limpiar();
                break;
        }
    }

    public void ingresarPersona(){
        personaDAO pd = new personaDAO();
        pd.ingresarPersona(this.personaSelected);
    }

    public void actualizarPersona(){
        personaDAO pd = new personaDAO();
        try {
            pd.actualizarPersona(this.personaSelected);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void limpiar(){
        Calendar now = Calendar.getInstance();

        this.personaSelected.setPrsCodigo("");
        this.personaSelected.setPrsNombres("");
        this.personaSelected.setPrsApellidos("");
        this.personaSelected.setPrsGenero("");
        this.personaSelected.setPrsTelefono("");
        this.personaSelected.setPrsCelular("");
        this.personaSelected.setPrsFecNacimiento(null);
        this.personaSelected.setPrsFecBautismo(null);
        this.personaSelected.setPrsEstado("A");
        this.personaSelected.setCongregacion(null);
        this.personaSelected.setGrupo(null);
        this.personaSelected.setPrivilegio(null);
        this.personaSelected.setCongregacion(null);
        this.personaSelected.setGrupo(null);
        this.personaSelected.setPrivilegio(null);
        this.personaSelected.setPrsNpr(0);
        this.personaSelected.setPrsFrp(now.getTime());
    }
}
