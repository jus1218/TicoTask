/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import com.mycompany.model.ColaboradorEntity;
import com.mycompany.model.proyecto.MotherProject;
import java.text.ParseException;
import java.util.Date;


public class TareaEntity extends MotherProject  {

    private String id;
    private String descripcion;
    private ColaboradorEntity colaborador;//agregar colaborador por medio de funcion
    private String recurso;

    //private Sprint sprintProyecto;
      
    //-----------------Constructores--------------------
    public TareaEntity(String pId, String pDescripcion, String pRecurso,/* aqui va el sprint  */ String fechaInicio, String fechaFinal)throws ParseException {
        this.id = pId;
        this.descripcion = pDescripcion;      
        this.recurso = pRecurso;
        this.setFechaInicio(fechaInicio);
        this.setFechaFinal(fechaFinal);

       
    }

     public TareaEntity(String[] datos)throws ParseException{ 
         super();
                  
        //this.id = datos[0];
        this.descripcion = datos[0];
        this.recurso = datos[1];  
        this.setFechaInicio(datos[2]);
        this.setFechaFinal(datos[3]);
        
    }
//-------------------Getters-----------------------

    /**
     * @return the descripción
     */
    public String getDescripcion() {
        return descripcion;
    }

//-------------------Setters-----------------------
    /**
     * @param descripción the descripción to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        
        sb.append(", Descripcion = ").append(descripcion);
        //Toca llamar al toString de colaborador 
        sb.append(", Colaborador = ").append(colaborador);
        
        sb.append(", Recurso = ").append(recurso);
        sb.append(super.toString());
        
        sb.append('}');
        return sb.toString();
    }

}
