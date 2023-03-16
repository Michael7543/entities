package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Menu;
import com.proyecto.entities.Repositorios.MenuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuServicesImp implements MenuServices {

    public MenuRepository menuRepository;
    public final ModelMapper modelMapper;

    public MenuServicesImp(MenuRepository menuRepository, ModelMapper modelMapper) {
        this.menuRepository = menuRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }


    @Override
    @Transactional
    public Menu findById(Integer id) {
        return modelMapper.map(menuRepository.findMenuById(id), Menu.class);
    }

    @Override
    @Transactional
    public void save(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    @Transactional
    public void delete(Menu menu) {
        menuRepository.delete(menu);
    }
}
