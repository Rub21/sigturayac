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
    private BGeometry geometry;
    private ArrayList<BImagen> imagenes; 

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

    public BGeometry getbGeometry() {
        return geometry;
    }

    public void setbGeometry(BGeometry bGeometry) {
        this.geometry = bGeometry;
    }

    public ArrayList<BImagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<BImagen> imagenes) {
        this.imagenes = imagenes;
    }

    
    public String features() {
        return "Nombre" + this.getNombre() + "\n"
                + "Categoria" + this.getCategoria() + "\n"
                + "Tipo" + this.getTipo();
    }
}
