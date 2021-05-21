package com.mycompany.controller.tarea_controller;

import com.mycompany.container.Sprint_container.SprintContainer;
import com.mycompany.container.colaborador_container.ColaboradorContainer;
import com.mycompany.container.proyecto_container.ProyectoContainer;
import com.mycompany.container.tarea_container.TareaContainer;
import com.mycompany.model.proyecto_model.ProyectoEntity;
import com.mycompany.model.sprint_model.SprintEntity;
import com.mycompany.model.tarea_model.TareaEntity;
import com.mycompany.verificacion.Verificar;
import java.text.ParseException;
import java.util.List;

//import java.util.List;
public class TareaController implements TareaInterface {

    @Override
    public String create(String[] data) {
        String respuesta = "Tarea ya registrada previamente";
        try {
            if (SprintContainer.exist(data[0])) {

                if (Verificar.verificarCongruenciaFechas(data[2], data[3])) {
                    if (!TareaContainer.exist(data[0])) {
                        TareaEntity newTarea = new TareaEntity(data);
                        if (TareaContainer.add(newTarea)) {
                            SprintEntity s0 = SprintContainer.find(data[0]);
                            s0.getList().add(newTarea);
                            respuesta = "Tarea agregada exitosamente al Sprint";
                        } else {
                            respuesta = "Error al agregar al almacen de datos";
                        }
                    }
                } else {
                    respuesta = "No se modifico, Incogruencia de fechas.";
                }
            } else {
                respuesta = "No existe el Sprint ingresado";
            }
        } catch (ParseException ex) {
            respuesta += "\nFormato Incorrecto";

        }
        return respuesta;
    }

    @Override
    public String update(String[] data) {
        String respuesta = "No se encontro ninguna tarea";
        if (TareaContainer.exist(data[0])) {
            try {
                //0 = id / 1= desc / 2= rec / 3 = fI / 4 = fF
                //if(Verificar.verificarCongruenciaFechas(data[3], data[4])){                
                String[] idSprint = data[0].split("-");
                SprintEntity p0 = SprintContainer.find(idSprint[0]);

                if (Verificar.verificarRangoFecha(data, p0.getFechaInicio(), p0.getFechaFinal())) {
                    TareaEntity t0 = TareaContainer.find(data[0]);
                    //if(TareaContainer.update(new TareaEntity(data[0],data[1],data[2],data[3],data[4]))){
                    t0.setFechaInicio(data[3]);
                    t0.setFechaFinal(data[4]);
                    if (TareaContainer.update(t0)) {
                        respuesta = "Se actualizo correctamente";
                    } else {
                        respuesta = "Error al actualizar tarea";
                    }
                }
                //}
            } catch (ParseException ex) {
                respuesta = "- Formato incorrecto\n*** Error al modificar el proyecto";
            }
        }
        return respuesta;
    }

    @Override
    public String[] buscar(String id) {
        if (TareaContainer.exist(id)) {
            TareaEntity tarea = TareaContainer.find(id); //  find(id);
            String[] dataTarea = {tarea.getId(), tarea.getDescripcion(), tarea.getRecurso()};
            return dataTarea;
        }
        return null;
    }

    @Override
    public String delete(String tareaId) {

        String respuesta = "No existe la tarea";
        if (TareaContainer.delete(tareaId)) {
            respuesta = "Tarea Eliminada Exitosamente";
        } else {
            respuesta = "No se pudo eliminar la tarea";
        }

        return respuesta;
    }

    @Override
    public String addColaborador(String idTarea, String idColaborador) {
        String estado = ColaboradorContainer.find(idColaborador).getEstado();
        String response = "Error al asignar el Colaborador a la Tarea " + idColaborador;
        if (TareaContainer.exist(idTarea)) {

            if (ColaboradorContainer.exist(idColaborador)) {
                //estado == Atctivo

                if ("Activo".equals(estado) || "activo".equals(estado)) { //en caso de que falle revisar este if

                    if (TareaContainer.addColaborador(idTarea, ColaboradorContainer.find(idColaborador))) {

                        TareaContainer.addColaborador(idTarea, ColaboradorContainer.find(idColaborador));
                        //ColaboradorContainer.addTarea(idColaborador, TareaContainer.find(idTarea));
                        response = "Asignación Exitosa";
                    }
                }
            }

        }
        return response;
    }

    @Override
    public List tareaDelSprint(String[] dataId) {
        String respuesta = "No exite Ninguna tarea en el sprint";
        if (SprintContainer.exist(dataId[0])) {
            SprintEntity s0 = SprintContainer.find(dataId[0]);

            if (TareaContainer.exist(dataId[1])) {
                List tareaList = s0.getList();
                return tareaList;
            }
        }
        return null;
    }

}
