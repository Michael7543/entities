package com.proyecto.entities.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "aplicacion", catalog = "bddcorpepn", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_aplicacion"})})
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Aplicacion implements Serializable {
    private static final long serialVersionUID = 3529661661282799178L;
    @Id
    @Column(name = "id_aplicacion")
    @SequenceGenerator(name = "secAplicacion", sequenceName = "sec_aplicacion", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secAplicacion")
    private Integer id;
    private String nombre;
    private String descripcion;
    private String activo;
    private String url;
    private String urlfotoinfo;
}