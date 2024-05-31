
package uis.edu.co.banco_de_sangre.modelo;

public class UnidadesDeSangre {
    private int idUnidadesSangre;
    private int donacion;
    private int tipoComponenteSanguineoId;
    private int estadoUnidadesId;
    private String fechaProcesamiento;

    public UnidadesDeSangre(int idUnidadesSangre, int donacion, int tipoComponenteSanguineoId, int estadoUnidadesId, String fechaProcesamiento) {
        this.idUnidadesSangre = idUnidadesSangre;
        this.donacion = donacion;
        this.tipoComponenteSanguineoId = tipoComponenteSanguineoId;
        this.estadoUnidadesId = estadoUnidadesId;
        this.fechaProcesamiento = fechaProcesamiento;
    }

    public int getIdUnidadesSangre() {
        return idUnidadesSangre;
    }

    public void setIdUnidadesSangre(int idUnidadesSangre) {
        this.idUnidadesSangre = idUnidadesSangre;
    }

    public int getDonacion() {
        return donacion;
    }

    public void setDonacion(int donacion) {
        this.donacion = donacion;
    }

    public int getTipoComponenteSanguineoId() {
        return tipoComponenteSanguineoId;
    }

    public void setTipoComponenteSanguineoId(int tipoComponenteSanguineoId) {
        this.tipoComponenteSanguineoId = tipoComponenteSanguineoId;
    }

    public int getEstadoUnidadesId() {
        return estadoUnidadesId;
    }

    public void setEstadoUnidadesId(int estadoUnidadesId) {
        this.estadoUnidadesId = estadoUnidadesId;
    }

    public String getFechaProcesamiento() {
        return fechaProcesamiento;
    }

    public void setFechaProcesamiento(String fechaProcesamiento) {
        this.fechaProcesamiento = fechaProcesamiento;
    }

    @Override
    public String toString() {
        return "UnidadesDeSangre{" + "idUnidadesSangre=" + idUnidadesSangre + ", donacion=" + donacion + ", tipoComponenteSanguineoId=" + tipoComponenteSanguineoId + ", estadoUnidadesId=" + estadoUnidadesId + ", fechaProcesamiento=" + fechaProcesamiento + '}';
    }
    
    
}
