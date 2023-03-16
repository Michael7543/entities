package com.proyecto.entities.DTO;

import com.proyecto.entities.Entities.Menu;
import com.proyecto.entities.Entities.Perfil;
import lombok.Data;

import java.io.Serializable;

@Data
public class AutorizacionDto implements Serializable {
    private static final long serialVersionUID = 4588800887030152692L;
    private Integer id;
    private Perfil perfil;
    private Menu menu;
    private String permisos;

/*    public AutorizacionDto(long id, Perfil perfil, Menu menu, String permisos) {
        this.id = id;
        this.perfil = perfil;
        this.menu = menu;
        this.permisos = permisos;
    }

    public long getId() {
        return id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public Menu getMenu() {
        return menu;
    }

    public String getPermisos() {
        return permisos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutorizacionDto entity = (AutorizacionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.perfil, entity.perfil) &&
                Objects.equals(this.menu, entity.menu) &&
                Objects.equals(this.permisos, entity.permisos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, perfil, menu, permisos);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "perfil = " + perfil + ", " +
                "menu = " + menu + ", " +
                "permisos = " + permisos + ")";
    }*/
}