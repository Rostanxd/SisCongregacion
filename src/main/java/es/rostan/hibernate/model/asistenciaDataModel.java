package es.rostan.hibernate.model;

import es.rostan.hibernate.entidades.asistenciaReuniones;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Created by Rostan on 02/06/2017.
 */
public class asistenciaDataModel extends ListDataModel<asistenciaReuniones> implements SelectableDataModel<asistenciaReuniones> {

    public asistenciaDataModel(){

    }

    public asistenciaDataModel(List<asistenciaReuniones> data){
        super(data);
    }

    @Override
    public Object getRowKey(asistenciaReuniones asistenciaReuniones) {
        return null;
    }

    @Override
    public asistenciaReuniones getRowData(String s) {
//        List<asistenciaReuniones> lstAsistenciaReuniones = (List<asistenciaReuniones>) getWrappedData();
//
//        for(asistenciaReuniones a : lstAsistenciaReuniones) {
//            if(asistenciaReuniones  .equals(s))
//                return a;
//        }
        return null;
    }
}
