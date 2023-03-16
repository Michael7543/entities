package com.proyecto.entities.Entities;


import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PerfilUsuarioPK implements Serializable {
    private static final long serialVersionUID = 3141718902939642048L;


    @Column(name = "id_perfil")
    private int idPerfil;

    @Column(name = "id_usuario")
    private int idUsuario;


}
