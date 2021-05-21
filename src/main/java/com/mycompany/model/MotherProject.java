package com.mycompany.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MotherProject {
                
    protected String id;

    protected Date fechaInicio;
    protected Date fechaFinal;
    

    public MotherProject() {
        
    }



    public String getId() {
        return id;
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
        sb.append("\nId = ").append(id);
        sb.append("\t|| FechaInicio = ").append(String.valueOf(formatoDelTexto.format(fechaInicio)));
        sb.append("\t|| FechaFinal = ").append(String.valueOf(formatoDelTexto.format(fechaFinal)));
        sb.append("\n-----------------------------------------------");
        return sb.toString();
    }
    
}
