/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller.tarea_controller;

import java.util.List;

public interface TareaInterface {
    public String create(String[] data);

    public String update(String[] data);

    public String[] buscar(String id);

    public String delete(String id);
    
    public String addColaborador(String idTarea, String idColaborador);
    
    public List tareaDelSprint(String[] dataId);
}
