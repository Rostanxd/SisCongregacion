package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.*;
import es.rostan.hibernate.entidades.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omnifaces.util.Faces;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rostan on 06/06/2017.
 */
@ManagedBean
@ViewScoped
public class CargaExcelPersonas implements Serializable {

    private List<persona> list = new ArrayList<>();

    private FacesMessage message;

    public void handleFileUpload(FileUploadEvent event) {
        try{
            lecturaExcelPersonas(event.getFile().getInputstream());
            ingresarLista();
            message = new FacesMessage("Mesaje del Sistema", event.getFile().getFileName() + " ha sido cargado exitosamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);

        }catch (IOException e){
            message = new FacesMessage("Mesaje del Sistema", event.getFile().getFileName() + ": Error cargando el archivo");
            FacesContext.getCurrentInstance().addMessage(null, message);
            System.out.println(e.toString());
        }
    }

    private void lecturaExcelPersonas(InputStream input) throws IOException{
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
                    if (row.getCell(0).getStringCellValue().equals("")) {
                        break;
                    } else {
                        congregacionDAO cd = new congregacionDAO();
                        grupoDAO gd = new grupoDAO();
                        privilegioDAO vd = new privilegioDAO();
                        persona persona = new persona();

                        //  Creacion de la Persona
                        //  Pk's
                        String prsCodigo = row.getCell(0).getStringCellValue();
                        persona.setPrsCodigo(prsCodigo);

                        //  Fk's
                        congregacion congregacion = cd.buscaCongregacion(row.getCell(1).getStringCellValue());
                        if (congregacion != null){
                            persona.setCongregacion(congregacion);
                        }

                        grupo grupo = gd.buscaGrupo(row.getCell(2).getStringCellValue());
                        if (grupo != null){
                            persona.setGrupo(grupo);
                        }

                        privilegio privilegio = vd.buscaPrivilegio(row.getCell(3).getStringCellValue());
                        if (privilegio != null) {
                            persona.setPrivilegio(privilegio);
                        }

                        //  Atributos
                        String prsNombres = row.getCell(4).getStringCellValue();
                        String prsApellidos = row.getCell(5).getStringCellValue();
                        String prsDireccion = row.getCell(7).getStringCellValue();
                        String prsGenero = row.getCell(6).getStringCellValue();
                        String prsTelefono = row.getCell(8).getStringCellValue();
                        String prsCelular = row.getCell(9).getStringCellValue();
                        Date prsFecNacimiento = row.getCell(10).getDateCellValue();
                        Date prsFecBautismo = row.getCell(11).getDateCellValue();
                        String prsEstado = row.getCell(12).getStringCellValue();

                        persona.setPrsNombres(prsNombres);
                        persona.setPrsApellidos(prsApellidos);
                        persona.setPrsGenero(prsGenero);
                        persona.setPrsDireccion(prsDireccion);
                        persona.setPrsTelefono(prsTelefono);
                        persona.setPrsCelular(prsCelular);
                        persona.setPrsFecNacimiento(prsFecNacimiento);
                        persona.setPrsFecBautismo(prsFecBautismo);
                        persona.setPrsEstado(prsEstado);

                        list.add(persona);
                    }
                }
            }

            System.out.println("Registros totales: " + String.valueOf(cont));
        }catch (Exception ex){
            ex.getStackTrace();
            message = new FacesMessage("Mesaje del Sistema", "Error de lectura en la Fila :" + String.valueOf(cont -1));
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void descargarPlantilla(){
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        try {
            File file = new File(servletContext.getRealPath("excel/Personas_template.xlsx"));
            System.out.println(file.getPath());
            Faces.sendFile(file, true);
            message = new FacesMessage("Mesaje del Sistema", "Plantilla descargada correctamente.");
            FacesContext.getCurrentInstance().addMessage(null, message);

        }catch (IOException ie){
            System.out.println(ie.toString());
            message = new FacesMessage("Mesaje del Sistema", "El sistema no encuentra el archivo de platilla.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }catch (Exception e){
            System.out.println(e.toString());
            message = new FacesMessage("Mesaje del Sistema", "Error no controlado.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }finally {
            RequestContext.getCurrentInstance().update("messages");
        }
    }

    private void ingresarLista(){
        if (list.size() > 0) {
            for (persona p : list) {
                try {
                    personaDAO pd = new personaDAO();
//                    if (pd.buscarPersona(p.getPrsCodigo()) == null) {
                        pd.ingresarPersona(p);
//                    }
                }catch (Exception e){
                    e.getStackTrace();
                    message = new FacesMessage("Mesaje del Sistema", "Error ingreando el registro con id: " + p.getPrsCodigo());
                    FacesContext.getCurrentInstance().addMessage(null, message);
                }
            }
        }
    }
}
