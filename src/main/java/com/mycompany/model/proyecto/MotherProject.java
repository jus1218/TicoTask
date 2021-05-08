package com.mycompany.model.proyecto;

public class MotherProject {

    protected String id;
    protected String nombre;
    protected String fechaInicio;
    protected String fechaFinal;
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id);
        sb.append("\t\t\t|| FechaInicio = ").append(fechaInicio);
        sb.append("\nNombre = ").append(nombre);
        sb.append("\t|| FechaFinal = ").append(fechaFinal);
        sb.append("\n-----------------------------------------------");
        return sb.toString();
    }

}
