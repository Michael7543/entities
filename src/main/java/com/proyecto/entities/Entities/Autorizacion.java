package com.proyecto.entities.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "autorizacion", catalog = "bddcorpepn", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_autorizacion"})})
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Autorizacion implements Serializable {
    private static final long serialVersionUID = -2536977472245064966L;

    @Id
    @Column(name = "id_autorizacion")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;
    @ManyToOne
    @JoinColumn(name = "id_menu")
    //@JsonBackReference
    private Menu menu;
    @Column
    private String permisos;
}
