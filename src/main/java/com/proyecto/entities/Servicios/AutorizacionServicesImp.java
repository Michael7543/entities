package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Autorizacion;
import com.proyecto.entities.Repositorios.AutorizacionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutorizacionServicesImp implements AutorizacionServices {

    public AutorizacionRepository autorizacionRepository;
    public final ModelMapper modelMapper;

    public AutorizacionServicesImp(AutorizacionRepository autorizacionRepository, ModelMapper modelMapper) {
        this.autorizacionRepository = autorizacionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public List<Autorizacion> getAllAutorizacion() {
        return autorizacionRepository.findAll();
    }

    @Override
    @Transactional
    public Autorizacion findById(Integer id) {
        return modelMapper.map(autorizacionRepository.findAutorizacionById(id), Autorizacion.class);
    }

    @Override
    @Transactional
    public void save(Autorizacion autorizacion) {
        autorizacionRepository.save(autorizacion);
    }

    @Override
    @Transactional
    public void delete(Autorizacion autorizacion) {
        autorizacionRepository.delete(autorizacion);
    }

}
