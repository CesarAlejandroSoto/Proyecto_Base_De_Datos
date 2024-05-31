package uis.edu.co.banco_de_sangre.modelo;

import java.sql.Date;

public class Donante {
    private int idDonante;
    private String nombre;
    private String apellido;
    private String documento;
    private int grupoSanguineoId;
    private String fechaUltimaDonacion;
    private String fechaDeNacimiento;

    public Donante(int idDonante, String nombre, String apellido, String documento, int grupoSanguineoId, String fechaUltimaDonacion, String fechaDeNacimiento) {
        this.idDonante = idDonante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.grupoSanguineoId = grupoSanguineoId;
        this.fechaUltimaDonacion = fechaUltimaDonacion;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getIdDonante() {
        return idDonante;
    }

    public void setIdDonante(int idDonante) {
        this.idDonante = idDonante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getGrupoSanguineoId() {
        return grupoSanguineoId;
    }

    public void setGrupoSanguineoId(int grupoSanguineoId) {
        this.grupoSanguineoId = grupoSanguineoId;
    }

    public String getFechaUltimaDonacion() {
        return fechaUltimaDonacion;
    }

    public void setFechaUltimaDonacion(String fechaUltimaDonacion) {
        this.fechaUltimaDonacion = fechaUltimaDonacion;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    @Override
    public String toString() {
        return "Donante{" + "idDonante=" + idDonante + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", grupoSanguineoId=" + grupoSanguineoId + ", fechaUltimaDonacion=" + fechaUltimaDonacion + ", fechaDeNacimiento=" + fechaDeNacimiento + '}';
    }

    

   
    
}
