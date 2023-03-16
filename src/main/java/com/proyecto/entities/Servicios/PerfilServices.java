package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Perfil;

import java.util.List;


public interface PerfilServices {

    List<Perfil> getAllPerfil();

    void save(Perfil perfil);

    Perfil findByIdPerfil(Integer idPerfil);

    void delete(Perfil perfil);
}
