package com.proyecto.entities.Controller;


import com.proyecto.entities.DTO.AutorizacionDto;
import com.proyecto.entities.Entities.Autorizacion;
import com.proyecto.entities.Servicios.AutorizacionServices;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/Autorizacion"})
public class AutorizacionController {

    AutorizacionServices autorizacionServices;
    ModelMapper modelMapper;

    public AutorizacionController(ModelMapper modelMapper, AutorizacionServices autorizacionServices) {
        this.modelMapper = modelMapper;
        this.autorizacionServices = autorizacionServices;
    }


    @GetMapping({"/AllAutoriz"})
    public ResponseEntity<?> getAutorizacion() {
        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        List<Autorizacion> listofAutoriza = autorizacionServices.getAllAutorizacion();

        List<AutorizacionDto> listofAutorizaDto = new ArrayList<>();

        if (!listofAutoriza.isEmpty()) {

            for (Autorizacion autorizacion : listofAutoriza) {

                listofAutorizaDto.add(modelMapper.map(autorizacion, AutorizacionDto.class));

            }

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", listofAutorizaDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } else {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al mostrar los datos");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping("/autorizacion/{id}")
    public ResponseEntity<?> getAutorizacionByIdAutorizacion(@PathVariable("id") Integer id) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Autorizacion autorizacion = autorizacionServices.findById(id);

            //convertir Entity a DTO

            AutorizacionDto autorizacionDto = modelMapper.map(autorizacion, AutorizacionDto.class);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", autorizacionDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al buscar");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }


    @PostMapping({"/guardarAutorizacion"})
    public ResponseEntity<?> saveAutorizacion(@RequestBody AutorizacionDto autorizacionDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        //convertir DTO a una entidad

        Autorizacion autorizacion = modelMapper.map(autorizacionDto, Autorizacion.class);

        autorizacionServices.save(autorizacion);

        jsonResponseMap.put("status", "OK");

        jsonResponseMap.put("message", "Los datos se guardaron con exito!");

        return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);

    }


    @DeleteMapping("/eliminarAuto/{id}")
    public ResponseEntity<?> deleteAutorizacion(@PathVariable Integer id) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Autorizacion autorizacion = autorizacionServices.findById(id);

            autorizacionServices.delete(autorizacion);

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

    @PutMapping("/actualizarAuth/{id}")
    public ResponseEntity<?> updateAuth(@PathVariable Integer id, @RequestBody AutorizacionDto autorizacionDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Autorizacion autorizacion = autorizacionServices.findById(id);

            autorizacion.setId(autorizacionDto.getId());

            autorizacion.setPerfil(autorizacionDto.getPerfil());

            autorizacion.setMenu(autorizacionDto.getMenu());

            autorizacion.setPermisos(autorizacionDto.getPermisos());


            autorizacionServices.save(autorizacion);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", autorizacionServices.findById(id));

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al actualizar el registro");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }
}
