package es.rostan.hibernate.bean;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import es.rostan.hibernate.dao.personaDAO;
import es.rostan.hibernate.entidades.persona;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.primefaces.component.export.*;
import org.primefaces.component.export.*;

@ManagedBean(name = "registroPublicadorBean")
@ViewScoped
public class registroPublicacionBean {

    private List<persona> personas = new ArrayList<>();

    private persona personaSelected = new persona();

    private persona persona = new persona();

    private List<Integer> aniosServicio;

    private Integer anioServicio;

    private List<registroPublicador> registros = new ArrayList<>();

    @PostConstruct
    public void init(){
        this.cargarPersonas();
    }

    private void cargarPersonas(){
        personaDAO personaDAO = new personaDAO();
        this.personas = personaDAO.listarPersonas();
    }

    public void seleccionarPersona(persona persona){
        this.personaSelected = persona;
        this.aniosServicio();
    }

    private void aniosServicio(){
        personaDAO personaDAO = new personaDAO();
        this.aniosServicio = personaDAO.aniosServicioPersona(this.personaSelected);
    }

    public void loadRegistrosPublicador(){
        personaDAO personaDAO = new personaDAO();
        this.registros = personaDAO.registrosPublicadorPrs(this.anioServicio, this.personaSelected);
    }

    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
        HSSFCellStyle cellStyle = wb.createCellStyle();
        cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
            header.getCell(i).setCellStyle(cellStyle);
        }
    }

    public void preProcessPDF(Object document) throws IOException,
            BadElementException, DocumentException {
        Document pdf = (Document) document;
        ServletContext servletContext = (ServletContext)
                FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "images" +
                File.separator + "prime_logo.png";
        pdf.add(Image.getInstance(logo));
    }

//    GETTER Y SETTER
    public List<persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<persona> personas) {
        this.personas = personas;
    }

    public persona getPersonaSelected() {
        return personaSelected;
    }

    public void setPersonaSelected(persona personaSelected) {
        this.personaSelected = personaSelected;
    }

    public es.rostan.hibernate.entidades.persona getPersona() {
        return persona;
    }

    public void setPersona(es.rostan.hibernate.entidades.persona persona) {
        this.persona = persona;
    }

    public List<Integer> getAniosServicio() {
        return aniosServicio;
    }

    public void setAniosServicio(List<Integer> aniosServicio) {
        this.aniosServicio = aniosServicio;
    }

    public Integer getAnioServicio() {
        return anioServicio;
    }

    public void setAnioServicio(Integer anioServicio) {
        this.anioServicio = anioServicio;
    }

    public List<registroPublicador> getRegistros() {
        return registros;
    }

    public void setRegistros(List<registroPublicador> registros) {
        this.registros = registros;
    }
}
