package com.mycompany.controller;

import com.mycompany.container.ColaboradorContainer;
import com.mycompany.model.ColaboradorEntity;

public class ColaboradorController implements ColaboradorInterface {

    @Override
    public String create(String[] data) {
        String respuesta = "Usuario ya registrado previamente";
        if (!ColaboradorContainer.exist(data[0])) {
            ColaboradorEntity newColaborador = new ColaboradorEntity(data);

            if (ColaboradorContainer.add(newColaborador)) {
                respuesta = "Usuario agregado exitosamente";
            } else {
                respuesta = "Error al agregar al almacen de datos";
            }
        }
        return respuesta;
    }

    @Override
    public String update(String[] data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public String[] buscar(String id) {
        if (ColaboradorContainer.exist(id)) {
            ColaboradorEntity user = ColaboradorContainer.find(id);//devuelve usuario
            String[] data = {user.getId(), user.getNombre(), user.getApellidos(),
                user.getTelefono(), user.getCorreo(), user.getEspecialidad(),
                String.valueOf(user.getEstado())};
            return data;
        }
        return null;
    }

    @Override
    public String delete(String id) {

        String msj = "Usuario no encontrado";
        if (ColaboradorContainer.exist(id)) {
            ColaboradorContainer.delete(id);
            msj = "Se ha eliminado exitosamente";
        }
        return msj;
    }
}
