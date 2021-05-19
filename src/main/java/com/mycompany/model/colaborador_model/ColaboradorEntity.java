package com.mycompany.model.colaborador_model;

import com.mycompany.model.Persona;

public class ColaboradorEntity extends Persona {

    private String especialidad;
    private String estado;
    //private TaskEntity task;

    //------------------ Constructores --------------------------
//    public ColaboradorEntity(String especialidad, String estado) {
//        this.especialidad = especialidad;
//        this.estado = estado;
//    }

    public ColaboradorEntity(String[] datos) {
        super(datos[0], datos[1], datos[2], datos[3], datos[4]);
        this.especialidad = datos[5];
        this.estado = datos[6];
    }
    //----------------- Metodos propios -------------------------

    public String getEspecialidad() {
        return especialidad;
    }

    public String getEstado() {

        return this.estado;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //------------------ Metodos Heredados ----------------------
    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String getApellidos() {
        return this.apellidos;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public String getCorreo() {
        return this.correo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("  ||especialidad = ").append(especialidad);
        sb.append("\nestado = ").append(estado);
        sb.append("\n====================================");
        return sb.toString();
    }
}
