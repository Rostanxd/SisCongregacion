package es.rostan.hibernate.bean;

import es.rostan.hibernate.dao.horasServicioDAO;
import es.rostan.hibernate.entidades.horasServicio;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Rostan on 02/06/2017.
 */
@ManagedBean(name = "hrsServicioBean")
@ViewScoped
public class horasServicioBean implements Serializable{

    private horasServicio hrsServicio = new horasServicio();

    private horasServicio hrsServicioSelected = new horasServicio();

    private List<horasServicio> lstHrsServicio = new ArrayList<>();

    private Map<Integer, String> lstMeses = new HashMap<>();

    private String mesSelected;

    private String btnAccion;

    private FacesMessage message;

    private String pdfPath = "C:/Users/HP/Documents/Programming/Java/Projects/FHaro/Documentacion/Registro.pdf";

//    CONSTRUCTOR
    public horasServicioBean(){

    }

    @PostConstruct
    public void init(){
//        Enlistar Meses
        lstMeses = new HashMap<Integer, String>();
        lstMeses.put(1, "Enero");
        lstMeses.put(2, "Febrero");
        lstMeses.put(3, "Marzo");
        lstMeses.put(4, "Abril");
        lstMeses.put(5, "Mayo");
        lstMeses.put(6, "Junio");
        lstMeses.put(7, "Julio");
        lstMeses.put(8, "Agosto");
        lstMeses.put(9, "Septiembre");
        lstMeses.put(10, "Octubre");
        lstMeses.put(11, "Noviembre");
        lstMeses.put(12, "Dciembre");
    }

    public horasServicio getHrsServicio() {
        return hrsServicio;
    }

    public void setHrsServicio(horasServicio hrsServicio) {
        this.hrsServicio = hrsServicio;
    }

    public horasServicio getHrsServicioSelected() {
        return hrsServicioSelected;
    }

    public void setHrsServicioSelected(horasServicio hrsServicioSelected) {
        this.hrsServicioSelected = hrsServicioSelected;
    }

    public List<horasServicio> getLstHrsServicio() {
        return lstHrsServicio;
    }

    public void setLstHrsServicio(List<horasServicio> lstHrsServicio) {
        this.lstHrsServicio = lstHrsServicio;
    }

    public Map<Integer, String> getLstMeses() {
        return lstMeses;
    }

    public void setLstMeses(Map<Integer, String> lstMeses) {
        this.lstMeses = lstMeses;
    }

    public String getMesSelected() {
        return mesSelected;
    }

    public void setMesSelected(String mesSelected) {
        this.mesSelected = mesSelected;
    }

    public String getBtnAccion() {
        return btnAccion;
    }

    public void setBtnAccion(String btnAccion) {
        this.btnAccion = btnAccion;
        switch (this.btnAccion){
            case "Ingresar":
                this.limpiar();
                break;
            case "Actualizar":
                this.hrsServicioSelected = this.hrsServicio;
                break;
        }
    }

//    METODOS
    public void listarHrsServicio(){
        horasServicioDAO hrd = new horasServicioDAO();
        this.lstHrsServicio = hrd.lstHrsServicios();
    }

    public void ingresarHrsServicio() {
        System.out.println("Congregacion seleccionada..." + this.hrsServicioSelected.getCongregacion().getCngNombre());
        this.hrsServicioSelected.setAchMes(this.buscaMesId(this.mesSelected));
        horasServicioDAO hrd = new horasServicioDAO();
        hrd.ingresarHrsServicio(this.hrsServicioSelected);
    }

    public void actualizarHrsServicio(){
        horasServicioDAO hrd = new horasServicioDAO();
        try{
            hrd.actualizarHrsServicio(this.hrsServicioSelected);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }

    public void operar(){
        switch (btnAccion){
            case "Ingresar":
                this.ingresarHrsServicio();
                this.limpiar();
                break;
            case "Actualizar":
                this.actualizarHrsServicio();
                this.limpiar();
                break;
        }
    }

    public void limpiar(){
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        this.hrsServicioSelected.setAchAnio(year);
        this.hrsServicioSelected.setAchAnioServ(year);
        this.hrsServicioSelected.setCongregacion(null);
        this.hrsServicioSelected.setAchMes(0);
        this.hrsServicioSelected.setPersona(null);
        this.hrsServicioSelected.setAchNumPublicaciones(0);
        this.hrsServicioSelected.setAchNumVideos(0);
        this.hrsServicioSelected.setAchHrsMinisterio(0.0);
        this.hrsServicioSelected.setAchNumRevistas(0);
        this.hrsServicioSelected.setAchHrsEstudio(0.0);
        this.hrsServicioSelected.setAchObservaciones("");
    }

    public Integer buscaMesId(String mes){
        Integer key = 0;
        for (Map.Entry<Integer, String> e : this.lstMeses.entrySet()){
            if (e.getValue().equals(mes)){
                key = e.getKey();
                break;
            }
        }
        return key;
    }

    public String buscaMesNombre(Integer mes){
        String mesNombre = "";

        for (Map.Entry<Integer, String> e : this.lstMeses.entrySet()){
            if (e.getKey().equals(mes)){
                mesNombre = e.getValue();
                break;
            }
        }
        return mesNombre;
    }

    public void imprimirRegistroHrs() {
//        Create a new empty document
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage( page );

//        Create a new blank page and add it to the document
        PDPage blankPage = new PDPage();
        document.addPage( blankPage );

        try {
//            Start a new content stream which will "hold" the to be created content
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

//            Create a new font object selecting one of the PDF base fonts
            PDFont font = PDType1Font.HELVETICA_BOLD;

//            Define a text content stream using the selected font, moving the cursor and drawing the text "Hello World"
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount( 100, 700 );
            contentStream.drawString( "Hello World" );
            contentStream.endText();

//            Make sure that the content stream is closed:
            contentStream.close();

//            Save the newly created document
            document.save(this.pdfPath);

//            finally make sure that the document is properly closed.
            document.close();

            System.out.println("PDF creado!");

        } catch (IOException e) {
            e.printStackTrace();

//            Muestra el mensaje de error.
            message = new FacesMessage("Mesaje del Sistema", e.toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
