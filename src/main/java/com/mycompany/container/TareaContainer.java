/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.container;
import com.mycompany.model.ColaboradorEntity;
import com.mycompany.model.TareaEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Monge
 */
public class TareaContainer {
    private static Map<String, TareaEntity> contenedor = new HashMap<String, TareaEntity>();

    // Va de la mano con el metodo CREATE de Controller
    public static boolean add(TareaEntity tarea) {

        if (!contenedor.containsKey(tarea.getId())) {
            contenedor.put(tarea.getId(), tarea);
            return true;
        }
        return false;
    }
    
      public static boolean exist(String id) {
        return contenedor.containsKey(id);
    }
    
    public static TareaEntity find(String id){
        if(contenedor.containsKey(id)){
            return contenedor.get(id);
        }  
        return null;
    
    }
    
     public static List getAll() {                 
          return new ArrayList<TareaEntity>(contenedor.values());
    }
     

    
    /*Update*/
    public static boolean update(TareaEntity tarea) {
        if(contenedor.containsKey(tarea.getId())){
            contenedor.replace(tarea.getId(), tarea);
            return true;
        }
        
        return false;
    }

    /*Delete*/
    public static boolean delete(String tareaId) {
        if(contenedor.containsKey(tareaId)){
            contenedor.remove(tareaId);
            return true;
        }
        return false;
    }

    
    public static boolean addColaborador(String idTarea, ColaboradorEntity colaborador ){
        if(contenedor.containsKey(idTarea)){
            contenedor.get(idTarea).setColaborador(colaborador);
            //agregar atributo de tarea en colaborador y enviarlo por el set 
            return true;               
        }               
    return false;
    }
    

    public static boolean isVoid(){
        return contenedor.isEmpty();
    }
    public static int tamano(){
        return contenedor.size();
    }
    
    
    
    
    
    
    
    
}