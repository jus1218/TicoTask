/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.tarea_model;

import com.mycompany.model.colaborador_model.ColaboradorEntity;
import com.mycompany.model.MotherProject;
import com.mycompany.model.sprint_model.SprintEntity;
import java.text.ParseException;

public class TareaEntity extends MotherProject {

    private String descripcion;
    private ColaboradorEntity colaborador;//agregar colaborador por medio de funcion
    private String recurso;
    private static int contadorTarea;

    private SprintEntity sprintProyecto;
    //-----------------Constructores--------------------
    public TareaEntity(String pId, String pDescripcion, String pRecurso,/* aqui va el sprint  */ String fechaInicio, String fechaFinal) throws ParseException {
        this.id = pId;
        this.descripcion = pDescripcion;
        this.recurso = pRecurso;
        this.setFechaInicio(fechaInicio);
        this.setFechaFinal(fechaFinal);

    }

    public TareaEntity(String[] datos) throws ParseException {
        this.id = "T-" + (++TareaEntity.contadorTarea);
        this.descripcion = datos[1];
        this.recurso = datos[2];
        this.setFechaInicio(datos[3]);
        this.setFechaFinal(datos[4]);

    }
//-------------------Getters-----------------------

    /**
     * @return the descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

    public SprintEntity getSprintProyecto() {
        return sprintProyecto;
    }

//-------------------Setters-----------------------
    /**
     * @param descripción the descripción to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSprintProyecto(SprintEntity sprintProyecto) {
        this.sprintProyecto = sprintProyecto;
    }

    /**
     * @return the colaborador
     */
    public ColaboradorEntity getColaborador() {
        return colaborador;
    }

    /**
     * @param colaborador the colaborador to set
     */
    public void setColaborador(ColaboradorEntity colaborador) {
        this.colaborador = colaborador;
    }

    /**
     * @return the recurso
     */
    public String getRecurso() {
        return recurso;
    }

    /**
     * @param recurso the recurso to set
     */
    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nDescripcion = ").append(descripcion);
        sb.append("\nRecurso = ").append(recurso);
        //Toca llamar al toString de colaborador 
        sb.append("\nColaborador = ").append(colaborador != null ? colaborador : "No esta asignado");
        sb.append("\n=========================================");
        return sb.toString();

    }

}
