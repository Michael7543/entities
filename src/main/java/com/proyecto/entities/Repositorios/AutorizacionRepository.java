package com.proyecto.entities.Repositorios;

import com.proyecto.entities.Entities.Autorizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorizacionRepository extends JpaRepository<Autorizacion,Integer> {
    Object findAutorizacionById(Integer id);
}
