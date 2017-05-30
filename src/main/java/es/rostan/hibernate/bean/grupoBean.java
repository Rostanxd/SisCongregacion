package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.grupoDAO;
import es.rostan.hibernate.entidades.grupo;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rostan on 22/05/2017.
 */
@ManagedBean
@ViewScoped
public class grupoBean implements Serializable{

    private grupo grupo = new grupo();

    private grupo grupoSelected = new grupo();

    private List<grupo> lstGrupos = new ArrayList<>();

    private String btnAccion;

//    CONSTRUCTOR
    public grupoBean(){

    }

    @PostConstruct
    public void init(){
        this.limpiar();
    }

//    METODOS
    public void listarGrupos(){
        grupoDAO gd = new grupoDAO();
        this.lstGrupos = gd.listarGrupos();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Congregación ingresada correctamente.","Exito"));
    }

    public void actualizarGrupo(){
        grupoDAO gd = new grupoDAO();
        try{
            gd.actualizarGrupo(this.grupoSelected);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void ingresarGrupo(){
        grupoDAO gd = new grupoDAO();
        gd.ingresarGrupo(this.grupoSelected);

    }

    public void operar(){
        switch(btnAccion){
            case "Ingresar":
                this.ingresarGrupo();
                this.limpiar();
                break;
            case "Actualizar":
                this.actualizarGrupo();
                this.limpiar();
                break;
        }
    }

    private void limpiar(){
        this.grupoSelected.setGrpCodigo("");
        this.grupoSelected.setGrpNombre("");
        this.grupoSelected.setGrpEstado("A");
    }

//    GETTER Y SETTERS
    public es.rostan.hibernate.entidades.grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(es.rostan.hibernate.entidades.grupo grupo) {
        this.grupo = grupo;
    }

    public List<es.rostan.hibernate.entidades.grupo> getLstGrupos() {
        return lstGrupos;
    }

    public void setLstGrupos(List<es.rostan.hibernate.entidades.grupo> lstGrupos) {
        this.lstGrupos = lstGrupos;
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
                this.grupoSelected = this.grupo;
                break;
        }
    }

    public es.rostan.hibernate.entidades.grupo getGrupoSelected() {
        return grupoSelected;
    }

    public void setGrupoSelected(es.rostan.hibernate.entidades.grupo grupoSelected) {
        this.grupoSelected = grupoSelected;
    }
}
