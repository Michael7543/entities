package com.proyecto.entities.Controller;

import com.proyecto.entities.DTO.PerfilDto;
import com.proyecto.entities.Entities.Perfil;
import com.proyecto.entities.Servicios.PerfilServices;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping({"/perfiles"})
public class PerfilesController {

    PerfilServices services;

    ModelMapper modelMapper;


    public PerfilesController(PerfilServices services, ModelMapper modelMapper) {
        this.services = services;
        this.modelMapper = modelMapper;
    }


    //Perfiles
    //Obtener todos los registros de Perfil

    @GetMapping({"/All"})

    public ResponseEntity<?> getPerfil() {
        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        List<Perfil> listofPerfil = services.getAllPerfil();

        List<PerfilDto> listofPerfilDto = new ArrayList<>();

        if (!listofPerfil.isEmpty()) {

            for (Perfil perfil : listofPerfil) {

                listofPerfilDto.add(modelMapper.map(perfil, PerfilDto.class));

            }

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", listofPerfilDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } else {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al mostrar los datos");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }
    }


    //Obtener perfiles por Id


    @GetMapping("/perfil/{idPerfil}")
    public ResponseEntity<?> getPerfilByIdPerfil(@PathVariable("idPerfil") Integer idPerfil) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Perfil perfil = services.findByIdPerfil(idPerfil);

            //convertir Entity a DTO

            PerfilDto perfilDto = modelMapper.map(perfil, PerfilDto.class);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", perfilDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al buscar el perfil");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }

    //Guardar registro perfiles

    @PostMapping({"/guardar"})
    public ResponseEntity<?> saveUser(@RequestBody PerfilDto perfilDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        //convertir DTO a una entidad

        Perfil perfil = modelMapper.map(perfilDto, Perfil.class);

        services.save(perfil);

        jsonResponseMap.put("status", "OK");

        jsonResponseMap.put("message", "Los datos se guardaron con exito!");

        return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);

    }


    //Eliminar registro de perfiles

    @DeleteMapping("/eliminar/{idPerfil}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer idPerfil) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Perfil perfil = services.findByIdPerfil(idPerfil);

            services.delete(perfil);

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


    //Actualizar registro de perfiles

    @PutMapping("/actualizar/{idPerfil}")
    public ResponseEntity<?> updatePerfil(@PathVariable Integer idPerfil, @RequestBody PerfilDto perfilDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Perfil perfil = services.findByIdPerfil(idPerfil);

            perfil.setIdPerfil(perfilDto.getIdPerfil());

            perfil.setNombre(perfilDto.getNombre());

            perfil.setDescripcion(perfilDto.getDescripcion());

            perfil.setActivo(perfilDto.getActivo());

            services.save(perfil);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", services.findByIdPerfil(idPerfil));

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al actualizar el registro");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }


}
