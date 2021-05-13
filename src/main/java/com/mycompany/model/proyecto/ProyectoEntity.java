package com.mycompany.model.proyecto;

import java.text.ParseException;

public class ProyectoEntity extends MotherProject {
    //private SprintEntity sprint;

    public ProyectoEntity(String data[]) throws ParseException {//constructor para crear poyectos
        super();
        //data[0] => viene el id pero eso ya esta
        this.setNombre(data[0]);
        this.setFechaInicio(data[1]);
        this.setFechaFinal(data[2]);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }

}
