package com.mycompany.view;

import com.mycompany.controller.SprintInterface;
import com.mycompany.controller.colaborador_controller.ColaboradorController;
import com.mycompany.controller.colaborador_controller.ColaboradorInterface;
import com.mycompany.controller.proyecto_controller.ProyectoController;
import com.mycompany.controller.proyecto_controller.ProyectoInterface;
import com.mycompany.controller.sprint_controller.SprintController;

import com.mycompany.controller.tarea_controller.TareaController;
import com.mycompany.controller.tarea_controller.TareaInterface;
import com.mycompany.view.View;

/**
 * @author Alexandex Viales.
 * @author Daniel Lopez.
 * @author Justin Salazar.
 */
public class Main {

    public static void main(String[] args) {

        int opc0 = 0;
        String respuesta;
        String menuOptions[] = {"Administrador de Proyectos", "Administrador de Sprint", "Administrador de tareas", "Administrador de colaboradores", "Acerca de", "Salir"};
        do {
            opc0 = View.menu("Menu Principal de _TicoTask_", menuOptions);
            switch (opc0) {
                case 0:// Administrador de Proyectos
                    moduloProyecto();
                    break;
                case 1:// Administrador de Sprint
                    moduloSprint();
                    break;
                case 2:// Administrador de tareas
                    moduloTarea();
                    break;
                case 3://Administrador de colaboradores
                    moduloColaborador();
                    break;
                case 4://Acerca de
                    View.imprimir("\t\t<<TicoTask>>\n Programa enfocado en la administración\n "
                            + "de proyectos y optimización del tiempo."
                            + "\n\n Creadores:\n - Alexander Viales\n - Daniel Chevez\n - Justin Salazar\n");
                    break;
                case 5://Salir
                    View.imprimir("Cerrando sistema...");
                    break;
                default:
                    View.imprimir("**** Opcion invalida *****");
                    break;
            }

        } while (opc0 != 5);
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

                        View.imprimir("===Datos del usuario almacenado===");
                        View.imprimir(colaboradorCtrll.buscar(id));
//                        for (String line : userData) {
//                            View.imprimir(line);
//                        }
                    } else if (colaboradorCtrll.buscar(id) == null) {
                        View.imprimir("*** Usuario no encontrado ***");
                    }
                    break;
                case 2:// Modificar
                    String datos[] = {"Cedula", "Nuevo nombre", "Nuesvos apellidos", "Nuevo telefono", "Nuevo correo", "Nueva especialidad", "estado( Activo / Inactivo )"};
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
                    String datos[] = {"ID", "Nuevo nombre", "\tFormato de fecha[ dia / mes / año ]\nnueva fecha de inicio", "nueva fecha Final"};
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

    private static void moduloTarea() {
        TareaInterface tareaController = new TareaController();
        int opcU;
        String id;                 //0         1        2             3                 4              5   
        String menuOptions[] = {"Agregar", "Buscar", "Eliminar", "Mostrar", " Agregar Colaborador", "Deplegar tareas", "Salir"};
        String respuesta;

        do {
            opcU = View.menu("Menu Tareas", menuOptions);
            switch (opcU) {
                case 0: //Agregar
                    String data[] = {"Descripcion", "Recursos", "\tFormato fecha [ dia / mes / año ]\nFecha de inicio", "Fecha Final"};
                    data = View.input("Datos de Tarea", data);
                    respuesta = tareaController.create(data);
                    View.imprimir(respuesta);
                    break;

                case 1://Buscar

                    id = View.input("Ingrese el id de la tarea a mostrar");

                    String tarea[] = tareaController.buscar(id);
                    if (tarea != null) {
                        View.imprimir("Datos de la tarea");
                        for (String line : tarea) {
                            View.imprimir(line);
                        }
                        tareaController.buscar(id);
                    } else if (tarea == null) {
                        View.imprimir("No existe ninguna tarea");
                    }
                    break;
                case 2://Modificar
                    String dataTarea[] = {"Id", "Descripcion", "Recursos"};
                    dataTarea = View.input("Datos de Tarea", dataTarea);

                    respuesta = tareaController.update(dataTarea);

                    View.imprimir(respuesta);

                    break;
                case 3://Eliminar
                    String tareaId = View.input("Ingrese el Id de la tarea a eliminar: ");

                    respuesta = tareaController.delete(tareaId);
                    View.imprimir(respuesta);
                    break;
                case 4://Add colaborador 
                    String idTarea = View.input("Ingrese el Id de la tarea");
                    String idColaborador = View.input("Ingrese el Id del Colaborador");
                    respuesta = tareaController.addColaborador(idTarea, idColaborador);
                    View.imprimir(respuesta);

                    break;
                case 5://Desplejar

                    String tareaList[] = tareaController.getAll();

                    if (tareaList != null) {
                        View.imprimir("========== Lista de Proyectos ===========");
                        for (String line : tareaList) {
                            View.imprimir(line);
                        }
                        View.imprimir("=========================================");
                    } else {
                        View.imprimir("No existen Proyectos");
                    }
                    break;
                case 6://Salir

                    break;

            }
        } while (opcU != 6);
    }

    public static void moduloSprint() {

        SprintInterface SprintCtrll = new SprintController();

        int opcUser;
        String id = null;
        String respuesta;
        String menuOptions[] = {"Agregar", "Modificar", "Listar Sprint", "Salir"};

        do {
            opcUser = View.menu("Bienvenido al menu Sprint", menuOptions);
            switch (opcUser) {
                case 0:// Agregar
                    String data[] = {"Escriba el id proyecto a guardar", "Fecha de inicio", "Fecha Final"};
                    data = View.input("Datos del Sprint", data);//se despiega todas las entradas para que el usuario ingrese los datos
                    respuesta = SprintCtrll.create(data);
                    View.imprimir(respuesta);
                    break;
                case 1:// Modificar 
                    String datos[] = {"ID", "Fecha de inicio", "Fecha Final"};
                    data = View.input("Datos del Sprint", datos);

                    respuesta = SprintCtrll.update(data);
                    View.imprimir(respuesta);
                    break;
                case 2:// Listar Sprints
                    id = View.input("Ingrese el id del proyecto");

                    String TaskList[] = SprintCtrll.desplegar_Sprint(id);

                    if (TaskList != null) {
                        View.imprimir("========== Lista de Sprints ===========");
                        for (String line : TaskList) {
                            View.imprimir(line);
                        }
                        View.imprimir("=========================================");
                    } else {
                        View.imprimir("No existen Sprints");
                    }
                    break;
                case 3:// Salir

                    break;
                default:
                    View.imprimir("**** Opcion invalida *****");
                    break;

            }

        } while (opcUser != 3);

    }

}
