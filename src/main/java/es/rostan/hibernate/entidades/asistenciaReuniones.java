package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

import es.rostan.hibernate.entidades.reunion;

/**
 * Created by Rostan on 27/05/2017.
 */
@Entity
@Table(name = "asistenciaReuniones")
public class asistenciaReuniones implements Serializable {

    @Id
    private Integer asrAnio;

    @Id
    private Integer asrAnioTeo;

    @Id
    private Integer asrMes;

    @Id
    private String cngCodigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cngCodigo", updatable = false, insertable = false,
        referencedColumnName = "cngCodigo")
    private congregacion congregacion;

    @Column
    private Integer asrNumReunion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "renCodigo", updatable = false, insertable = false,
        referencedColumnName = "renCodigo")
    private reunion reunion;

    private String asrSemana;

    private Integer asrAsistencias;

//    CONSTRUCTOR
    public asistenciaReuniones(){

    }

    public asistenciaReuniones(Integer asrAnio, Integer asrAnioTeo, Integer asrMes, es.rostan.hibernate.entidades.congregacion congregacion, Integer asrNumReunion, es.rostan.hibernate.entidades.reunion reunion, String asrSemana, Integer asrAsistencias) {
        this.asrAnio = asrAnio;
        this.asrAnioTeo = asrAnioTeo;
        this.asrMes = asrMes;
        this.congregacion = congregacion;
        this.asrNumReunion = asrNumReunion;
        this.reunion = reunion;
        this.asrSemana = asrSemana;
        this.asrAsistencias = asrAsistencias;
    }

//    GETTER Y SETTERS
    public Integer getAsrAnio() {
        return asrAnio;
    }

    public void setAsrAnio(Integer asrAnio) {
        this.asrAnio = asrAnio;
    }

    public Integer getAsrAnioTeo() {
        return asrAnioTeo;
    }

    public void setAsrAnioTeo(Integer asrAnioTeo) {
        this.asrAnioTeo = asrAnioTeo;
    }

    public Integer getAsrMes() {
        return asrMes;
    }

    public void setAsrMes(Integer asrMes) {
        this.asrMes = asrMes;
    }

    public String getCngCodigo() {
        return cngCodigo;
    }

    public void setCngCodigo(String cngCodigo) {
        this.cngCodigo = cngCodigo;
    }

    public es.rostan.hibernate.entidades.congregacion getCongregacion() {
        return congregacion;
    }

    public void setCongregacion(es.rostan.hibernate.entidades.congregacion congregacion) {
        this.congregacion = congregacion;
    }

    public Integer getAsrNumReunion() {
        return asrNumReunion;
    }

    public void setAsrNumReunion(Integer asrNumReunion) {
        this.asrNumReunion = asrNumReunion;
    }

    public es.rostan.hibernate.entidades.reunion getReunion() {
        return reunion;
    }

    public void setReunion(es.rostan.hibernate.entidades.reunion reunion) {
        this.reunion = reunion;
    }

    public String getAsrSemana() {
        return asrSemana;
    }

    public void setAsrSemana(String asrSemana) {
        this.asrSemana = asrSemana;
    }

    public Integer getAsrAsistencias() {
        return asrAsistencias;
    }

    public void setAsrAsistencias(Integer asrAsistencias) {
        this.asrAsistencias = asrAsistencias;
    }

    @Override
    public String toString() {
        return "asistenciaReuniones{" +
                "asrAnio=" + asrAnio +
                ", asrAnioTeo=" + asrAnioTeo +
                ", asrMes=" + asrMes +
                ", congregacion=" + congregacion.getCngNombre() +
                ", asrNumReunion=" + asrNumReunion +
                ", reunion=" + reunion.getRenNombre() +
                ", asrSemana='" + asrSemana + '\'' +
                ", asrAsistencias=" + asrAsistencias +
                '}';
    }

}
