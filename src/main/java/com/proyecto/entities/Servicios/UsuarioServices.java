package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Usuario;

import java.util.List;

public interface UsuarioServices {

    List<Usuario> getAllUsuario();

    void save(Usuario usuario);

    Usuario findById(Integer id);

    void delete(Usuario usuario);
}
