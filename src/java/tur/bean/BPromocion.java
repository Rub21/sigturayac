/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.bean;

/**
 *
 * @author ruben
 */
public class BPromocion {

    private String tipo;
    private String descripcion;
    private String idproducto;

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
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
}
