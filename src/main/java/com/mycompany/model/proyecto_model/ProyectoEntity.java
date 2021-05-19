package com.mycompany.model.proyecto_model;

import com.mycompany.model.MotherProject;
import com.mycompany.model.sprint_model.SprintEntity;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoEntity extends MotherProject {

    protected static int contadorId; //asignar el valor numerico al id
    private List  sprints;

    public ProyectoEntity(String data[]) throws ParseException {//constructor para crear poyectos
        //data[0] => viene el id pero eso ya esta
        this.id = "P" + (++ProyectoEntity.contadorId);
        this.nombre = data[0];
        this.setFechaInicio(data[1]);
        this.setFechaFinal(data[2]);
        sprints = new ArrayList<SprintEntity>();
        //this.Sprint = null;
    }

    //Este se utiliza para actualizar el proyecto, porque recibe Id, 
    //esto para no perder el Id de su inicio
    public ProyectoEntity(String pId, String pNombre, String pInicio, String pFinal) throws ParseException {
        this.id = pId;
        this.nombre = pNombre;
        this.setFechaInicio(pInicio);
        this.setFechaFinal(pFinal);
    }

    public List getSprints() {
        return sprints;
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }

}
