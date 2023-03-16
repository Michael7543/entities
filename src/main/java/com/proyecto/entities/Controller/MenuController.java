package com.proyecto.entities.Controller;


import com.proyecto.entities.DTO.MenuDto;
import com.proyecto.entities.Entities.Menu;
import com.proyecto.entities.Servicios.MenuServices;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/Menu"})
public class MenuController {

    MenuServices menuServices;
    ModelMapper modelMapper;


    public MenuController(ModelMapper modelMapper, MenuServices menuServices) {
        this.modelMapper = modelMapper;
        this.menuServices = menuServices;
    }

    @GetMapping({"/AllMenu"})
    public ResponseEntity<?> getMenu() {
        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        List<Menu> listofMenu = menuServices.getAllMenu();

        List<MenuDto> listofMenuDto = new ArrayList<>();

        if (!listofMenu.isEmpty()) {

            for (Menu menu : listofMenu) {

                listofMenuDto.add(modelMapper.map(menu, MenuDto.class));

            }

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", listofMenuDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } else {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al mostrar los datos");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }
    }


    @GetMapping("/menu/{id}")
    public ResponseEntity<?> getMenuByIdMenu(@PathVariable("id") Integer id) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Menu menu = menuServices.findById(id);

            //convertir Entity a DTO

            MenuDto menuDto = modelMapper.map(menu, MenuDto.class);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", menuDto);

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al buscar el Menu");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }


    @PostMapping({"/guardarMenu"})
    public ResponseEntity<?> saveMenu(@RequestBody MenuDto menuDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        //convertir DTO a una entidad

        Menu menu = modelMapper.map(menuDto, Menu.class);

        menuServices.save(menu);

        jsonResponseMap.put("status", "OK");

        jsonResponseMap.put("message", "Los datos se guardaron con exito!");

        return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);

    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable Integer id) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Menu menu = menuServices.findById(id);

            menuServices.delete(menu);

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


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> updateMenu(@PathVariable Integer id, @RequestBody MenuDto menuDto) {

        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();

        try {

            Menu menu = menuServices.findById(id);

            menu.setId(menuDto.getId());

            menu.setTipo(menuDto.getTipo());

            menu.setNombre(menuDto.getNombre());

            menu.setDescripcion(menuDto.getDescripcion());
            menu.setUrl(menuDto.getUrl());
            menu.setOrden(menuDto.getOrden());

            menu.setActivo(menuDto.getActivo());
            menu.setAplicacion(menuDto.getAplicacion());
            menu.setAutorizaciones(menuDto.getAutorizaciones());

            menuServices.save(menu);

            jsonResponseMap.put("status", "OK");

            jsonResponseMap.put("data", menuServices.findById(id));

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);

        } catch (Exception ex) {

            jsonResponseMap.clear();

            jsonResponseMap.put("status", "Error");

            jsonResponseMap.put("message", "Error al actualizar el registro");

            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);

        }

    }

}
