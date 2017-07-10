package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rostan on 21/05/2017.
 */
@Entity
@Table(name = "persona")
public class persona implements Serializable {

    @Id
    private String prsCodigo;

    @Column
    private String prsNombres;

    @Column
    private String prsApellidos;

    @Column
    private String prsGenero;

    @Column
    private String prsTelefono;

    @Column
    private String prsCelular;

    @Column
    private Date prsFecNacimiento;

    @Column
    private Date prsFecBautismo;

    @Column
    private String prsEstado;

    @Column
    private String prsDireccion;

//    RELACIONES
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cngCodigo")
    private congregacion congregacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grpCodigo")
    private grupo grupo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prvCodigo")
    private privilegio privilegio;

    @Column
    private Integer prsNpr;

    @Column
    private Date prsFrp;

//    CONSTRUCTORES
    public persona(){

    }

    public persona(String prsCodigo, String prsNombres, String prsApellidos, String prsGenero, String prsTelefono, String prsCelular, Date prsFecNacimiento, Date prsFecBautismo, String prsEstado) {
        this.prsCodigo = prsCodigo;
        this.prsNombres = prsNombres;
        this.prsApellidos = prsApellidos;
        this.prsGenero = prsGenero;
        this.prsTelefono = prsTelefono;
        this.prsCelular = prsCelular;
        this.prsFecNacimiento = prsFecNacimiento;
        this.prsFecBautismo = prsFecBautismo;
        this.prsEstado = prsEstado;
    }

    public persona(String prsCodigo, String prsNombres, String prsApellidos, String prsGenero, String prsTelefono, String prsCelular, Date prsFecNacimiento, Date prsFecBautismo, String prsEstado, es.rostan.hibernate.entidades.congregacion congregacion, es.rostan.hibernate.entidades.grupo grupo, es.rostan.hibernate.entidades.privilegio privilegio, Integer prsNpr, Date prsFrp) {
        this.prsCodigo = prsCodigo;
        this.prsNombres = prsNombres;
        this.prsApellidos = prsApellidos;
        this.prsGenero = prsGenero;
        this.prsTelefono = prsTelefono;
        this.prsCelular = prsCelular;
        this.prsFecNacimiento = prsFecNacimiento;
        this.prsFecBautismo = prsFecBautismo;
        this.prsEstado = prsEstado;
        this.congregacion = congregacion;
        this.grupo = grupo;
        this.privilegio = privilegio;
        this.prsNpr = prsNpr;
        this.prsFrp = prsFrp;
    }

    public persona(String prsCodigo, String prsNombres, String prsApellidos, String prsGenero, String prsTelefono, String prsCelular, Date prsFecNacimiento, Date prsFecBautismo, String prsEstado, String prsDireccion, es.rostan.hibernate.entidades.congregacion congregacion, es.rostan.hibernate.entidades.grupo grupo, es.rostan.hibernate.entidades.privilegio privilegio, Integer prsNpr, Date prsFrp) {
        this.prsCodigo = prsCodigo;
        this.prsNombres = prsNombres;
        this.prsApellidos = prsApellidos;
        this.prsGenero = prsGenero;
        this.prsTelefono = prsTelefono;
        this.prsCelular = prsCelular;
        this.prsFecNacimiento = prsFecNacimiento;
        this.prsFecBautismo = prsFecBautismo;
        this.prsEstado = prsEstado;
        this.prsDireccion = prsDireccion;
        this.congregacion = congregacion;
        this.grupo = grupo;
        this.privilegio = privilegio;
        this.prsNpr = prsNpr;
        this.prsFrp = prsFrp;
    }

    //    GETTER Y SETTERS
    public String getPrsCodigo() {
        return prsCodigo;
    }

    public void setPrsCodigo(String prsCodigo) {
        this.prsCodigo = prsCodigo;
    }

    public String getPrsNombres() {
        return prsNombres;
    }

    public void setPrsNombres(String prsNombres) {
        this.prsNombres = prsNombres;
    }

    public String getPrsApellidos() {
        return prsApellidos;
    }

    public void setPrsApellidos(String prsApellidos) {
        this.prsApellidos = prsApellidos;
    }

    public String getPrsGenero() {
        return prsGenero;
    }

