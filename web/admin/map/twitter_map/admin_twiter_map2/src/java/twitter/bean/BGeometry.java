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

    /*geo: {
     coordinates: [-13.16728063, -74.22774986],
     type: "Point"
     },  */
    private String type = "Point";
    private double[] coordinates = new double[2];
    private double latitud;
    private double longitud;
    private String idproducto;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
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

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
