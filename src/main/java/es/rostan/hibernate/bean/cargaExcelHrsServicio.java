package es.rostan.hibernate.bean;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import es.rostan.hibernate.dao.congregacionDAO;
import es.rostan.hibernate.dao.horasServicioDAO;
import es.rostan.hibernate.entidades.congregacion;
import es.rostan.hibernate.entidades.horasServicio;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by Rostan on 06/06/2017.
 */
@ManagedBean
@ViewScoped
public class cargaExcelHrsServicio implements Serializable {

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

        congregacion c = new congregacion();
        congregacionDAO cd = new congregacionDAO();
        c = cd.buscaCongregacion("1");

        Row row;
        while(rowIterator.hasNext()){
            row = rowIterator.next();
            cont += 1;

            if (cont != 1) {

                if ((int) row.getCell(0).getNumericCellValue() == 0){
                    break;
                }else {
                    horasServicio hs = new horasServicio();

                    //  Creacion de la Horas Servicio
                    //  PK's
                    hs.setAchAnio((int) row.getCell(0).getNumericCellValue());
                    hs.setAchAnioServ((int) row.getCell(1).getNumericCellValue());
                    hs.setAchMes(mesInt(row.getCell(2).getStringCellValue()));
                    hs.setAchNumRegistro(cont - 1);
                    hs.setCongregacion(c);

                    hs.setPersona(null);
                    hs.setAchPrsNombres(row.getCell(4).getStringCellValue());
                    hs.setAchNumPublicaciones((int) row.getCell(5).getNumericCellValue());

                    hs.setAchNumVideos((int) row.getCell(6).getNumericCellValue());
                    hs.setAchHrsMinisterio(row.getCell(7).getNumericCellValue());
                    hs.setAchNumRevistas((int) row.getCell(8).getNumericCellValue());
                    hs.setAchHrsEstudio(row.getCell(9).getNumericCellValue());
                    hs.setAchObservaciones(row.getCell(10).getStringCellValue());

                    horasServicioDAO hsd = new horasServicioDAO();
                    hsd.ingresarHrsServicio(hs);

                    System.out.println("Linea: " + String.valueOf(cont - 1) + " " + row.getCell(4).getStringCellValue());
                }
            }else{
                //  Titulos del Excel
            }
        }

        System.out.println("Registros totales: " + String.valueOf(cont));
    }

    private int mesInt(String mesString){
        int mes = 0;
        switch (mesString){
            case "Enero":
                mes = 1;
                break;
            case "Febrero":
                mes = 2;
                break;
            case "Marzo":
                mes = 3;
                break;
            case "Abril":
                mes = 4;
                break;
            case "Mayo":
                mes = 5;
                break;
            case "Junio":
                mes = 6;
                break;
            case "Julio":
                mes = 7;
                break;
            case "Agosto":
                mes = 8;
                break;
            case "Septiembre":
                mes = 9;
                break;
            case "Octubre":
                mes = 10;
                break;
            case "Noviembre":
                mes = 11;
                break;
            case "Diciembre":
                mes = 12;
                break;
        }
        return mes;
    }
}
