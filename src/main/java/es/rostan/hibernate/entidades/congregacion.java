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
    @Column(length = 2)
    private String cngCodigo;

    @Column(length = 80)
    private String cngNombre;

    @Column(length = 1)
    private String cngEstado;

    @OneToMany(mappedBy = "congregacion", cascade = CascadeType.ALL)
    private Set<persona> personas;

    @OneToMany(mappedBy = "congregacion", cascade = CascadeType.ALL)
    private Set<asistenciaReuniones> asistencias;

    @OneToMany(mappedBy = "congregacion", cascade = CascadeType.ALL)
    private Set<horasServicio> horasServicios;

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
                ", personas={" + personas.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof congregacion)) return false;

        congregacion that = (congregacion) o;

        if (!getCngCodigo().equals(that.getCngCodigo())) return false;
        if (!getCngNombre().equals(that.getCngNombre())) return false;
        return getCngEstado().equals(that.getCngEstado());
    }

    @Override
    public int hashCode() {
        int result = getCngCodigo().hashCode();
        result = 31 * result + getCngNombre().hashCode();
        result = 31 * result + getCngEstado().hashCode();
        return result;
    }
}
