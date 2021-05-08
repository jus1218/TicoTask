package com.mycompany.model.proyecto;

public class ProyectoEntity extends MotherProject {

    public ProyectoEntity(String data[]) {//constructor para crear poyectos
        super();
        //data[0] => viene el id pero eso ya esta
        this.setNombre(data[0]);
        this.setFechaInicio(data[1]);
        this.setFechaFinal(data[2]);
    }

    //Este se utiliza para actualizar el proyecto, porque recibe Id, 
    //esto para no perder el Id de su inicio
    public ProyectoEntity(String pId, String pNombre, String pInicio, String pFinal) {
        this.id = pId;
        this.nombre = pNombre;
        this.fechaInicio = pInicio;
        this.fechaFinal = pFinal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }

}
