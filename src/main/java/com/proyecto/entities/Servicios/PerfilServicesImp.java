package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Perfil;
import com.proyecto.entities.Repositorios.PerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PerfilServicesImp implements PerfilServices {

    public PerfilRepository repository;
    public final ModelMapper modelMapper;

    public PerfilServicesImp(PerfilRepository repository, ModelMapper modelMapper) {
        super();
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<Perfil> getAllPerfil() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void save(Perfil perfil) {
        repository.save(perfil);
    }

    @Override
    @Transactional
    public Perfil findByIdPerfil(Integer idPerfil) {
        return modelMapper.map(repository.findPerfilByIdPerfil(idPerfil), Perfil.class);
    }

    @Override
    @Transactional
    public void delete(Perfil perfil) {
        repository.delete(perfil);
    }
}
