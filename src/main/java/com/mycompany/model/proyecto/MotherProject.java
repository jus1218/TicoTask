package com.mycompany.model.proyecto;

public class MotherProject {
    protected String id;
    protected String nombre;
    protected String fechaInicio;
    protected String fechaFinal;
    protected static int contadorId;

    public MotherProject(String nombre, String fechaInicio, String fechaFinal) {
        this.id = "P"+(++MotherProject.contadorId);
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
    
    
    
    
}
