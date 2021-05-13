package com.mycompany.view;

import com.mycompany.controller.ColaboradorController;
import com.mycompany.controller.ColaboradorInterface;
import com.mycompany.controller.ProyectoController;
import com.mycompany.controller.ProyectoInterface;

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
        moduloProyecto();
        moduloColaborador();
    }
    
    private static void moduloColaborador() {
        ColaboradorInterface colaboradorCtrll = new ColaboradorController();
        
        int opcUser;
        String id;
        String respuesta;
        String menuOptions[] = {"Agregar", "Cosultar", "Modificar", "Eliminar", "Salir"};
        
        do {
            opcUser = View.menu("Menu Administrador de Colaboradores", menuOptions);
            switch (opcUser) {
                case 0:// Agregar
                    String data[] = {"Cedula", "Nombre", "Apellidos", "telefono", "correo", "especialidad", "estado( Activo / Inactivo )"};
                    data = View.input("Datos del Usuario", data);//se despiega todas las entradas para que el usuario ingrese los datos
                    respuesta = colaboradorCtrll.create(data);
                    View.imprimir(respuesta);
                    break;
                case 1:// Consultar 
                    id = View.input("Ingrese la cedula a consultar");
                    // String userData[] = colaboradorCtrll.buscar(id);//si encuentra devuelve un arreglo
                    if (colaboradorCtrll.buscar(id) != null) {
                        
                        View.imprimir("Datos del usuario almacenado");
                        View.imprimir(colaboradorCtrll.buscar(id));
//                        for (String line : userData) {
//                            View.imprimir(line);
//                        }
                    } else if (colaboradorCtrll.buscar(id) == null) {
                        View.imprimir("*** Usuario no encontrado ***");
                    }
                    break;
                case 2:// Modificar
                    String datos[] = {"Cedula", "Nombre", "Apellidos", "telefono", "correo", "especialidad", "estado"};
                    data = View.input("Datos del Usuario", datos);
                    
                    respuesta = colaboradorCtrll.update(data);
                    View.imprimir(respuesta);
                    break;
                case 3://Eliminar
                    id = View.input("Ingrese el id a eliminar");
                    String msj = colaboradorCtrll.delete(id);
                    View.imprimir(msj);
                    
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
        
        ProyectoInterface ProyectoCtrll = new ProyectoController();
        
        int opcUser;
        String id;
        String respuesta;
        String menuOptions[] = {"Agregar", "Modificar", "Listar Proyectos", "Salir"};
        
        do {
            opcUser = View.menu("Menu Administrador de Proyectos", menuOptions);
            switch (opcUser) {
                case 0:// Agregar
                    String data[] = {"Nombre", "\tFormato fecha [ dia / mes / año ]\nFecha de inicio", "Fecha Final"};
                    data = View.input("Datos del Proyecto", data);//se despiega todas las entradas para que el usuario ingrese los datos
                    respuesta = ProyectoCtrll.create(data);
                    View.imprimir(respuesta);
                    break;
                case 1:// Modificar 
                    String datos[] = {"ID", "Nombre", "\tFormato de fecha[ dia / mes / año ]\nFecha de inicio", "Fecha Final"};
                    data = View.input("Datos del proyecto", datos);
                    
                    respuesta = ProyectoCtrll.update(data);
                    View.imprimir(respuesta);
                    break;
                case 2:// Listar Proyectos
                    String projectList[] = ProyectoCtrll.getAllProject();
                    
                    if (projectList != null) {
                        View.imprimir("========== Lista de Proyectos ===========");
                        for (String line : projectList) {
                            View.imprimir(line);
                        }
                        View.imprimir("=========================================");
                    } else {
                        View.imprimir("No existen Proyectos");
                    }
                    break;
                case 3:// Salir
                    View.imprimir("Cerrando sistema...");
                    break;
                default:
                    View.imprimir("**** Opcion invalida *****");
                    break;
                
            }
            
        } while (opcUser != 3);
        
    }
    
}
