package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Rostan on 02/06/2017.
 */
@Entity
@Table(name = "horasServicio")
@IdClass(horasServicioPK.class)
public class horasServicio implements Serializable{

    @Id
    private Integer achAnio;

    @Id
    private Integer achAnioServ;

    @Id
    private Integer achMes;

    @Id
    private String cngCodigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cngCodigo", updatable = false, insertable = false,
            referencedColumnName = "cngCodigo")
    private congregacion congregacion;

    @OneToOne
    @JoinColumn(name = "prsCodigo")
    private persona persona;

    private Integer achNumPublicaciones;

    private Integer achNumVideos;

    private Integer achHrsMinisterio;

    private Integer achNumRevistas;

    private Integer achHrsEstudio;

    private String achObservaciones;

//    CONSTRUCTOR
    public horasServicio(){

    }

    public horasServicio(Integer achAnio, Integer achAnioServ, Integer achMes, String cngCodigo, es.rostan.hibernate.entidades.congregacion congregacion, es.rostan.hibernate.entidades.persona persona, Integer achNumPublicaciones, Integer achNumVideos, Integer achHrsMinisterio, Integer achNumRevistas, Integer achHrsEstudio, String achObservaciones) {
        this.achAnio = achAnio;
        this.achAnioServ = achAnioServ;
        this.achMes = achMes;
        this.cngCodigo = cngCodigo;
        this.congregacion = congregacion;
        this.persona = persona;
        this.achNumPublicaciones = achNumPublicaciones;
        this.achNumVideos = achNumVideos;
        this.achHrsMinisterio = achHrsMinisterio;
        this.achNumRevistas = achNumRevistas;
        this.achHrsEstudio = achHrsEstudio;
        this.achObservaciones = achObservaciones;
    }

//    GETTERS Y SETTERS
    public Integer getAchAnio() {
        return achAnio;
    }

    public void setAchAnio(Integer achAnio) {
        this.achAnio = achAnio;
    }

    public Integer getAchAnioServ() {
        return achAnioServ;
    }

    public void setAchAnioServ(Integer achAnioServ) {
        this.achAnioServ = achAnioServ;
    }

    public Integer getAchMes() {
        return achMes;
    }

    public void setAchMes(Integer achMes) {
        this.achMes = achMes;
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

    public es.rostan.hibernate.entidades.persona getPersona() {
        return persona;
    }

    public void setPersona(es.rostan.hibernate.entidades.persona persona) {
        this.persona = persona;
    }

    public Integer getAchNumPublicaciones() {
        return achNumPublicaciones;
    }

    public void setAchNumPublicaciones(Integer achNumPublicaciones) {
        this.achNumPublicaciones = achNumPublicaciones;
    }

    public Integer getAchNumVideos() {
        return achNumVideos;
    }

    public void setAchNumVideos(Integer achNumVideos) {
        this.achNumVideos = achNumVideos;
    }

    public Integer getAchHrsMinisterio() {
        return achHrsMinisterio;
    }

    public void setAchHrsMinisterio(Integer achHrsMinisterio) {
        this.achHrsMinisterio = achHrsMinisterio;
    }

    public Integer getAchNumRevistas() {
        return achNumRevistas;
    }

    public void setAchNumRevistas(Integer achNumRevistas) {
        this.achNumRevistas = achNumRevistas;
    }

    public Integer getAchHrsEstudio() {
        return achHrsEstudio;
    }

    public void setAchHrsEstudio(Integer achHrsEstudio) {
        this.achHrsEstudio = achHrsEstudio;
    }

    public String getAchObservaciones() {
        return achObservaciones;
    }

    public void setAchObservaciones(String achObservaciones) {
        this.achObservaciones = achObservaciones;
    }
}