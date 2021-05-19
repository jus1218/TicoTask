package com.mycompany.controller.proyecto_controller;

import com.mycompany.container.proyecto_container.ProyectoContainer;
import com.mycompany.model.proyecto_model.ProyectoEntity;
import com.mycompany.verificacion.Verificar;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProyectoController implements ProyectoInterface {

    @Override
    public String create(String[] data) {
        String msj = "***No se creo ningun proyecto***";

        try {
            //verifico si la fecha de inicio esta antes que la final
            if (Verificar.verificarCongruenciaFechas(data[1], data[2])) {

                // if (!ProyectoContainer.exist(data[0])) { no es necesario ya que los proyectos se crean con id unicos
                if (ProyectoContainer.add(new ProyectoEntity(data))) {//creo el proyecto
                    msj = "<<< Proyecto creado exitosamente >>>";
                } else {
                    msj = "***Error al crear el proyecto***";
                }
            } else {
                msj = "***No se modifico, Incongruencia en las fechas***";
            }
        } catch (ParseException ex) {
            msj += "\nFormato incorrecto";
        }

        return msj;
    }

    @Override
    public String update(String[] data) {//******hay que agregar verificar AQUI**********
        String msj = "*** Proyecto no existente ***";

        if (ProyectoContainer.exist(data[0])) {
            try {
                if (Verificar.verificarCongruenciaFechas(data[2], data[3])) {
                    /* Al crear un nuevo obj se crea una nueva id nuevo por lo que
                    * se manda a otro constructor que tenga para ingresar id
                     * asi no se pierde el id */
                    ProyectoEntity p0 = ProyectoContainer.find(data[0]);
                    p0.setNombre(data[1]);
                    p0.setFechaInicio(data[2]);
                    p0.setFechaFinal(data[3]);

                    if (ProyectoContainer.update(p0)) {
                        msj = "<<< Se actualizo correctamente el proyecto >>>";
                    } else {
                        msj = "*** Error al modificar el proyecto ***";
                    }
                }
            } catch (ParseException ex) {
                msj = "- Formato incorrecto\n*** Error al modificar el proyecto ***";
            }
        }
        return msj;
    }

    @Override
    public String[] getAllProject() {

        if (!ProyectoContainer.esVacio()) {//retorna true si esta vacio
            //proyecto ProyectoController.size();
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
