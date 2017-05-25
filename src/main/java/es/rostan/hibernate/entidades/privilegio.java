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
    Set<persona> personas;

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
        if (o == null || getClass() != o.getClass()) return false;

        privilegio that = (privilegio) o;

        if (!prvCodigo.equals(that.prvCodigo)) return false;
        if (!prvNombre.equals(that.prvNombre)) return false;
        if (!prvEstado.equals(that.prvEstado)) return false;
        return personas.equals(that.personas);

    }

    @Override
    public int hashCode() {
        int result = prvCodigo.hashCode();
        result = 31 * result + prvNombre.hashCode();
        result = 31 * result + prvEstado.hashCode();
        result = 31 * result + personas.hashCode();
        return result;
    }
}
