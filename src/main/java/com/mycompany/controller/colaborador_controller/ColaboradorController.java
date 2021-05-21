package com.mycompany.controller.colaborador_controller;

import com.mycompany.container.colaborador_container.ColaboradorContainer;
import com.mycompany.model.colaborador_model.ColaboradorEntity;
import com.mycompany.verificacion.Verificar;

public class ColaboradorController implements ColaboradorInterface {

    @Override
    public String create(String[] data) {
        String respuesta = "... Usuario ya registrado previamente ...";
        if (!ColaboradorContainer.exist(data[0])) {
            if (Verificar.verificarEstado(data[6])) {

                if (ColaboradorContainer.add(new ColaboradorEntity(data))) {
                    respuesta = "Usuario agregado exitosamente";
                } else {
                    respuesta = "***Error al agregar al almacen de datos***";
                }

            }else{respuesta ="*** Error, dato ingresado en el estado es incorrecto ***";}
        }
        return respuesta;
    }

    @Override
    public String update(String[] data) {

        String msj = "*** Usuario no encontrado ***";
        if (ColaboradorContainer.exist(data[0])) {
            if (Verificar.verificarEstado(data[6])) {
                ColaboradorEntity c0 = ColaboradorContainer.find(data[0]);
                c0.setNombre(data[1]);
                c0.setApellido(data[2]);
                c0.setTelefono(data[3]);
                c0.setCorreo(data[4]);
                c0.setEspecialidad(data[5]);
                c0.setEstado(data[6]);

                if (ColaboradorContainer.update(c0)) {
                    msj = "Se actualizo correctamente";
                } else {
                    msj = "*** Error al modificar al usuario ***";
                }
            }else{msj ="*** Error, dato ingresado en el estado es incorrecto ***";}
        }
        return msj;
    }

    /* protected String id;
    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String correo;
    private String especialidad;
    private Boolean estado;*/

 /* Busca por medio de id, si encuentra, el contenedor.find devuelve el usuario
    *  lo entrega a user y por medio de un arreglo se manda los datos */
    @Override
    public String buscar(String id) {
        if (ColaboradorContainer.exist(id)) {
//            ColaboradorEntity user = ColaboradorContainer.find(id);//devuelve usuario
//            String[] data = {user.getId(), user.getNombre(), user.getApellidos(),
//                user.getTelefono(), user.getCorreo(), user.getEspecialidad(),
//                user.getEstado()};
            return ColaboradorContainer.find(id).toString();
        }
        return null;
    }

    @Override
    public String delete(String id) {

        String msj = "*** Usuario no encontrado ***";
        if (ColaboradorContainer.exist(id)) {
            if (ColaboradorContainer.delete(id)) {
                msj = "Se ha eliminado exitosamente";
            } else {
                msj = "*** Error al eliminar el usuario ***";
            }
        }
        return msj;
    }
}
