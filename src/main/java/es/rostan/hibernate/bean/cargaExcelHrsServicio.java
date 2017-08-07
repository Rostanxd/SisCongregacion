package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.congregacionDAO;
import es.rostan.hibernate.dao.horasServicioDAO;
import es.rostan.hibernate.entidades.congregacion;
import es.rostan.hibernate.entidades.horasServicio;
import es.rostan.servicio.Utils;
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
            lecturaExcelHrsServicio(event.getFile().getInputstream());
            message = new FacesMessage("Mesaje del Sistema", event.getFile().getFileName() + " ha sido cargado exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }catch (IOException e){
            message = new FacesMessage("Mesaje del Sistema", event.getFile().getFileName() + ": Error cargando el archivo");
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println(e.toString());
        }
    }

    public void lecturaExcelHrsServicio(InputStream input) throws IOException{

        XSSFWorkbook workbook = new XSSFWorkbook(input);
        XSSFSheet sheet = workbook.getSheetAt(0);   //  Pestaña a trabajar del Excel.
        Iterator<Row> rowIterator = sheet.iterator();
        int cont = 0;

        Row row;
        while(rowIterator.hasNext()){
            row = rowIterator.next();
            cont += 1;

            if (cont != 1) {

                if ((int) row.getCell(0).getNumericCellValue() == 0){
                    break;
                }else {
                    congregacionDAO cd = new congregacionDAO();

                    horasServicio hs = new horasServicio();

                    //  Creacion de la Horas Servicio
                    //  PK's
                    hs.setAchAnio((int) row.getCell(0).getNumericCellValue());
                    hs.setAchAnioServ((int) row.getCell(1).getNumericCellValue());
                    hs.setAchMes(Utils.mesInt(row.getCell(2).getStringCellValue()));
                    hs.setAchNumRegistro(cont - 1);

                    hs.setPersona(null);
                    hs.setAchPrsNombres(row.getCell(4).getStringCellValue());
                    hs.setAchNumPublicaciones((int) row.getCell(5).getNumericCellValue());

                    hs.setAchNumVideos((int) row.getCell(6).getNumericCellValue());
                    hs.setAchHrsMinisterio(row.getCell(7).getNumericCellValue());
                    hs.setAchNumRevistas((int) row.getCell(8).getNumericCellValue());
                    hs.setAchHrsEstudio(row.getCell(9).getNumericCellValue());
                    hs.setAchObservaciones(row.getCell(10).getStringCellValue());

//                    FK's
                    hs.setCngCodigo(cd.buscaCongregacionPorNombre(row.getCell(3).getStringCellValue()).getCngCodigo());
                    hs.setCongregacion(cd.buscaCongregacionPorNombre(row.getCell(3).getStringCellValue()));

                    horasServicioDAO hsd = new horasServicioDAO();
                    hsd.ingresarHrsServicio(hs);

                    System.out.println("Linea: " + String.valueOf(cont) + " " + row.getCell(4).getStringCellValue());
                }
            }
        }

        System.out.println("Registros totales: " + String.valueOf(cont));
    }
}
