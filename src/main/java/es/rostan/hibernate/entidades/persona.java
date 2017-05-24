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
}
