package es.rostan.hibernate.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Rostan on 27/05/2017.
 */
@Entity
@Table(name = "reunion")
public class reunion implements Serializable{

    @Id
    private String renCodigo;

    @Column
    private String renNombre;

    @Column
    private String renEstado;

    @OneToMany(mappedBy = "reunion", cascade = CascadeType.ALL)
    private Set<asistenciaReuniones> asistencias;

//    CONSTRUCTORES
    public reunion(){

    }

    public reunion(String renCodigo, String renNombre, String renEstado) {
        this.renCodigo = renCodigo;
        this.renNombre = renNombre;
        this.renEstado = renEstado;
    }

//    GETTER Y SETTERS
    public String getRenCodigo() {
        return renCodigo;
    }

    public void setRenCodigo(String renCodigo) {
        this.renCodigo = renCodigo;
    }

    public String getRenNombre() {
        return renNombre;
    }

    public void setRenNombre(String renNombre) {
        this.renNombre = renNombre;
    }

    public String getRenEstado() {
        return renEstado;
    }

    public void setRenEstado(String renEstado) {
        this.renEstado = renEstado;
    }

    public Set<asistenciaReuniones> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Set<asistenciaReuniones> asistencias) {
        this.asistencias = asistencias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof reunion)) return false;

        reunion reunion = (reunion) o;

        if (!getRenCodigo().equals(reunion.getRenCodigo())) return false;
        if (!getRenNombre().equals(reunion.getRenNombre())) return false;
        return getRenEstado().equals(reunion.getRenEstado());
    }

    @Override
    public int hashCode() {
        int result = getRenCodigo().hashCode();
        result = 31 * result + getRenNombre().hashCode();
        result = 31 * result + getRenEstado().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "reunion{" +
                "renCodigo='" + renCodigo + '\'' +
                ", renNombre='" + renNombre + '\'' +
                ", renEstado='" + renEstado + '\'' +
                '}';
    }
}
