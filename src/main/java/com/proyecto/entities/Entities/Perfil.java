package com.proyecto.entities.Entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "perfil", catalog = "bddcorpepn", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_perfil"})})

public class Perfil implements Serializable {

    private static final long serialVersionUID = -83661352925454730L;
    @Id
    @Column(name = "id_perfil", nullable = false)
    private Integer idPerfil;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "activo", nullable = false, length = 2)
    private String activo;

   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "perfil_usuario",
            joinColumns = @JoinColumn(name = "id_perfil"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private List<Usuario> usuarios;
}
