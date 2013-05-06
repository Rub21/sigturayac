/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.bean;

/**
 *
 * @author ruben
 */
public class BEstadistica {
    
    String fecha;
    int p_pen;//puntos pendientes
    int p_ate;//puntos atendidos

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getP_pen() {
        return p_pen;
    }

    public void setP_pen(int p_pen) {
        this.p_pen = p_pen;
    }



    public int getP_ate() {
        return p_ate;
    }

    public void setP_ate(int p_ate) {
        this.p_ate = p_ate;
    }
    
}
