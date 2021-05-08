package com.mycompany.controller;

import com.mycompany.container.ProyectoContainer;
import com.mycompany.model.proyecto.ProyectoEntity;
import java.util.List;

public class ProyectoController implements ProyectoInterface {

    @Override
    public String create(String[] data) {
        String msj = "No se creo ningun proyecto";
        
        // if (!ProyectoContainer.exist(data[0])) { no es necesario ya que los proyectos se crean con id unicos
        if (ProyectoContainer.add(new ProyectoEntity(data))) {//creo el proyecto
            msj = "Se creo el proyecto exitosamente";
        } else {
            msj = "Error al crear el proyecto";
        }
        //}
        return msj;
    }

    @Override
    public String update(String[] data) {
        String msj = "*** Proyecto no existente ***";
        if (ProyectoContainer.exist(data[0])) {
            /* Al crear un nuevo obj se crea una nueva id nuevo por lo que
             * se manda a otro constructor que tenga para ingresar id
             * asi no se pierde el id */
            ProyectoEntity p0 = new ProyectoEntity(data[0], data[1], data[2], data[3]);
            //p0.setId(data[0]);

            if (ProyectoContainer.update(p0)) {
                msj = "Se actualizo correctamente el proyecto";
            } else {
                msj = "*** Error al modificar el proyecto ***";
            }
        }
        return msj;
    }

    @Override
    public String[] getAllProject() {

        if (!ProyectoContainer.esVacio()) {//retorna true si esta vacio
            List project = ProyectoContainer.getAll();
            String[] data = new String[project.size()];//ProyectoContainer.tamano()

            int i = 0;
            for (Object c : ProyectoContainer.getAll()) {
                ProyectoEntity p0 = (ProyectoEntity) c;
                data[i] = p0.toString();
                i++;
            }

            return data;
        }
        return null;
    }

}
