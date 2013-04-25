/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.bean;

/**
 *
 * @author ruben
 */
public class BPuntoDesecho {
  private String idpunto;
  private String usuario;
  private String nombre ;
  private String fecha ;
  private String hora;
  private String url_img ;
  private String perfil_img;
  private String descripcion ;
  private String tipo;
  private Boolean estado;
  private String fecharegistro;
      BGeometry geometry;

    public BGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(BGeometry geometry) {
        this.geometry = geometry;
    }
      

    public String getIdpunto() {
        return idpunto;
    }

    public void setIdpunto(String idpunto) {
        this.idpunto = idpunto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getPerfil_img() {
        return perfil_img;
    }

    public void setPerfil_img(String perfil_img) {
        this.perfil_img = perfil_img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
  
    
}
