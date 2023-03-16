package com.proyecto.entities.Repositorios;

import com.proyecto.entities.Entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
    Object findPerfilByIdPerfil(Integer idPerfil);

//    List<Perfil> findAll();
//
//    void save(Perfil perfil);
//
//    void delete(Perfil perfil);
//
//    Object findPerfilByIdPerfil(Integer idPerfil);

}
