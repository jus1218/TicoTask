
package com.mycompany.controller;

import com.mycompany.container.ColaboradorContainer;
import com.mycompany.container.TareaContainer;
import com.mycompany.model.TareaEntity;
import com.mycompany.verificacion.Verificar;
import com.mycompany.view.View;
import java.text.ParseException;
import java.util.List;



 public class TareaController implements TareaInterface{

 
   @Override
   public String create(String[] data) {
             String respuesta = "Tarea ya registrada previamente";
             try{
                    if(Verificar.verificarCongruenciaFechas(data[2], data[3])){
                    //if (!TareaContainer.exist(data[0])) {
                    //TareaEntity newTarea = new TareaEntity(data);

                        if (TareaContainer.add(new TareaEntity(data))) {
                            respuesta = "Tarea agregada exitosamente";
                        } else {
                            respuesta = "Error al agregar al almacen de datos";
                        }
                    }else{
                        respuesta= "No se modifico, Incogruencia de fechas.";
                    }
             
             }catch(ParseException ex){
                 respuesta += "\nFormato Incorrecto";
             
             }
        return respuesta;
    }

    @Override
    public String update(String[] data) {
        String respuesta = "No se encontro ninguna tarea";
        if(TareaContainer.exist(data[0])){
            try{                                        //0 = id  1= desc 2= rec 3 = fI 4 = fF
                if(Verificar.verificarCongruenciaFechas(data[3], data[4])){

                    
                    if(TareaContainer.update(new TareaEntity(data[0],data[1],data[2],data[3],data[4]))){
                        respuesta = "Se actualizo correctamente";

                    }else{
                    respuesta = "Error al actualizar tarea";
                    }
                }
            }catch(ParseException ex){
             respuesta  ="- Formato incorrecto\n*** Error al modificar el proyecto";
            }
        }                     
        
        return respuesta;
    }

    @Override
    public String[] buscar(String id) {
      if(TareaContainer.exist(id)){
          TareaEntity tarea = TareaContainer.find(id); //  find(id);
          String[] dataTarea = {tarea.getId(),tarea.getDescripcion(),tarea.getRecurso()};
             return dataTarea;
      } 
       return null;
    }

    @Override
    public String delete(String tareaId) {
        
        String respuesta = "No existe la tarea";
        if(TareaContainer.delete(tareaId)){
            respuesta = "Tarea Eliminada Exitosamente";
        }else{
            respuesta = "No se pudo eliminar la tarea";
        }
        
       return respuesta;
    }
    
    
    @Override
    public String addColaborador(String idTarea, String idColaborador){
        String estado = ColaboradorContainer.find(idColaborador).getEstado();
    String response = "Error al asignar el Colaborador a la Tarea "+ idColaborador;
        if(TareaContainer.exist(idTarea)){
            
            if(ColaboradorContainer.exist(idColaborador)){
                //estado == Atctivo
               
                if("Activo".equals(estado) || "activo".equals(estado)){ //en caso de que falle revisar este if
                   
                    if(TareaContainer.addColaborador(idTarea, ColaboradorContainer.find(idColaborador))){
                        
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
    public String[] getAll(){
        if(!TareaContainer.isVoid()){
            List tarea = TareaContainer.getAll();
            String[] data = new String[tarea.size()];
            int j = 0;
            
            for(Object c : TareaContainer.getAll()){
                TareaEntity p0 = (TareaEntity) c;
                data[j] = p0.toString();
                j++;                
            }
            return data;        
        }
        return null;       
    }   
    

 
 }
