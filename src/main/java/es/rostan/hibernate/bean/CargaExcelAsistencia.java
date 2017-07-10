package es.rostan.hibernate.bean;

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
import java.util.Iterator;

/**
 * Created by HP on 06/06/2017.
 */
@ManagedBean
@ViewScoped
public class CargaExcelAsistencia implements Serializable {

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = null;
        try{
            lecturaExcelAsistencias(event.getFile().getInputstream());
            message = new FacesMessage("Mesaje del Sistema", event.getFile().getFileName() + " ha sido cargado exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }catch (IOException e){
            message = new FacesMessage("Mesaje del Sistema", event.getFile().getFileName() + ": Error cargando el archivo");
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println(e.toString());
        }
    }

    public void lecturaExcelAsistencias(InputStream input) throws IOException{

        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(0);   //  Pestaña a trabajar del Excel.
        Iterator<Row> rowIterator = sheet.iterator();
        int cont = 0;

        Row row;
        while(rowIterator.hasNext()){
            row = rowIterator.next();
            cont += 1;

            //  Creacion de la Horas Servicio
            row.getCell(1).getNumericCellValue();


//            Iterator<Cell> cellIterator = row.cellIterator();
//            Cell celda;
//            while (cellIterator.hasNext()){
//                celda = cellIterator.next();
//            }
        }

        System.out.println("Registros totales: " + String.valueOf(cont));
    }
}
