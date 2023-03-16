package com.proyecto.entities.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class AplicacionDto implements Serializable {

    private static final long serialVersionUID = -7765597090772219634L;
    private Integer id;
    private String nombre;
    private String descripcion;
    private String activo;
    private String url;
    private String urlfotoinfo;

   /* public AplicacionDto(long id, String nombre, String descripcion, String activo, String url, String urlfotoinfo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.url = url;
        this.urlfotoinfo = urlfotoinfo;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getActivo() {
        return activo;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlfotoinfo() {
        return urlfotoinfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AplicacionDto entity = (AplicacionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nombre, entity.nombre) &&
                Objects.equals(this.descripcion, entity.descripcion) &&
                Objects.equals(this.activo, entity.activo) &&
                Objects.equals(this.url, entity.url) &&
                Objects.equals(this.urlfotoinfo, entity.urlfotoinfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, activo, url, urlfotoinfo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nombre = " + nombre + ", " +
                "descripcion = " + descripcion + ", " +
                "activo = " + activo + ", " +
                "url = " + url + ", " +
                "urlfotoinfo = " + urlfotoinfo + ")";
    }*/
}