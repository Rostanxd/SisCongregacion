package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Rostan on 27/05/2017.
 */
@Embeddable
public class asistenciaReunionesPK implements Serializable{

    @Column
    private Integer asrAnio;

    @Column
    private Integer asrAnioTeo;

    @Column
    private Integer asrMes;

    @Column
    private String cngCodigo;

//    CONSTRUCTOR
    public asistenciaReunionesPK(){

    }

    public asistenciaReunionesPK(Integer asrAnio, Integer asrAnioTeo, Integer asrMes, String cngCodigo) {
        this.asrAnio = asrAnio;
        this.asrAnioTeo = asrAnioTeo;
        this.asrMes = asrMes;
        this.cngCodigo = cngCodigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof asistenciaReunionesPK)) return false;

        asistenciaReunionesPK that = (asistenciaReunionesPK) o;

        if (!asrAnio.equals(that.asrAnio)) return false;
        if (!asrAnioTeo.equals(that.asrAnioTeo)) return false;
        if (!asrMes.equals(that.asrMes)) return false;
        return cngCodigo.equals(that.cngCodigo);
    }

    @Override
    public int hashCode() {
        int result = asrAnio.hashCode();
        result = 31 * result + asrAnioTeo.hashCode();
        result = 31 * result + asrMes.hashCode();
        result = 31 * result + cngCodigo.hashCode();
        return result;
    }
}