    public void setPrsGenero(String prsGenero) {
        this.prsGenero = prsGenero;
    }

    public String getPrsTelefono() {
        return prsTelefono;
    }

    public void setPrsTelefono(String prsTelefono) {
        this.prsTelefono = prsTelefono;
    }

    public String getPrsCelular() {
        return prsCelular;
    }

    public void setPrsCelular(String prsCelular) {
        this.prsCelular = prsCelular;
    }

    public Date getPrsFecNacimiento() {
        return prsFecNacimiento;
    }

    public void setPrsFecNacimiento(Date prsFecNacimiento) {
        this.prsFecNacimiento = prsFecNacimiento;
    }

    public Date getPrsFecBautismo() {
        return prsFecBautismo;
    }

    public void setPrsFecBautismo(Date prsFecBautismo) {
        this.prsFecBautismo = prsFecBautismo;
    }

    public String getPrsEstado() {
        return prsEstado;
    }

    public void setPrsEstado(String prsEstado) {
        this.prsEstado = prsEstado;
    }

    public es.rostan.hibernate.entidades.congregacion getCongregacion() {
        return congregacion;
    }

    public void setCongregacion(es.rostan.hibernate.entidades.congregacion congregacion) {
        this.congregacion = congregacion;
    }

    public es.rostan.hibernate.entidades.grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(es.rostan.hibernate.entidades.grupo grupo) {
        this.grupo = grupo;
    }

    public es.rostan.hibernate.entidades.privilegio getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(es.rostan.hibernate.entidades.privilegio privilegio) {
        this.privilegio = privilegio;
    }

    public String getPrsDireccion() {
        return prsDireccion;
    }

    public void setPrsDireccion(String prsDireccion) {
        this.prsDireccion = prsDireccion;
    }

    public Integer getPrsNpr() {
        return prsNpr;
    }

    public void setPrsNpr(Integer prsNpr) {
        this.prsNpr = prsNpr;
    }

    public Date getPrsFrp() {
        return prsFrp;
    }

    public void setPrsFrp(Date prsFrp) {
        this.prsFrp = prsFrp;
    }

    @Override
    public String toString() {
        return "persona{" +
                "prsCodigo='" + prsCodigo + '\'' +
                ", prsNombres='" + prsNombres + '\'' +
                ", prsApellidos='" + prsApellidos + '\'' +
                ", prsGenero='" + prsGenero + '\'' +
                ", prsTelefono='" + prsTelefono + '\'' +
                ", prsCelular='" + prsCelular + '\'' +
                ", prsFecNacimiento=" + prsFecNacimiento +
                ", prsFecBautismo=" + prsFecBautismo +
                ", prsEstado='" + prsEstado + '\'' +
                ", prsNpr=" + prsNpr +
                ", prsFrp=" + prsFrp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof persona)) return false;

        persona persona = (persona) o;

        if (!getPrsCodigo().equals(persona.getPrsCodigo())) return false;
        if (!getPrsNombres().equals(persona.getPrsNombres())) return false;
        if (!getPrsApellidos().equals(persona.getPrsApellidos())) return false;
        if (!getPrsGenero().equals(persona.getPrsGenero())) return false;
        if (!getPrsTelefono().equals(persona.getPrsTelefono())) return false;
        if (!getPrsCelular().equals(persona.getPrsCelular())) return false;
        if (!getPrsFecNacimiento().equals(persona.getPrsFecNacimiento())) return false;
        if (!getPrsFecBautismo().equals(persona.getPrsFecBautismo())) return false;
        return getPrsEstado().equals(persona.getPrsEstado());
    }

    @Override
    public int hashCode() {
        int result = getPrsCodigo().hashCode();
        result = 31 * result + getPrsNombres().hashCode();
        result = 31 * result + getPrsApellidos().hashCode();
        result = 31 * result + getPrsGenero().hashCode();
        result = 31 * result + getPrsTelefono().hashCode();
        result = 31 * result + getPrsCelular().hashCode();
        result = 31 * result + getPrsFecNacimiento().hashCode();
        result = 31 * result + getPrsFecBautismo().hashCode();
        result = 31 * result + getPrsEstado().hashCode();
        return result;
    }
}
