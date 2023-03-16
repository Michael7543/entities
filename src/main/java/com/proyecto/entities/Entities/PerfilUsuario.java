package com.proyecto.entities.Entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "perfil_usuario")
public class PerfilUsuario implements Serializable {

    private static final long serialVersionUID = 7786192420822347998L;

    @EmbeddedId
    protected PerfilUsuarioPK perfilUsuarioPK;

   @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Perfil perfil;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuarios;


}
