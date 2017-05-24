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
}
