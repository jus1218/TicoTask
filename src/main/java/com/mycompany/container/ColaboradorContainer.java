package com.mycompany.container;

import com.mycompany.model.ColaboradorEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColaboradorContainer {

    private static Map<String, ColaboradorEntity> contenedor = new HashMap<String, ColaboradorEntity>();

    // Va de la mano con el metodo CREATE de Controller
    public static boolean add(ColaboradorEntity colaborador) {

        if (!contenedor.containsKey(colaborador.getId())) {
            contenedor.put(colaborador.getId(), colaborador);
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
    public static ColaboradorEntity find(String id) {
        if (contenedor.containsKey(id)) {
            return contenedor.get(id);//retorno el usuario si lo encontro
        }
        return null;
    }

    public static List getAll() {
        return null;
    }

    //--------- Desarrollar los metodos faltantes -----------------
    /*Update*/
    public static boolean update(ColaboradorEntity user) {
        if (contenedor.containsKey(user.getId())) {

            //contenedor.replace(user.getId(), contenedor.get(user.getId()), user);
            contenedor.replace(user.getId(), user);
            return true;
        }
        return false;
    }

    /*Delete*/
    public static boolean delete(String id) {
        if (contenedor.containsKey(id)) {
            contenedor.remove(id);
            return true;
        }
        return false;
    }

    /*Login*/
    public static boolean login(String idUser, String password) {
        return true;
    }

}
