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

    private privilegio privilegio;

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
    }

//    METODOS
    public void listarPrivilegios(){
        privilegioDAO pd = new privilegioDAO();
        this.lstPrivilegios = pd.listarPrivilegios();
    }

    public void operar(){

    }
}
