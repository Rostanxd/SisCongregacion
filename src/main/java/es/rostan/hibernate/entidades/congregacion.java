package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Rostan on 21/05/2017.
 */
@Entity
@Table(name = "congregacion")
public class congregacion implements Serializable {

    @Id
    private String cngCodigo;

    @Column
    private String cngNombre;

    @Column
    private String cngEstado;

    @OneToMany(mappedBy = "congregacion", cascade = CascadeType.ALL)
    private Set<persona> personas;

//    CONSTRUCTORES
    public congregacion(){

    }

    public congregacion(String cngCodigo, String cngNombre, String cngEstado) {
        this.cngCodigo = cngCodigo;
        this.cngNombre = cngNombre;
        this.cngEstado = cngEstado;
    }

//    GETTER Y SETTERS

    public String getCngCodigo() {
        return cngCodigo;
    }

    public void setCngCodigo(String cngCodigo) {
        this.cngCodigo = cngCodigo;
    }

    public String getCngNombre() {
        return cngNombre;
    }

    public void setCngNombre(String cngNombre) {
        this.cngNombre = cngNombre;
    }

    public String getCngEstado() {
        return cngEstado;
    }

    public void setCngEstado(String cngEstado) {
        this.cngEstado = cngEstado;
    }

    @Override
    public String toString() {
        return "congregacion{" +
                "cngCodigo='" + cngCodigo + '\'' +
                ", cngNombre='" + cngNombre + '\'' +
                ", cngEstado='" + cngEstado + '\'' +
                ", personas=" + personas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        congregacion that = (congregacion) o;

        if (!cngCodigo.equals(that.cngCodigo)) return false;
        if (!cngNombre.equals(that.cngNombre)) return false;
        if (!cngEstado.equals(that.cngEstado)) return false;
        return personas.equals(that.personas);

    }

    @Override
    public int hashCode() {
        int result = cngCodigo.hashCode();
        result = 31 * result + cngNombre.hashCode();
        result = 31 * result + cngEstado.hashCode();
        result = 31 * result + personas.hashCode();
        return result;
    }
}
