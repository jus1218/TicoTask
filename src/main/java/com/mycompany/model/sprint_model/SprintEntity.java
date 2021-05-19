package com.mycompany.model.sprint_model;

import com.mycompany.model.MotherProject;
import com.mycompany.model.proyecto_model.ProyectoEntity;
import java.text.ParseException;

public class SprintEntity extends MotherProject{
    
    private static int contadorSprint;
   /*se Agrega un proyecto especcifico*/
    private ProyectoEntity Proyecto;
//    private TaskEntity task;


    public SprintEntity(String[] data ) throws ParseException {
        
        this.id = data[0] +"-"+(++SprintEntity.contadorSprint);
        this.setFechaInicio(data[1]);
        this.setFechaFinal(data[2]);
       
    }
    public SprintEntity(String pId, String pNombre, String pInicio, String pFinal) throws ParseException {
        this.id = pId;
        this.setFechaInicio(pInicio);
        this.setFechaFinal(pFinal);
    }


    
    //----------------- Metodos propios -------------------------
    
    public String getId() {
        return id;
    }
    
    public void setProyectoEntity(ProyectoEntity proyecto){
        
        this.Proyecto = proyecto ;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
    
    
}
