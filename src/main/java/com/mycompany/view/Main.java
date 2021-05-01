package com.mycompany.view;

import com.mycompany.controller.ColaboradorController;
import com.mycompany.model.ColaboradorEntity;
import com.mycompany.controller.ColaboradorInterface;
import com.mycompany.model.Persona;
import javax.swing.JOptionPane;

/**
 * @author Alexandex Viales.
 * @author Daniel Lopez.
 * @author Justin Salazar.
 */
public class Main {

    public static void main(String[] args) {

//        String []datos={"1","Justin","Salazar","62890177","justin.abc12@gmail.com"};
//        
//        Persona c0 = new ColaboradorEntity(datos,"ING. Sistemas",true);
//        imprimir(c0);
//        c0.setId("2");
//        imprimir(c0);
        moduloColaborador();
    }

    private static void moduloColaborador() {
        ColaboradorInterface colaboradorCtrll = new ColaboradorController();

        int opcUser;
        String id;
        String respuesta;
        String menuOptions[] = {"Agregar", "Cosultar", "Modificar", "Eliminar", "Salir"};

        do {
            opcUser = View.menu("Bienvenido al menu Principal", menuOptions);
            switch (opcUser) {
                case 0:// Agregar
                    
                    /* protected String id;
                       protected String nombre;
                       protected String apellidos;
                       protected String telefono;
                       protected String correo;
                       private String especialidad;
                       private Boolean estado;*/
                    String data[] = {"Cedula", "Nombre", "Apellidos", "telefono", "correo", "especialidad", "estado"};
                    data = View.input("Datos del Usuario", data);//se despiega todas las entradas para que el usuario ingrese los datos
                    respuesta = colaboradorCtrll.create(data);
                    View.imprimir(respuesta);
                    break;
                case 1:// Consultar 
                    id = View.input("Ingrese la cedula a consultar");
                    String userData[] = colaboradorCtrll.buscar(id);//si encuentra devuelve un arreglo
                    if (userData != null) {

                        View.imprimir("Datos del usuario almacenado");
                        for (String line : userData) {
                            View.imprimir(line);
                        }
                    } else if (userData == null) {
                        View.imprimir("*** Usuario no encontrado ***");
                    }
                    break;
                case 2:// Modificar

                    break;
                case 3://Eliminar

                    break;
                case 4:// Salir
                    View.imprimir("Cerrando sistema...");
                    break;
                default:
                    View.imprimir("**** Opcion invalida *****");
                    break;

            }

        } while (opcUser != 4);

    }

    public static void moduloProyecto() {

    }

}
