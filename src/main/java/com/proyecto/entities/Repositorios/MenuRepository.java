package com.proyecto.entities.Repositorios;

import com.proyecto.entities.Entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Object findMenuById(Integer id);

}
