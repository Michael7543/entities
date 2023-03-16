package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Aplicacion;

import java.util.List;

public interface AplicacionServices {

    List<Aplicacion> getAllAplicacion();


    Aplicacion findById(Integer id);


    void save(Aplicacion aplicacion);


    void delete(Aplicacion aplicacion);
}
