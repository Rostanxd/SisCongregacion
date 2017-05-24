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
}
