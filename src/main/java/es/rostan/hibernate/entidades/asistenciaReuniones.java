package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import es.rostan.hibernate.entidades.reunion;

/**
 * Created by Rostan on 27/05/2017.
 */
@Entity
@Table(name = "asistenciaReuniones")
public class asistenciaReuniones implements Serializable {

    @Id
    @Column(length = 4)
    private Integer asrNumRegistro;

    @Column(length = 4)
    private Integer asrAnio;

    @Column(length = 4)
    private Integer asrAnioTeo;

    @Column(length = 10)
    private Integer asrMes;

    @Column
    private String cngCodigo;

    @Column(length = 4)
    private Integer asrNumReunion;

    @Column(length = 2)
    private String renCodigo;

    @Column(length = 10)
    private String asrSemana;

    @Column(length = 4)
    private Integer asrAsistencias;

    @Column
    private Date asrFecRegistro;

    @Column
    private String asrUsrRegistro;

    @Column
    private Date asrFecModifica;

    @Column
    private String asrUsrModifica;

//    RELACIONES
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cngCodigo", updatable = false, insertable = false,
            referencedColumnName = "cngCodigo")
    private congregacion congregacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "renCodigo", updatable = false, insertable = false,
            referencedColumnName = "renCodigo")
    private reunion reunion;

//    CONSTRUCTOR
    public asistenciaReuniones(){

    }

    public asistenciaReuniones(Integer asrNumRegistro, Integer asrAnio, Integer asrAnioTeo, Integer asrMes, Integer asrNumReunion, String asrSemana, Integer asrAsistencias, Date asrFecRegistro, String asrUsrRegistro, Date asrFecModifica, String asrUsrModifica, es.rostan.hibernate.entidades.congregacion congregacion, es.rostan.hibernate.entidades.reunion reunion) {
        this.asrNumRegistro = asrNumRegistro;
        this.asrAnio = asrAnio;
        this.asrAnioTeo = asrAnioTeo;
        this.asrMes = asrMes;
        this.asrNumReunion = asrNumReunion;
        this.asrSemana = asrSemana;
        this.asrAsistencias = asrAsistencias;
        this.asrFecRegistro = asrFecRegistro;
        this.asrUsrRegistro = asrUsrRegistro;
        this.asrFecModifica = asrFecModifica;
        this.asrUsrModifica = asrUsrModifica;
        this.congregacion = congregacion;
        this.reunion = reunion;

        this.cngCodigo = congregacion.getCngCodigo();
        this.renCodigo = reunion.getRenCodigo();
    }

    //    GETTER Y SETTERS
    public Integer getAsrNumRegistro() {
        return asrNumRegistro;
    }

    public void setAsrNumRegistro(Integer asrNumRegistro) {
        this.asrNumRegistro = asrNumRegistro;
    }

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

    public String getRenCodigo() {
        return renCodigo;
    }

    public void setRenCodigo(String renCodigo) {
        this.renCodigo = renCodigo;
    }

    public Date getAsrFecRegistro() {
        return asrFecRegistro;
    }

    public void setAsrFecRegistro(Date asrFecRegistro) {
        this.asrFecRegistro = asrFecRegistro;
    }

    public String getAsrUsrRegistro() {
        return asrUsrRegistro;
    }

    public void setAsrUsrRegistro(String asrUsrRegistro) {
        this.asrUsrRegistro = asrUsrRegistro;
    }

    public Date getAsrFecModifica() {
        return asrFecModifica;
    }

    public void setAsrFecModifica(Date asrFecModifica) {
        this.asrFecModifica = asrFecModifica;
    }

    public String getAsrUsrModifica() {
        return asrUsrModifica;
    }

    public void setAsrUsrModifica(String asrUsrModifica) {
        this.asrUsrModifica = asrUsrModifica;
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
