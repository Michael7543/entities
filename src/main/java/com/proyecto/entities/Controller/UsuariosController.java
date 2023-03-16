package com.proyecto.entities.Controller;

import com.proyecto.entities.DTO.UsuarioDto;
import com.proyecto.entities.Entities.Usuario;
import com.proyecto.entities.Servicios.UsuarioServices;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/usuarios"})
public class UsuariosController {

    UsuarioServices service;

    ModelMapper modelMapper;

    public UsuariosController(UsuarioServices service, ModelMapper modelMapper) {
        super();
        this.service = service; // Entidad Usuario
        this.modelMapper = modelMapper; // modelMapper
    }

    //Usuarios
    //Obtener todos los registros de Usuarios

    @GetMapping({"/usersTotal"})
    public ResponseEntity<?> getUser() {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<String, Object>();

        List<Usuario> listofUser = service.getAllUsuario();

        List<UsuarioDto> listofUserDto = new ArrayList<>();

        if (!listofUser.isEmpty()) {

            for (Usuario usuario : listofUser) {

                listofUserDto.add(modelMapper.map(usuario, UsuarioDto.class));

            }

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", listofUserDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } else {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Data is not found");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }


    //Guardar registro Usuarios

    @PostMapping({"/saveUsuarios"})
    public ResponseEntity<?> saveUsuarios(@RequestBody UsuarioDto usuarioDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        //convertir DTO a una entidad

        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);

        service.save(usuario);

        jsonResponseMap.put("status", "OK");

        jsonResponseMap.put("message", "Los datos se guardaron satisfactoriamente!");

        return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);

    }

    //Buscar Registro Por Id

    @GetMapping("/perfil/{idUsuario}")
    public ResponseEntity<?> getPerfilByIdPerfil(@PathVariable("idUsuario") Integer idUsuario) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Usuario usuario = service.findById(idUsuario);

            //convertir Entity a DTO

            UsuarioDto usuarioDto = modelMapper.map(usuario, UsuarioDto.class);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", usuarioDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al buscar el Usuario");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }


    //eliminar Registro por Id
    @DeleteMapping("/eliminar/{idUsuario}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer idUsuario) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Usuario usuario = service.findById(idUsuario);

            service.delete(usuario);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("message", "El registro se borro con exito!");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al eliminar el registro");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }


    //Actualizar registro Usuarios

    @PutMapping("/actualizar/{idUsuario}")
    public ResponseEntity<?> updateUsuario(@PathVariable Integer idUsuario, @RequestBody UsuarioDto usuarioDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Usuario usuario = service.findById(idUsuario);

            usuario.setIdUsuario(usuarioDto.getIdUsuario());
            usuario.setNombreUsuario(usuarioDto.getNombreUsuario());
            usuario.setClave(usuarioDto.getClave());
            usuario.setCedula(usuarioDto.getCedula());

            service.save(usuario);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", service.findById(idUsuario));

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al actualizar el registro");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }

}
