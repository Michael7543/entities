package com.proyecto.entities.DTO;

import lombok.Data;

import java.io.Serializable;


@Data
public class PerfilUsuarioPKDto implements Serializable {

    private static final long serialVersionUID = 30755270675983738L;
    private int idPerfil;
    private int idUsuario;

}