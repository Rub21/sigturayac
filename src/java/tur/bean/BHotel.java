/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.bean;

import java.util.ArrayList;

/**
 *
 * @author ruben
 */
public class BHotel extends BProducto{

    private String idhotel;   
    private String categoria;
    private String descripcion;
    private String direccion;
    private String telefono;
    private String sitio;
    private String hora_aten;//horario de Atencion
    private BGeometry geometry;
    private ArrayList<BHabitacion> bHabitacion;
    private ArrayList<BServiciosAdicional> bServiciosAdicional;
    private ArrayList<BPromocion> bPromocion;
    private ArrayList<BImagen> imagenes;

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(String idhotel) {
        this.idhotel = idhotel;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHora_aten() {
        return hora_aten;
    }

    public void setHora_aten(String hora_aten) {
        this.hora_aten = hora_aten;
    }

    public BGeometry getbGeometry() {
        return geometry;
    }

    public void setbGeometry(BGeometry bGeometry) {
        this.geometry = bGeometry;
    }

    public ArrayList<BHabitacion> getbHabitacion() {
        return bHabitacion;
    }

    public void setbHabitacion(ArrayList<BHabitacion> bHabitacion) {
        this.bHabitacion = bHabitacion;
    }

    public ArrayList<BServiciosAdicional> getbServiciosAdicional() {
        return bServiciosAdicional;
    }

    public void setbServiciosAdicional(ArrayList<BServiciosAdicional> bServiciosAdicional) {
        this.bServiciosAdicional = bServiciosAdicional;
    }

    public ArrayList<BPromocion> getbPromocion() {
        return bPromocion;
    }

    public void setbPromocion(ArrayList<BPromocion> bPromocion) {
        this.bPromocion = bPromocion;
    }

    public ArrayList<BImagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<BImagen> imagenes) {
        this.imagenes = imagenes;
    }
        
}
