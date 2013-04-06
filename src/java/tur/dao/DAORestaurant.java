/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tur.bean.BGeometry;
import tur.bean.BHotel;
import tur.bean.BImagen;
import tur.bean.BRestaurant;

/**
 *
 * @author ruben
 */
public class DAORestaurant {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //imagen
    Connection conni = null;
    PreparedStatement pstmti = null;
    ResultSet rsi = null;
    //habitacion

    public DAORestaurant(Connection conn) {
        this.conn = conn;
        this.conni = conn;

    }

    public void registrarrestaurant(BRestaurant bRestaurant) {


//SELECT insert_restaurant('4p', 'Nino', 'Restaurant', true, '4pre' , '2 Tenedores', 'Restaurant bueno', 'Parque de las marical', '310225','www..w.w.','de lunes a viernes', 'Puca Picante',-74.265, -12.9845)


        try {
            String sql = "SELECT insert_restaurant('" + bRestaurant.getIdproducto() + "',"
                    + " '" + bRestaurant.getNombre() + "',"
                    + " '" + bRestaurant.getClase() + "', "
                    + bRestaurant.isEstado() + ", "
                    + "'" + bRestaurant.getIdrestaurant() + "' ,"
                    + " '" + bRestaurant.getCategoria() + "',"
                    + " '" + bRestaurant.getDescripcion() + "', "
                    + "'" + bRestaurant.getDireccion() + "', "
                    + "'" + bRestaurant.getTelefono() + "',"
                    + "'" + bRestaurant.getSitio() + "',"
                    + "'" + bRestaurant.getHora_aten() + "',"
                    + "'" + bRestaurant.getEspecialidad() + "',"
                    + bRestaurant.getGeometry().getLatitud() + ", "
                    + bRestaurant.getGeometry().getLongitud() + ");";

            System.out.println(sql);
            String sql_img = "";
            for (int i = 0; i < bRestaurant.getImagenes().size(); i++) {

                sql_img += "INSERT INTO imagen(url, titulo, decripcion, idproducto) "
                        + "VALUES ('" + bRestaurant.getImagenes().get(i).getUrl()
                        + "','" + bRestaurant.getImagenes().get(i).getTitulo()
                        + "','" + bRestaurant.getImagenes().get(i).getDescripcion()
                        + "', '" + bRestaurant.getImagenes().get(i).getIdproducto() + "');";
            }



            sql = sql + sql_img;
            System.out.println("SQL" + sql);
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            /*pstmt.executeQuery();
             conn.commit();*/

        } catch (SQLException ex) {
            System.out.println("erorr en sql" + ex.toString());
            Logger.getLogger(DAOHotel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List listarrestaurant() {
        List list = new LinkedList();
        try {
            String sql = "SELECT idproducto, nombre, clase, estado, idrestaurant, categoria, descripcion, direccion, telefono,sitio, hora_aten, especialidad,lat, lon FROM select_restaurant;";
            //System.out.println("--:" + sql);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BRestaurant bRestaurant = new BRestaurant();
                BGeometry bGeometry = new BGeometry();
                //Producto                
                bRestaurant.setIdproducto(rs.getString("idproducto"));
                bRestaurant.setNombre(rs.getString("nombre"));
                bRestaurant.setClase(rs.getString("clase"));
                bRestaurant.setEstado(rs.getBoolean("estado"));
                //Restaurant
                bRestaurant.setIdrestaurant(rs.getString("idrestaurant"));
                bRestaurant.setCategoria(rs.getString("categoria"));
                bRestaurant.setDescripcion(rs.getString("descripcion"));
                bRestaurant.setDireccion(rs.getString("direccion"));
                bRestaurant.setTelefono(rs.getString("telefono"));
                bRestaurant.setSitio(rs.getString("sitio"));
                bRestaurant.setHora_aten(rs.getString("hora_aten"));
                bRestaurant.setEspecialidad(rs.getString("especialidad"));
                //Geometry
                bGeometry.setLatitud(rs.getDouble("lat"));
                bGeometry.setLongitud(rs.getDouble("lon"));
                bGeometry.setIdproducto(rs.getString("idproducto"));
                bGeometry.setCoordinates();
                bRestaurant.setGeometry(bGeometry);
                //Imagen
                bRestaurant.setImagenes(listarimagen(bRestaurant.getIdproducto()));
                list.add(bRestaurant);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error en Listar Recurso: " + ex);
        }
        return list;
    }

    public ArrayList<BImagen> listarimagen(String id) {

        ArrayList<BImagen> list = new ArrayList<BImagen>();
        try {
            String sql = "SELECT url, titulo, decripcion, idproducto  FROM imagen where idproducto='" + id + "';";
            System.out.println("-----------SQL IMAGEN-----" + sql);
            pstmti = conni.prepareStatement(sql);
            rsi = pstmti.executeQuery();
            while (rsi.next()) {
                BImagen bImagen = new BImagen();
                bImagen.setUrl(rsi.getString("url"));
                bImagen.setTitulo(rsi.getString("titulo"));
                bImagen.setDescripcion(rsi.getString("decripcion"));
                bImagen.setIdproducto(rsi.getString("idproducto"));
                list.add(bImagen);
            }
            pstmti.close();
            rsi.close();

        } catch (SQLException ex) {
            System.out.println("Error en Listar Imagen: " + ex);
        }
        return list;

    }
        public ArrayList<BImagen> listardestinos(String id) {

        ArrayList<BImagen> list = new ArrayList<BImagen>();
        try {
            String sql = "SELECT url, titulo, decripcion, idproducto  FROM imagen where idproducto='" + id + "';";
            System.out.println("-----------SQL IMAGEN-----" + sql);
            pstmti = conni.prepareStatement(sql);
            rsi = pstmti.executeQuery();
            while (rsi.next()) {
                BImagen bImagen = new BImagen();
                bImagen.setUrl(rsi.getString("url"));
                bImagen.setTitulo(rsi.getString("titulo"));
                bImagen.setDescripcion(rsi.getString("decripcion"));
                bImagen.setIdproducto(rsi.getString("idproducto"));
                list.add(bImagen);
            }
            pstmti.close();
            rsi.close();

        } catch (SQLException ex) {
            System.out.println("Error en Listar Imagen: " + ex);
        }
        return list;

    }
}
