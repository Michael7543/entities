package com.proyecto.entities.Controller;


import com.proyecto.entities.DTO.AplicacionDto;
import com.proyecto.entities.Entities.Aplicacion;
import com.proyecto.entities.Servicios.AplicacionServices;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/Aplicacion"})
public class AplicacionController {

    AplicacionServices aplicacionServices;
    ModelMapper modelMapper;

    public AplicacionController(ModelMapper modelMapper, AplicacionServices aplicacionServices) {
        this.modelMapper = modelMapper;
        this.aplicacionServices = aplicacionServices;
    }

    @GetMapping({"/Allapp"})
    public ResponseEntity<?> getAutorizacion() {
        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        List<Aplicacion> listofAplicacion = aplicacionServices.getAllAplicacion();

        List<AplicacionDto> listofAplicacionDto = new ArrayList<>();

        if (!listofAplicacion.isEmpty()) {

            for (Aplicacion aplicacion : listofAplicacion) {

                listofAplicacionDto.add(modelMapper.map(aplicacion, AplicacionDto.class));

            }

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", listofAplicacionDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } else {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al mostrar los datos");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping("/app/{id}")
    public ResponseEntity<?> getAplicacionByIdAplicacion(@PathVariable("id") Integer id) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Aplicacion aplicacion = aplicacionServices.findById(id);

            //convertir Entity a DTO

            AplicacionDto aplicacionDto = modelMapper.map(aplicacion, AplicacionDto.class);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", aplicacionDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al buscar el Menu");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }


    @PostMapping({"/guardarApp"})
    public ResponseEntity<?> saveApp(@RequestBody AplicacionDto aplicacionDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        //convertir DTO a una entidad

        Aplicacion aplicacion = modelMapper.map(aplicacionDto, Aplicacion.class);

        aplicacionServices.save(aplicacion);

        jsonResponseMap.put("status", "OK");

        jsonResponseMap.put("message", "Los datos se guardaron con exito!");

        return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);

    }


    @DeleteMapping("/eliminarApp/{id}")
    public ResponseEntity<?> deleteApp(@PathVariable Integer id) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Aplicacion aplicacion = aplicacionServices.findById(id);

            aplicacionServices.delete(aplicacion);

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


    @PutMapping("/actualizarApp/{id}")
    public ResponseEntity<?> updateApp(@PathVariable Integer id, @RequestBody AplicacionDto aplicacionDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Aplicacion aplicacion = aplicacionServices.findById(id);

            aplicacion.setId(aplicacionDto.getId());

            aplicacion.setNombre(aplicacionDto.getNombre());

            aplicacion.setDescripcion(aplicacionDto.getDescripcion());

            aplicacion.setActivo(aplicacionDto.getActivo());

            aplicacion.setUrl(aplicacionDto.getUrl());

            aplicacion.setUrlfotoinfo(aplicacionDto.getUrlfotoinfo());

            aplicacionServices.save(aplicacion);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", aplicacionServices.findById(id));

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al actualizar el registro");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }
}
