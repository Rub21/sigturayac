/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.bean;

/**
 *
 * @author ruben
 */
public class BDetalle {
    private String distancia;
    private String costo_ingreso;
    private String hora_atencion;
    private String temperatura;
    private String como_llegar;
    private String idrecurso;

    public String getIdrecurso() {
        return idrecurso;
    }

    public void setIdrecurso(String idrecurso) {
        this.idrecurso = idrecurso;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getCosto_ingreso() {
        return costo_ingreso;
    }

    public void setCosto_ingreso(String costo_ingreso) {
        this.costo_ingreso = costo_ingreso;
    }

    public String getHora_atencion() {
        return hora_atencion;
    }

    public void setHora_atencion(String hora_atencion) {
        this.hora_atencion = hora_atencion;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getComo_llegar() {
        return como_llegar;
    }

    public void setComo_llegar(String como_llegar) {
        this.como_llegar = como_llegar;
    }

}
