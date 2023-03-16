package com.proyecto.entities.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class UsuarioDto implements Serializable {

    private static final long serialVersionUID = 8325993982963801154L;
    private Integer idUsuario;
    private String nombreUsuario;
    private String clave;
    private String cedula;
    private Date fechaCreacion;
    private String idPersonal;
    private Integer idUnidad;
    private String idLaboratorio;
    private String idBodega;
    private String activo;
    private String prueba;
    private String claveenc;
    private String email;
    private String nombres;
    private String estmail;
    private String claveok;
    private String idFacultad;
    private Integer idDepart;
    private String planTrabajo;
    private String dep1;
    private String dep2;
    private String dep3;
    private String dep4;
    private String tipoU;
    private String idCarrera;
    private String pathfirma;
    private String usercambio;


}