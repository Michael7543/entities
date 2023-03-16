package com.proyecto.entities.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class PerfilDto implements Serializable {
    private static final long serialVersionUID = 8092073970845303563L;
    private Integer idPerfil;
    private String nombre;
    private String descripcion;
    private String activo;
}