package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Menu;

import java.util.List;

public interface MenuServices {

    List<Menu> getAllMenu();

    Menu findById(Integer id);

    void save(Menu menu);

    void delete(Menu menu);

}
