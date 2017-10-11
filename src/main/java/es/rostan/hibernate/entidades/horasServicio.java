package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Rostan on 02/06/2017.
 */
@Entity
@Table(name = "horasServicio")
//@IdClass(horasServicioPK.class)
public class horasServicio implements Serializable{

    @Id
    @Column(length = 11)
    private Integer achNumRegistro;

    @Column(length = 4)
    private Integer achAnio;

    @Column(length = 4)
    private Integer achAnioServ;

    @Column(length = 2)
    private Integer achMes;

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

    private Date achFecRegistro;

    private String achUsrRegistro;

    private Date achFecModifica;

    private String achUsrModifica;

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

    public horasServicio(Integer achNumRegistro, Integer achAnio, Integer achAnioServ, Integer achMes, Integer achNumPublicaciones, Integer achNumVideos, Double achHrsMinisterio, Integer achNumRevistas, Double achHrsEstudio, String achObservaciones, String achPrsNombres, Date achFecRegistro, String achUsrRegistro, Date achFecModifica, String achUsrModifica, es.rostan.hibernate.entidades.congregacion congregacion, es.rostan.hibernate.entidades.persona persona) {
        this.achNumRegistro = achNumRegistro;
        this.achAnio = achAnio;
        this.achAnioServ = achAnioServ;
        this.achMes = achMes;
        this.achNumPublicaciones = achNumPublicaciones;
        this.achNumVideos = achNumVideos;
        this.achHrsMinisterio = achHrsMinisterio;
        this.achNumRevistas = achNumRevistas;
        this.achHrsEstudio = achHrsEstudio;
        this.achObservaciones = achObservaciones;
        this.achPrsNombres = achPrsNombres;
        this.achFecRegistro = achFecRegistro;
        this.achUsrRegistro = achUsrRegistro;
        this.achFecModifica = achFecModifica;
        this.achUsrModifica = achUsrModifica;
        this.congregacion = congregacion;
        this.persona = persona;

        this.cngCodigo = congregacion.getCngCodigo();
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

    public Date getAchFecRegistro() {
        return achFecRegistro;
    }

    public void setAchFecRegistro(Date achFecRegistro) {
        this.achFecRegistro = achFecRegistro;
    }

    public String getAchUsrRegistro() {
        return achUsrRegistro;
    }

    public void setAchUsrRegistro(String achUsrRegistro) {
        this.achUsrRegistro = achUsrRegistro;
    }

    public Date getAchFecModifica() {
        return achFecModifica;
    }

    public void setAchFecModifica(Date achFecModifica) {
        this.achFecModifica = achFecModifica;
    }

    public String getAchUsrModifica() {
        return achUsrModifica;
    }

    public void setAchUsrModifica(String achUsrModifica) {
        this.achUsrModifica = achUsrModifica;
    }

    @Override
    public String toString() {
        return "horasServicio{" +
                "achNumRegistro=" + achNumRegistro +
                ", achAnio=" + achAnio +
                ", achAnioServ=" + achAnioServ +
                ", achMes=" + achMes +
                ", cngCodigo='" + cngCodigo + '\'' +
                ", achNumPublicaciones=" + achNumPublicaciones +
                ", achNumVideos=" + achNumVideos +
                ", achHrsMinisterio=" + achHrsMinisterio +
                ", achNumRevistas=" + achNumRevistas +
                ", achHrsEstudio=" + achHrsEstudio +
                ", achObservaciones='" + achObservaciones + '\'' +
                ", achPrsNombres='" + achPrsNombres + '\'' +
                ", achFecRegistro=" + achFecRegistro +
                ", achUsrRegistro='" + achUsrRegistro + '\'' +
                ", achFecModifica=" + achFecModifica +
                ", achUsrModifica='" + achUsrModifica + '\'' +
                ", congregacion=" + congregacion +
                ", persona=" + persona +
                '}';
    }
}