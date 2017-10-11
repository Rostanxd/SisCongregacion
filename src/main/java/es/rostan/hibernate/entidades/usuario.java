package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class usuario {

    @Id
    @Column(name = "usrCodigo", length = 10)
    private String id;

    @Column(name = "usrClave", length = 10)
    private String clave;

    @Column(name = "usrEstado", length = 1)
    private String estado;

    public usuario() {
    }

    public usuario(String id, String clave) {
        this.id = id;
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "id='" + id + '\'' +
                ", clave='" + clave + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    //    GETTER Y SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
