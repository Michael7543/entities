package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Aplicacion;
import com.proyecto.entities.Repositorios.AplicacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AplicacionServicesImp implements AplicacionServices {
    public AplicacionRepository aplicacionRepository;
    public final ModelMapper modelMapper;

    public AplicacionServicesImp(AplicacionRepository aplicacionRepository, ModelMapper modelMapper) {
        this.aplicacionRepository = aplicacionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<Aplicacion> getAllAplicacion() {
        return aplicacionRepository.findAll();
    }

    @Override
    @Transactional
    public Aplicacion findById(Integer id) {
        return modelMapper.map(aplicacionRepository.findAplicacionById(id), Aplicacion.class);
    }

    @Override
    @Transactional
    public void save(Aplicacion aplicacion) {
        aplicacionRepository.save(aplicacion);
    }

    @Override
    @Transactional
    public void delete(Aplicacion aplicacion) {
        aplicacionRepository.delete(aplicacion);
    }

}
