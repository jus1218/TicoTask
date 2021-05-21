package com.mycompany.model.proyecto_model;

import com.mycompany.model.MotherProject;
import com.mycompany.model.sprint_model.SprintEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ProyectoEntity extends MotherProject {

    protected String nombre;
    protected static int contadorId; //asignar el valor numerico al id
    private List sprints;

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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List getSprints() {
        return sprints;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");//le damos el formato de fecha
        StringBuilder sb = new StringBuilder();
        sb.append("Id = ").append(id);
        sb.append("\t\t\t|| FechaInicio = ").append(String.valueOf(formatoDelTexto.format(fechaInicio)));
        sb.append("\nNombre = ").append(nombre);
        sb.append("\t|| FechaFinal = ").append(String.valueOf(formatoDelTexto.format(fechaFinal)));
        sb.append("\n-----------------------------------------------");
        return sb.toString();
    }

}
