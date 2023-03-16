package com.proyecto.entities.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "usuario", catalog = "bddcorpepn", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_usuario"})})

public class Usuario implements Serializable {

    private static final long serialVersionUID = 4992348863354437351L;

    @Id
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;
    @Column(name = "nombre_usuario", nullable = false, length = 30)
    private String nombreUsuario;
    @Column(name = "clave", length = 50)
    private String clave;
    @Column(name = "cedula", nullable = false, length = 10)
    private String cedula;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "id_personal", length = 10)
    private String idPersonal;
    @Column(name = "id_unidad")
    private Integer idUnidad;
    @Column(name = "id_laboratorio", length = 10)
    private String idLaboratorio;
    @Column(name = "id_bodega", length = 10)
    private String idBodega;
    @Column(name = "activo", length = 50)
    private String activo;
    @Column(name = "prueba", length = 80)
    private String prueba;
    @Column(name = "claveenc", length = 50)
    private String claveenc;
    @Column(name = "email", length = 60)
    private String email;
    @Column(name = "nombres", length = 100)
    private String nombres;
    @Column(name = "estmail", length = 80)
    private String estmail;
    @Column(name = "claveok", length = 200)
    private String claveok;
    @Column(name = "id_facultad", length = 3)
    private String idFacultad;
    @Column(name = "id_depart")
    private Integer idDepart;
    @Column(name = "plan_trabajo", length = 2147483647)
    private String planTrabajo;
    @Column(name = "dep1", length = 10)
    private String dep1;
    @Column(name = "dep2", length = 10)
    private String dep2;
    @Column(name = "dep3", length = 10)
    private String dep3;
    @Column(name = "dep4", length = 10)
    private String dep4;
    @Column(name = "tipo_u", length = 1)
    private String tipoU;
    @Column(name = "id_carrera", length = 10)
    private String idCarrera;
    @Column(name = "pathfirma", length = 1000)
    private String pathfirma;
    @Column(name = "usercambio", length = 200)
    private String usercambio;


    @ManyToMany(mappedBy = "usuarios")
    private List<Perfil> perfiles;

}


