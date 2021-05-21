package com.mycompany.model.sprint_model;

import com.mycompany.model.MotherProject;
import com.mycompany.model.proyecto_model.ProyectoEntity;
import com.mycompany.model.tarea_model.TareaEntity;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SprintEntity extends MotherProject{
    
    private static int contadorSprint;
   /*se Agrega un proyecto especcifico*/
    private ProyectoEntity Proyecto;
    private List task;


    public SprintEntity(String[] data ) throws ParseException {
        
        this.id = data[0] +"-"+(++SprintEntity.contadorSprint);
        this.setFechaInicio(data[1]);        
        this.setFechaFinal(data[2]);
        
        task = new ArrayList <TareaEntity>();
        
    }
    /*public SprintEntity(String pId, String pNombre, String pInicio, String pFinal) throws ParseException {
        this.id = pId;
        this.setFechaInicio(pInicio);
        this.setFechaFinal(pFinal);
    }*/


    
    //----------------- Metodos propios -------------------------
    
    public String getId() {
        return id;
    }
    
    public void setProyectoEntity(ProyectoEntity proyecto){
        
        this.Proyecto = proyecto ;
    }
    public List getList(){
        return task;
    }
    public void setVoid(List task){           
        this.task = task;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
    
    
}
