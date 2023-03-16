package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Autorizacion;

import java.util.List;

public interface AutorizacionServices {


    List<Autorizacion> getAllAutorizacion();


    Autorizacion findById(Integer id);


    void save(Autorizacion autorizacion);


    void delete(Autorizacion autorizacion);
}
