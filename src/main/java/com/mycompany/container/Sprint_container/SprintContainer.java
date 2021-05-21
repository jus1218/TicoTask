package com.mycompany.container.Sprint_container;

import com.mycompany.model.sprint_model.SprintEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SprintContainer {
    
    private static Map<String, SprintEntity> contenedor = new HashMap<String, SprintEntity>();
    

    public static boolean add(SprintEntity sprint) {

        if (!contenedor.containsKey(sprint.getId())) {
          contenedor.put(sprint.getId(), sprint);
            return true;
       }
        return false;
    }

    // Va de la mano con el metodo READ de Controller
    public static boolean exist(String id) {
        return contenedor.containsKey(id);
    }

    /* Hace una comparacion entre el id que el usuario ingreso
    *  con los id existentes del contenedor */
    public static SprintEntity find(String id) {
        if (contenedor.containsKey(id)) {
            return contenedor.get(id);//retorno el usuario si lo encontro
        }
        return null;
    }

    public static List getListTarea(String idSprint) {        
       
        if(contenedor.containsKey(idSprint)){}
        return contenedor.get(idSprint).getList();       
    }   
    
    
    private static boolean isVoid() {
       return contenedor.isEmpty();
    }        

    /*Update*/
   public static boolean update(SprintEntity user) {
        if (contenedor.containsKey(user.getId())) {
            //contenedor.replace(user.getId(), contenedor.get(user.getId()), user);
            contenedor.replace(user.getId(), user);
            return true;
        }
        return false;
   }
}

//}
