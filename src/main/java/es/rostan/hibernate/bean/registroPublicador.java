package es.rostan.hibernate.bean;

public class registroPublicador {

    private Integer mesOrden;

    private String mesNombre;

    private Integer numPublicaciones;

    private Integer numVideos;

    private Integer numHoras;

    private Integer numRevistas;

    private Integer numCursos;

    public registroPublicador() {

    }

    public registroPublicador(Integer mesOrden, String mesNombre, Integer numPublicaciones, Integer numVideos, Integer numHoras, Integer numRevistas, Integer numCursos) {
        this.mesOrden = mesOrden;
        this.mesNombre = mesNombre;
        this.numPublicaciones = numPublicaciones;
        this.numVideos = numVideos;
        this.numHoras = numHoras;
        this.numRevistas = numRevistas;
        this.numCursos = numCursos;
    }

//    GETTER Y SETTER
    public Integer getMesOrden() {
        return mesOrden;
    }

    public void setMesOrden(Integer mesOrden) {
        this.mesOrden = mesOrden;
    }

    public String getMesNombre() {
        return mesNombre;
    }

    public void setMesNombre(String mesNombre) {
        this.mesNombre = mesNombre;
    }

    public Integer getNumPublicaciones() {
        return numPublicaciones;
    }

    public void setNumPublicaciones(Integer numPublicaciones) {
        this.numPublicaciones = numPublicaciones;
    }

    public Integer getNumVideos() {
        return numVideos;
    }

    public void setNumVideos(Integer numVideos) {
        this.numVideos = numVideos;
    }

    public Integer getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(Integer numHoras) {
        this.numHoras = numHoras;
    }

    public Integer getNumRevistas() {
        return numRevistas;
    }

    public void setNumRevistas(Integer numRevistas) {
        this.numRevistas = numRevistas;
    }

    public Integer getNumCursos() {
        return numCursos;
    }

    public void setNumCursos(Integer numCursos) {
        this.numCursos = numCursos;
    }
}
