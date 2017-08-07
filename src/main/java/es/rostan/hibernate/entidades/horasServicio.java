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
    @Column(length = 4)
    private Integer achAnio;

    @Id
    @Column(length = 4)
    private Integer achAnioServ;

    @Id
    @Column(length = 2)
    private Integer achMes;

    @Id
    @Column(length = 11)
    private Integer achNumRegistro;

    @Id
    @Column(length = 2)
    private String cngCodigo;

    @Column(length = 7)
    private Integer achNumPublicaciones;

    @Column(length = 7)
    private Integer achNumVideos;

    @Column(length = 7, precision = 2)
    private Double achHrsMinisterio;

    @Column(length = 7)
    private Integer achNumRevistas;

    @Column(length = 7, precision = 2)
    private Double achHrsEstudio;

    @Column(length = 150)
    private String achObservaciones;

    @Column(length = 80)
    private String achPrsNombres;

//    RELACIONES
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cngCodigo", updatable = false, insertable = false,
            referencedColumnName = "cngCodigo")
    private congregacion congregacion;

    @OneToOne
    @JoinColumn(name = "prsCodigo")
    private persona persona;

//    CONSTRUCTOR
    public horasServicio(){

    }

    public horasServicio(Integer achAnio, Integer achAnioServ, Integer achMes, String cngCodigo, es.rostan.hibernate.entidades.congregacion congregacion, es.rostan.hibernate.entidades.persona persona, Integer achNumPublicaciones, Integer achNumVideos, Double achHrsMinisterio, Integer achNumRevistas, Double achHrsEstudio, String achObservaciones) {
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

    public horasServicio(Integer achAnio, Integer achAnioServ, Integer achMes, String cngCodigo, es.rostan.hibernate.entidades.congregacion congregacion, es.rostan.hibernate.entidades.persona persona, Integer achNumPublicaciones, Integer achNumVideos, Double achHrsMinisterio, Integer achNumRevistas, Double achHrsEstudio, String achObservaciones, String achPrsNombres) {
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
        this.achPrsNombres = achPrsNombres;
    }

    public horasServicio(Integer achAnio, Integer achAnioServ, Integer achMes, Integer achNumRegistro, String cngCodigo, es.rostan.hibernate.entidades.congregacion congregacion, es.rostan.hibernate.entidades.persona persona, Integer achNumPublicaciones, Integer achNumVideos, Double achHrsMinisterio, Integer achNumRevistas, Double achHrsEstudio, String achObservaciones, String achPrsNombres) {
        this.achAnio = achAnio;
        this.achAnioServ = achAnioServ;
        this.achMes = achMes;
        this.achNumRegistro = achNumRegistro;
        this.cngCodigo = cngCodigo;
        this.congregacion = congregacion;
        this.persona = persona;
        this.achNumPublicaciones = achNumPublicaciones;
        this.achNumVideos = achNumVideos;
        this.achHrsMinisterio = achHrsMinisterio;
        this.achNumRevistas = achNumRevistas;
        this.achHrsEstudio = achHrsEstudio;
        this.achObservaciones = achObservaciones;
        this.achPrsNombres = achPrsNombres;
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

    public Double getAchHrsMinisterio() {
        return achHrsMinisterio;
    }

    public void setAchHrsMinisterio(Double achHrsMinisterio) {
        this.achHrsMinisterio = achHrsMinisterio;
    }

    public Integer getAchNumRevistas() {
        return achNumRevistas;
    }

    public void setAchNumRevistas(Integer achNumRevistas) {
        this.achNumRevistas = achNumRevistas;
    }

    public Double getAchHrsEstudio() {
        return achHrsEstudio;
    }

    public void setAchHrsEstudio(Double achHrsEstudio) {
        this.achHrsEstudio = achHrsEstudio;
    }

    public String getAchObservaciones() {
        return achObservaciones;
    }

    public void setAchObservaciones(String achObservaciones) {
        this.achObservaciones = achObservaciones;
    }

    public String getAchPrsNombres() {
        return achPrsNombres;
    }

    public void setAchPrsNombres(String achPrsNombres) {
        this.achPrsNombres = achPrsNombres;
    }

    public Integer getAchNumRegistro() {
        return achNumRegistro;
    }

    public void setAchNumRegistro(Integer achNumRegistro) {
        this.achNumRegistro = achNumRegistro;
    }
}