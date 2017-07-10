package es.rostan.hibernate.entidades;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Rostan on 02/06/2017.
 */
@Embeddable
public class horasServicioPK implements Serializable{

    @Column
    private Integer achAnio;

    @Column
    private Integer achAnioServ;

    @Column
    private Integer achMes;

    @Column
    private String cngCodigo;

    @Column
    private Integer achNumRegistro;

//    CONSTRUCTOR
    public horasServicioPK(){

    }

    public horasServicioPK(Integer achAnio, Integer achAnioServ, Integer achMes, String cngCodigo, Integer achNumRegistro) {
        this.achAnio = achAnio;
        this.achAnioServ = achAnioServ;
        this.achMes = achMes;
        this.cngCodigo = cngCodigo;
        this.achNumRegistro = achNumRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof horasServicioPK)) return false;

        horasServicioPK that = (horasServicioPK) o;

        if (!achAnio.equals(that.achAnio)) return false;
        if (!achAnioServ.equals(that.achAnioServ)) return false;
        if (!achMes.equals(that.achMes)) return false;
        if (!cngCodigo.equals(that.cngCodigo)) return false;
        return achNumRegistro.equals(that.achNumRegistro);
    }

    @Override
    public int hashCode() {
        int result = achAnio.hashCode();
        result = 31 * result + achAnioServ.hashCode();
        result = 31 * result + achMes.hashCode();
        result = 31 * result + cngCodigo.hashCode();
        result = 31 * result + achNumRegistro.hashCode();
        return result;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof horasServicioPK)) return false;
//
//        horasServicioPK that = (horasServicioPK) o;
//
//        if (!achAnio.equals(that.achAnio)) return false;
//        if (!achAnioServ.equals(that.achAnioServ)) return false;
//        if (!achMes.equals(that.achMes)) return false;
//        return cngCodigo.equals(that.cngCodigo);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = achAnio.hashCode();
//        result = 31 * result + achAnioServ.hashCode();
//        result = 31 * result + achMes.hashCode();
//        result = 31 * result + cngCodigo.hashCode();
//        return result;
//    }
}
