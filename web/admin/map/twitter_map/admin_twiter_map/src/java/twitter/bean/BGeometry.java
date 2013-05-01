/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.bean;

/**
 *
 * @author ruben
 */
public class BGeometry {

    private String type = "Point";
    private double[] coordinates = new double[2];
    private double latitud;
    private double longitud;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates() {
        this.coordinates[0]=getLongitud();
        this.coordinates[1]=getLatitud();

    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
    
    
}
