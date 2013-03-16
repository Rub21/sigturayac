package tur.bean;

import java.util.ArrayList;

public class BRecurso  extends BProducto{
    /* Definido
    private String id;
    private String nombre;
    private String clase;
    private boolean  estado;
    */
    private String idrecurso;   
    private String categoria;
    private String tipo;
    private String descripcion;
    private String corredor;
    private BGeometry geometry;
    private ArrayList<BImagen> imagenes; 
    private BDetalle detalle;

    public String getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(String idrecurso) {
        this.idrecurso = idrecurso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public String getCorredor() {
        return corredor;
    }

    public void setCorredor(String corredor) {
        this.corredor = corredor;
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

    public BDetalle getDetalle() {
        return detalle;
    }

    public void setDetalle(BDetalle detalle) {
        this.detalle = detalle;
    }

    
    public String features() {
        return "Nombre" + this.getNombre() + "\n"
                + "Categoria" + this.getCategoria() + "\n"
                + "Tipo" + this.getTipo();
    }
}
