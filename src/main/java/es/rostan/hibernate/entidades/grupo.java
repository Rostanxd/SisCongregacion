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

    @Override
    public String toString() {
        return "grupo{" +
                "grpCodigo='" + grpCodigo + '\'' +
                ", grpNombre='" + grpNombre + '\'' +
                ", grpEstado='" + grpEstado + '\'' +
                ", personas=" + personas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        grupo grupo = (grupo) o;

        if (!grpCodigo.equals(grupo.grpCodigo)) return false;
        if (!grpNombre.equals(grupo.grpNombre)) return false;
        if (!grpEstado.equals(grupo.grpEstado)) return false;
        return personas.equals(grupo.personas);

    }

    @Override
    public int hashCode() {
        int result = grpCodigo.hashCode();
        result = 31 * result + grpNombre.hashCode();
        result = 31 * result + grpEstado.hashCode();
        result = 31 * result + personas.hashCode();
        return result;
    }
}
