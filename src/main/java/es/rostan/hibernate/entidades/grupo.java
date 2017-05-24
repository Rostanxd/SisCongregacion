package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Rostan on 21/05/2017.
 */
@Entity
@Table(name = "grupo")
public class grupo implements Serializable {

    @Id
    private String grpCodigo;

    @Column
    private String grpNombre;

    @Column
    private String grpEstado;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    Set<persona> personas;

//    CONSTRUCTORES
    public grupo(){

    }

    public grupo(String grpCodigo, String grpNombre, String grpEstado) {
        this.grpCodigo = grpCodigo;
        this.grpNombre = grpNombre;
        this.grpEstado = grpEstado;
    }

//    GETTER Y SETTERS

    public String getGrpCodigo() {
        return grpCodigo;
    }

    public void setGrpCodigo(String grpCodigo) {
        this.grpCodigo = grpCodigo;
    }

    public String getGrpNombre() {
        return grpNombre;
    }

    public void setGrpNombre(String grpNombre) {
        this.grpNombre = grpNombre;
    }

    public String getGrpEstado() {
        return grpEstado;
    }

    public void setGrpEstado(String grpEstado) {
        this.grpEstado = grpEstado;
    }
}