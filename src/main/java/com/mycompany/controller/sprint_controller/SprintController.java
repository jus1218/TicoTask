package com.mycompany.controller.sprint_controller;

import com.mycompany.model.sprint_model.SprintEntity;
import com.mycompany.container.Sprint_container.SprintContainer;
import com.mycompany.container.proyecto_container.ProyectoContainer;
import com.mycompany.controller.SprintInterface;
import com.mycompany.model.proyecto_model.ProyectoEntity;
import com.mycompany.verificacion.Verificar;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SprintController implements SprintInterface {

    @Override
    public String create(String[] data) {
        String respuesta = "*** Proyecto no existente ***";
        if (ProyectoContainer.exist(data[0])) {
            try {
                ProyectoEntity p0 = ProyectoContainer.find(data[0]);//esto es para poder hacer las comparaciones de fechas

                if (Verificar.verificarRangoFecha(data, p0.getFechaInicio(), p0.getFechaFinal())) {
                    SprintEntity s0 = new SprintEntity(data);
                    if (SprintContainer.add(s0)) {
                        if (ProyectoContainer.getProyecto(data[0]).getSprints().add(s0)) {
                            respuesta = "<<< Sprint creado exitosamente >>>";
                        }
                    }
                } else {
                    respuesta = "*** Incongruencia en las fechas ***";
                }

            } catch (ParseException ex) {
                respuesta = "**ups... verifique las fechas ingresadas**";
            }
        }
        return respuesta;
    }

    @Override
    public String update(String[] data) {
        String msj = "*** Sprint no existente ***";
        if (SprintContainer.exist(data[0])) {
            /* Al crear un nuevo obj se crea una nueva id nuevo por lo que
             * se manda a otro constructor que tenga para ingresar id
             * asi no se pierde el id */
            try {
                String[] idProject = data[0].split("-");//con esto podemos extraer el id de proyecto
                
                ProyectoEntity p0 = ProyectoContainer.find(idProject[0]);//esto es para poder hacer las comparaciones de fechas
                if (Verificar.verificarRangoFecha(data, p0.getFechaInicio(), p0.getFechaFinal())) {//aqui se compara

                    SprintEntity s0 = SprintContainer.find(data[0]);
                    s0.setFechaInicio(data[1]);
                    s0.setFechaFinal(data[2]);
                    if (SprintContainer.update(s0)) {
                        msj = "Se actualizo correctamente el Sprint";
                    } else {
                        msj = "*** Error al modificar el Sprint ***";
                    }
                }
            } catch (ParseException ex) {
                Logger.getLogger(SprintController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //p0.setId(data[0]);
        }
        return msj;

    }

    @Override
    public String[] desplegar_Sprint(String id
    ) {
        if (ProyectoContainer.exist(id)) {
            List Proyect = ProyectoContainer.mostrarSprint(id);
            String data[] = new String[Proyect.size()];
            int j = 0;

            for (Object c : ProyectoContainer.mostrarSprint(id)) {
                SprintEntity s0 = (SprintEntity) c;
                data[j] = s0.toString();
                j++;
            }
            return data;

        }
        return null;
    }

}
