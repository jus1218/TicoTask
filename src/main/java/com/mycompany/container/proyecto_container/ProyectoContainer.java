package com.mycompany.container.proyecto_container;

import com.mycompany.model.proyecto_model.ProyectoEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProyectoContainer {

    private static Map<String, ProyectoEntity> contenedor = new HashMap<String, ProyectoEntity>();

    public static boolean add(ProyectoEntity colaborador) {

        if (!contenedor.containsKey(colaborador.getId())) {
            contenedor.put(colaborador.getId(), colaborador);
            return true;
        }
        return false;
    }

    public static boolean exist(String id) {
        return contenedor.containsKey(id);
    }

    public static List getAll() {// verificar metodo
        // List<ProyectoEntity> list = new ArrayList<ProyectoEntity>(contenedor.values());

        return new ArrayList<ProyectoEntity>(contenedor.values());//aqui es el problem
    }

    public static boolean update(ProyectoEntity user) {
        if (contenedor.containsKey(user.getId())) {
            //contenedor.replace(user.getId(), contenedor.get(user.getId()), user);
            contenedor.replace(user.getId(), user);
            return true;
        }
        return false;
    }

    public static boolean esVacio() {

        return contenedor.isEmpty();
    }

    public static int tamano() {
        return contenedor.size();
    }

    public static ProyectoEntity getProyecto(String id) {
        return contenedor.get(id);
    }

    public static List mostrarSprint(String id) {

        if (contenedor.containsKey(id)) {
            return contenedor.get(id).getSprints();
        }
        return null;
    }

    public static ProyectoEntity find(String id) {
        if (contenedor.containsKey(id)) {
            return contenedor.get(id);
        }
        return null;

    }

}
