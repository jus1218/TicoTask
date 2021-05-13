package com.mycompany.controller;

public interface ColaboradorInterface {
    //CRUD C-CREATE R-READ U-UPDATE D-DELETE

    public String create(String[] data);

    public String update(String[] data);

    public String buscar(String id);

    public String delete(String id);

}
