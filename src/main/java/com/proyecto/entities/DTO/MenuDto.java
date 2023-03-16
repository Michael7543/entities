package com.proyecto.entities.DTO;

import com.proyecto.entities.Entities.Aplicacion;
import com.proyecto.entities.Entities.Autorizacion;
import com.proyecto.entities.Entities.Menu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuDto implements Serializable {
    private static final long serialVersionUID = -6963887214402541467L;
    private Integer id;
    private String tipo;
    private String nombre;
    private String descripcion;
    private String url;
    private int orden;
    private String activo;
    private Aplicacion aplicacion;
    private List<Autorizacion> autorizaciones;
    private boolean expandido;

/*
    public MenuDto(long id, Menu menuPadre, List<Menu> subMenus, String tipo, String nombre, String descripcion, String url, int orden, String activo, Aplicacion aplicacion, List<Autorizacion> autorizaciones, boolean expandido) {
        this.id = id;
        this.menuPadre = menuPadre;
        this.subMenus = subMenus;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.orden = orden;
        this.activo = activo;
        this.aplicacion = aplicacion;
        this.autorizaciones = autorizaciones;
        this.expandido = expandido;
    }

    public long getId() {
        return id;
    }

    public Menu getMenuPadre() {
        return menuPadre;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
    }

    public int getOrden() {
        return orden;
    }

    public String getActivo() {
        return activo;
    }

    public Aplicacion getAplicacion() {
        return aplicacion;
    }

    public List<Autorizacion> getAutorizaciones() {
        return autorizaciones;
    }

    public boolean getExpandido() {
        return expandido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDto entity = (MenuDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.menuPadre, entity.menuPadre) &&
                Objects.equals(this.subMenus, entity.subMenus) &&
                Objects.equals(this.tipo, entity.tipo) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.descripcion, entity.descripcion) &&
                Objects.equals(this.url, entity.url) &&
                Objects.equals(this.orden, entity.orden) &&
                Objects.equals(this.activo, entity.activo) &&
                Objects.equals(this.aplicacion, entity.aplicacion) &&
                Objects.equals(this.autorizaciones, entity.autorizaciones) &&
                Objects.equals(this.expandido, entity.expandido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuPadre, subMenus, tipo, nombre, descripcion, url, orden, activo, aplicacion, autorizaciones, expandido);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "menuPadre = " + menuPadre + ", " +
                "subMenus = " + subMenus + ", " +
                "tipo = " + tipo + ", " +
                "nombre = " + nombre + ", " +
                "descripcion = " + descripcion + ", " +
                "url = " + url + ", " +
                "orden = " + orden + ", " +
                "activo = " + activo + ", " +
                "aplicacion = " + aplicacion + ", " +
                "autorizaciones = " + autorizaciones + ", " +
                "expandido = " + expandido + ")";
    }*/
}