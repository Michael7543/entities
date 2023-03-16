package com.proyecto.entities.DTO;

import com.proyecto.entities.Entities.Perfil;
import com.proyecto.entities.Entities.PerfilUsuarioPK;
import lombok.Data;

import java.io.Serializable;

@Data
public class PerfilUsuarioDto implements Serializable {

    private static final long serialVersionUID = 8280601381078397428L;
    private PerfilUsuarioPK perfilUsuarioPK;
    private Perfil perfil;
}
