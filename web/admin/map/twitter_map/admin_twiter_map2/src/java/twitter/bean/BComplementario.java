/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.bean;

import java.util.ArrayList;

/**
 *
 * @author ruben
 */
public class BComplementario extends BProducto{

    private String idcomplementario;
    private String tipo;
    private String descripcion;
    private String direccion;
    private String telefono;
    private String sitio;
    private String hora_aten;
    private BGeometry geometry;
    private ArrayList<BImagen> imagenes;

    public String getIdcomplementario() {
        return idcomplementario;
    }

    public void setIdcomplementario(String idcomplementario) {
        this.idcomplementario = idcomplementario;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getHora_aten() {
        return hora_aten;
    }

    public void setHora_aten(String hora_aten) {
        this.hora_aten = hora_aten;
    }

    public BGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(BGeometry geometry) {
        this.geometry = geometry;
    }

    public ArrayList<BImagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<BImagen> imagenes) {
        this.imagenes = imagenes;
    }
    
}
