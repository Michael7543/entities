package com.proyecto.entities.Repositorios;

import com.proyecto.entities.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
//    List<Usuario> findAll();
//
//    void save(Usuario usuario);
//
//    void delete(Usuario usuario);

    Object findByIdUsuario(Integer id);
}
