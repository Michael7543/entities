package com.proyecto.entities.Servicios;

import com.proyecto.entities.Entities.Usuario;
import com.proyecto.entities.Repositorios.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UsuariosServicesImp implements UsuarioServices {

    public UsuarioRepository repository;
    private final ModelMapper modelMapper;

    public UsuariosServicesImp(UsuarioRepository repository, ModelMapper modelMapper) {
        super();
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<Usuario> getAllUsuario() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void save(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario findById(Integer id) {
        return modelMapper.map(repository.findByIdUsuario(id), Usuario.class);
    }

    @Override
    @Transactional
    public void delete(Usuario usuario) {
        repository.delete(usuario);
    }
}
