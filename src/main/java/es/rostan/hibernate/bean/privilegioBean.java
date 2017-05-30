package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.privilegioDAO;
import es.rostan.hibernate.entidades.privilegio;

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
public class privilegioBean implements Serializable {

    private privilegio privilegio = new privilegio();

    private privilegio privilegioSelected = new privilegio();

    private List<privilegio> lstPrivilegios = new ArrayList<>();

    private String btnAccion;

//    CONSTRUCTORES
    public privilegioBean(){

    }

//    GETTER Y SETTERS
    public es.rostan.hibernate.entidades.privilegio getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(es.rostan.hibernate.entidades.privilegio privilegio) {
        this.privilegio = privilegio;
    }

    public List<es.rostan.hibernate.entidades.privilegio> getLstPrivilegios() {
        return lstPrivilegios;
    }

    public void setLstPrivilegios(List<es.rostan.hibernate.entidades.privilegio> lstPrivilegios) {
        this.lstPrivilegios = lstPrivilegios;
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
                this.privilegioSelected = this.privilegio;
                break;
        }
    }

    public es.rostan.hibernate.entidades.privilegio getPrivilegioSelected() {
        return privilegioSelected;
    }

    public void setPrivilegioSelected(es.rostan.hibernate.entidades.privilegio privilegioSelected) {
        this.privilegioSelected = privilegioSelected;
    }

    //    METODOS
    public void listarPrivilegios(){
        privilegioDAO pd = new privilegioDAO();
        this.lstPrivilegios = pd.listarPrivilegios();
    }

    public void ingresarPrivilegio(){
        privilegioDAO pd = new privilegioDAO();
        pd.ingresarPrivilegio(this.privilegioSelected);
    }

    public void actualizarPrivilegio(){
        privilegioDAO pd = new privilegioDAO();
        try{
            pd.actualizarPrivilegio(this.privilegioSelected);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public void operar(){
        switch (btnAccion){
            case "Ingresar":
                this.ingresarPrivilegio();
                this.limpiar();
                break;
            case "Actualizar":
                this.actualizarPrivilegio();
                this.limpiar();
                break;
        }
    }

    private void limpiar(){
        this.privilegioSelected.setPrvCodigo("");
        this.privilegioSelected.setPrvNombre("");
        this.privilegioSelected.setPrvEstado("A");
    }
}
