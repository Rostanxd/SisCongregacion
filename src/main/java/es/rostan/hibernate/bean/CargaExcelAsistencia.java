package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.asistenciaReunionesDAO;
import es.rostan.hibernate.dao.congregacionDAO;
import es.rostan.hibernate.dao.reunionDAO;
import es.rostan.hibernate.entidades.asistenciaReuniones;
import es.rostan.hibernate.entidades.congregacion;
import es.rostan.servicio.Utils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rostan on 06/06/2017.
 */
@ManagedBean
@ViewScoped
public class CargaExcelAsistencia implements Serializable {

    private List<asistenciaReuniones> list = new ArrayList<>();

    private FacesMessage message;

    public void handleFileUpload(FileUploadEvent event) {
        try{
            if (lecturaExcelAsistencias(event.getFile().getInputstream())) {
                message = new FacesMessage("Mesaje del Sistema", event.getFile().getFileName() + " ha sido cargado exitosamente.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }catch (IOException e){
            message = new FacesMessage("Mesaje del Sistema", event.getFile().getFileName() + ": Error cargando el archivo");
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println(e.toString());
        }
    }

    public Boolean lecturaExcelAsistencias(InputStream input) throws IOException{

        boolean flag = false;
        list.clear();
        int cont = 0;

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(input);
            XSSFSheet sheet = workbook.getSheetAt(0);   //  Pestaña a trabajar del Excel.
            Iterator<Row> rowIterator = sheet.iterator();

            Row row;
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                cont += 1;
                if (cont != 1) {
                    if ((int) row.getCell(0).getNumericCellValue() == 0) {
                        break;
                    } else {
                        congregacionDAO cd = new congregacionDAO();
                        reunionDAO rd = new reunionDAO();

                        asistenciaReuniones ar = new asistenciaReuniones();

                        //  Creacion de la Asistencia a Reuniones
                        //  Pk's
                        ar.setAsrAnio((int) row.getCell(0).getNumericCellValue());
                        ar.setAsrAnioTeo((int) row.getCell(1).getNumericCellValue());
                        ar.setAsrMes(Utils.mesInt(row.getCell(2).getStringCellValue()));


                        ar.setAsrNumReunion((int) row.getCell(4).getNumericCellValue());
                        ar.setAsrSemana(row.getCell(6).getStringCellValue());
                        ar.setAsrAsistencias((int) row.getCell(7).getNumericCellValue());

                        //  FK's
                        ar.setCngCodigo(cd.buscaCongregacionPorNombre(row.getCell(3).getStringCellValue()).getCngCodigo());
                        ar.setCongregacion(cd.buscaCongregacionPorNombre(row.getCell(3).getStringCellValue()));
                        ar.setRenCodigo(rd.buscaReunionPorNombre(row.getCell(5).getStringCellValue()).getRenCodigo());
                        ar.setReunion(rd.buscaReunionPorNombre(row.getCell(5).getStringCellValue()));

                        list.add(ar);

                        System.out.println("Linea: " + String.valueOf(cont - 1) + " " + row.getCell(5).getStringCellValue());
                    }
                }
            }

            System.out.println("Registros totales: " + String.valueOf(cont));

//            Ingreso la lista de asistencia una vez que ya no tenga problemas de lectura con el excel.
            ingresarLista();

//            Devuelve TRUE si no hubo excepciones.
            flag = true;

        }catch (Exception ex){
            message = new FacesMessage("Mesaje del Sistema", "Error de lectura en la Fila :" + String.valueOf(cont -1));
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        return flag;
    }

    private void ingresarLista(){
        if (list.size() > 0) {
            for (asistenciaReuniones a : list) {
                asistenciaReunionesDAO ard = new asistenciaReunionesDAO();
                ard.ingresarAsistencia(a);
            }
        }
    }
}
