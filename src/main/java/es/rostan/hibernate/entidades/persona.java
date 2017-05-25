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

//    RELACIONES
    @ManyToOne
    @JoinColumn(name = "cngCodigo")
    private congregacion congregacion;

    @ManyToOne
    @JoinColumn(name = "grpCodigo")
    private grupo grupo;

    @ManyToOne
    @JoinColumn(name = "prvCodigo")
    private privilegio privilegio;

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
                ", congregacion=" + congregacion +
                ", grupo=" + grupo +
                ", privilegio=" + privilegio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        persona persona = (persona) o;

        if (!prsCodigo.equals(persona.prsCodigo)) return false;
        if (!prsNombres.equals(persona.prsNombres)) return false;
        if (!prsApellidos.equals(persona.prsApellidos)) return false;
        if (!prsGenero.equals(persona.prsGenero)) return false;
        if (!prsTelefono.equals(persona.prsTelefono)) return false;
        if (!prsCelular.equals(persona.prsCelular)) return false;
        if (!prsFecNacimiento.equals(persona.prsFecNacimiento)) return false;
        if (!prsFecBautismo.equals(persona.prsFecBautismo)) return false;
        if (!prsEstado.equals(persona.prsEstado)) return false;
        if (!congregacion.equals(persona.congregacion)) return false;
        if (!grupo.equals(persona.grupo)) return false;
        return privilegio.equals(persona.privilegio);

    }

    @Override
    public int hashCode() {
        int result = prsCodigo.hashCode();
        result = 31 * result + prsNombres.hashCode();
        result = 31 * result + prsApellidos.hashCode();
        result = 31 * result + prsGenero.hashCode();
        result = 31 * result + prsTelefono.hashCode();
        result = 31 * result + prsCelular.hashCode();
        result = 31 * result + prsFecNacimiento.hashCode();
        result = 31 * result + prsFecBautismo.hashCode();
        result = 31 * result + prsEstado.hashCode();
        result = 31 * result + congregacion.hashCode();
        result = 31 * result + grupo.hashCode();
        result = 31 * result + privilegio.hashCode();
        return result;
    }
}
