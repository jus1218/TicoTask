package com.mycompany.model.proyecto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MotherProject {

    protected String id;
    protected String nombre;
    protected Date fechaInicio;
    protected Date fechaFinal;
    protected static int contadorId; //asignar el valor numerico al id

    public MotherProject() {
        this.id = "P" + (++MotherProject.contadorId);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaInicio(String fechaInicio) throws ParseException {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaInicio =  formatoDelTexto.parse(fechaInicio);
    }

    public void setFechaFinal(String fechaFinal) throws ParseException {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaFinal =  formatoDelTexto.parse(fechaFinal);
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id);
        sb.append("\t\t\t|| FechaInicio = ").append( formatoDelTexto.format(fechaInicio));
        sb.append("\nNombre = ").append(nombre);
        sb.append("\t|| FechaFinal = ").append(formatoDelTexto.format(fechaFinal));
        sb.append("\n-----------------------------------------------");
        return sb.toString();
    }
    
}
