package com.proyecto.entities.Repositorios;

import com.proyecto.entities.Entities.Aplicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicacionRepository extends JpaRepository<Aplicacion,Long> {
    Object findAplicacionById(Integer id);
}
