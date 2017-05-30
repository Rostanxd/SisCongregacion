package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Rostan on 21/05/2017.
 */
@Entity
@Table(name = "privilegio")
public class privilegio implements Serializable {

    @Id
    private String prvCodigo;

    @Column
    private String prvNombre;

    @Column
    private String prvEstado;

    @OneToMany(mappedBy = "privilegio", cascade = CascadeType.ALL)
    private Set<persona> personas;

//    CONSTRUCTORES
    public privilegio(){

    }

    public privilegio(String prvCodigo, String prvNombre, String prvEstado) {
        this.prvCodigo = prvCodigo;
        this.prvNombre = prvNombre;
        this.prvEstado = prvEstado;
    }

//    GETTER Y SETTERS
    public String getPrvCodigo() {
        return prvCodigo;
    }

    public void setPrvCodigo(String prvCodigo) {
        this.prvCodigo = prvCodigo;
    }

    public String getPrvNombre() {
        return prvNombre;
    }

    public void setPrvNombre(String prvNombre) {
        this.prvNombre = prvNombre;
    }

    public String getPrvEstado() {
        return prvEstado;
    }

    public void setPrvEstado(String prvEstado) {
        this.prvEstado = prvEstado;
    }

    @Override
    public String toString() {
        return "privilegio{" +
                "prvCodigo='" + prvCodigo + '\'' +
                ", prvNombre='" + prvNombre + '\'' +
                ", prvEstado='" + prvEstado + '\'' +
                ", personas=" + personas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof privilegio)) return false;

        privilegio that = (privilegio) o;

        if (!getPrvCodigo().equals(that.getPrvCodigo())) return false;
        if (!getPrvNombre().equals(that.getPrvNombre())) return false;
        return getPrvEstado().equals(that.getPrvEstado());
    }

    @Override
    public int hashCode() {
        int result = getPrvCodigo().hashCode();
        result = 31 * result + getPrvNombre().hashCode();
        result = 31 * result + getPrvEstado().hashCode();
        return result;
    }
}
