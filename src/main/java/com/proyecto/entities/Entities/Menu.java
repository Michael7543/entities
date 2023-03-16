package com.proyecto.entities.Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "menu", catalog = "bddcorpepn", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_menu"})})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Menu implements Serializable {
    private static final long serialVersionUID = -8440645326018471630L;
    @Id
    @Column(name = "id_menu")
    private Integer id;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "url")
    private String url;
    @Column(name = "orden")
    private int orden;
    @Column(name = "activo")
    private String activo;

    @JoinColumn(name = "id_aplicacion")
    @ManyToOne
    //@JsonManagedReference
    private Aplicacion aplicacion;

    //@JsonManagedReference
    @OneToMany(mappedBy = "menu")
    private List<Autorizacion> autorizaciones;


    @Transient
    private String urlCompleto;

    @Transient
    private String permisos;

}

