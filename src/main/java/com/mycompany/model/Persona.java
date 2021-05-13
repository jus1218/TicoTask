package com.mycompany.model;

public abstract class Persona {

    protected String id;
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String correo;

    //----------- Constructoes -------------------
    public Persona() {
    }

    public Persona(String id, String nombre, String apellidos, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    //----------- Metodos set---------------------
    public abstract void setId(String id);

    public abstract void setNombre(String nombre);

    public abstract void setApellido(String apellido);

    public abstract void setTelefono(String telefono);

    public abstract void setCorreo(String correo);

    //----------- Metodos get---------------------
    public abstract String getId();

    public abstract String getNombre();

    public abstract String getApellidos();

    public abstract String getTelefono();

    public abstract String getCorreo();

    //----------- toString -----------------
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nid = ").append(id);
        sb.append("\t\t||nombre = ").append(nombre);
        sb.append("\napellidos = ").append(apellidos);
        sb.append("\t||telefono = ").append(telefono);
        sb.append("\ncorreo = ").append(correo);
        return sb.toString();
    }
}
