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
import tur.bean.BHabitacion;
import tur.bean.BHotel;
import tur.bean.BImagen;
import tur.bean.BPromocion;
import tur.bean.BServiciosAdicional;

/**
 *
 * @author ruben
 */
public class DAOHotel {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //imagen
    Connection conni = null;
    PreparedStatement pstmti = null;
    ResultSet rsi = null;
    //habitacion
    Connection connh = null;
    PreparedStatement pstmth = null;
    ResultSet rsh = null;
    //Servicio adicional
    Connection conns = null;
    PreparedStatement pstmts = null;
    ResultSet rss = null;

    public DAOHotel(Connection conn) {
        this.conn = conn;
        this.conni = conn;
        this.connh = conn;
        this.conns = conn;
    }

    public void registrarhotel(BHotel bHotel) {
        /*SELECT insert_hotel('29p', 'Sierra Dorada', 'Hotel', true, '29pr' , '2 estrellas', 'Hotel bueno', 'Parque de las marical', '310225','www..w.w.','de lunes a viernes', -74.265, -12.9845)


         */
        try {
            String sql = "SELECT insert_hotel('" + bHotel.getIdproducto() + "',"
                    + " '" + bHotel.getNombre() + "',"
                    + " '" + bHotel.getClase() + "', "
                    + bHotel.isEstado() + ", "
                    + "'" + bHotel.getIdhotel() + "' ,"
                    + " '" + bHotel.getCategoria() + "',"
                    + " '" + bHotel.getDescripcion() + "', "
                    + "'" + bHotel.getDireccion() + "', "
                    + "'" + bHotel.getTelefono() + "',"
                    + "'" + bHotel.getSitio() + "',"
                    + "'" + bHotel.getHora_aten() + "',"
                    + bHotel.getbGeometry().getLatitud() + ", "
                    + bHotel.getbGeometry().getLongitud() + ");";

            //IMAGEN
            String sql_img = "";
            for (int i = 0; i < bHotel.getImagenes().size(); i++) {

                sql_img += "INSERT INTO imagen(url, titulo, decripcion, idproducto) "
                        + "VALUES ('" + bHotel.getImagenes().get(i).getUrl()
                        + "','" + bHotel.getImagenes().get(i).getTitulo()
                        + "','" + bHotel.getImagenes().get(i).getDescripcion()
                        + "', '" + bHotel.getImagenes().get(i).getIdproducto() + "');";
            }

            //HABITACION
            String sql_hab = "";
            for (int i = 0; i < bHotel.getbHabitacion().size(); i++) {

                sql_hab += "INSERT INTO habitacion(tipo, precio, descripcion, idhotel)"
                        + " VALUES ('" + bHotel.getbHabitacion().get(i).getTipo() + "',"
                        + bHotel.getbHabitacion().get(i).getPrecio() + ","
                        + " '" + bHotel.getbHabitacion().get(i).getDescripcion() + "',"
                        + " '" + bHotel.getbHabitacion().get(i).getIdhotel() + "');";
            }

            //SERVICIO
            String sql_ser = "";
            for (int i = 0; i < bHotel.getbServiciosAdicional().size(); i++) {

                sql_ser += "INSERT INTO servicion_adicional(tipo, descripcion, idproducto) "
                        + "VALUES ('" + bHotel.getbServiciosAdicional().get(i).getTipo() + "', "
                        + "'" + bHotel.getbServiciosAdicional().get(i).getDescripcion() + "', "
                        + "'" + bHotel.getbServiciosAdicional().get(i).getIdproducto() + "');";
            }
            //PROMOCION
            String sql_prom = "";
            for (int i = 0; i < bHotel.getbPromocion().size(); i++) {

                sql_prom += "INSERT INTO promocion(tipo, descripcion, idproducto) "
                        + "VALUES ('" + bHotel.getbPromocion().get(i).getTipo() + "',"
                        + " '" + bHotel.getbPromocion().get(i).getDescripcion() + "', "
                        + "'" + bHotel.getbPromocion().get(i).getIdproducto() + "');";
            }


            sql = sql + sql_img + sql_hab + sql_ser + sql_prom;
            System.out.println("SQL" + sql);
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            /*pstmt.executeQuery();
             conn.commit();*/

        } catch (SQLException ex) {
            Logger.getLogger(DAOHotel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List listarhotel() {

        List list = new LinkedList();

        try {

            String sql = "SELECT idproducto, nombre, clase, estado, idhotel, categoria, descripcion, direccion, telefono, sitio,hora_aten, lat, lon FROM select_hotel";
            //System.out.println("--:" + sql);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BHotel bHotel = new BHotel();
                BGeometry bGeometry = new BGeometry();

                //Producto                
                bHotel.setIdproducto(rs.getString("idproducto"));
                bHotel.setNombre(rs.getString("nombre"));
                bHotel.setClase(rs.getString("clase"));
                bHotel.setEstado(rs.getBoolean("estado"));

                //Recurso
                bHotel.setIdhotel(rs.getString("idhotel"));
                bHotel.setCategoria(rs.getString("categoria"));
                bHotel.setDescripcion(rs.getString("descripcion"));
                bHotel.setDireccion(rs.getString("direccion"));
                bHotel.setTelefono(rs.getString("telefono"));
                bHotel.setSitio(rs.getString("sitio"));
                bHotel.setHora_aten(rs.getString("hora_aten"));


                //Geometry
                bGeometry.setLatitud(rs.getDouble("lat"));
                bGeometry.setLongitud(rs.getDouble("lon"));
                bGeometry.setIdproducto(rs.getString("idproducto"));
                bGeometry.setCoordinates();
                bHotel.setbGeometry(bGeometry);

                //Imagen
                bHotel.setImagenes(listarimagen(bHotel.getIdproducto()));
                //habitacion
                bHotel.setbHabitacion(listarhabitacion(bHotel.getIdhotel()));
                //servicoadicional
                bHotel.setbServiciosAdicional(listarservicio(bHotel.getIdproducto()));
                //promocion
                bHotel.setbPromocion(listarpromocion(bHotel.getIdproducto()));
                list.add(bHotel);
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

    public ArrayList<BHabitacion> listarhabitacion(String id) {

        ArrayList<BHabitacion> list = new ArrayList<BHabitacion>();

        try {

            String sql = "SELECT tipo, precio, descripcion, idhotel FROM habitacion where idhotel='" + id + "';";
            //System.out.println("-----------SQL Habitacion-----" + sql);
            pstmth = connh.prepareStatement(sql);
            rsh = pstmth.executeQuery();

            while (rsh.next()) {
                BHabitacion bHabitacion = new BHabitacion();
                bHabitacion.setTipo(rsh.getString("tipo"));
                bHabitacion.setPrecio(rsh.getDouble("precio"));
                bHabitacion.setDescripcion(rsh.getString("descripcion"));
                bHabitacion.setIdhotel(rsh.getString("idhotel"));

                list.add(bHabitacion);
            }
            pstmth.close();
            rsh.close();

        } catch (SQLException ex) {
            System.out.println("Error en Listar Habitacion " + ex);
        }
        return list;

    }

    public ArrayList<BServiciosAdicional> listarservicio(String id) {

        ArrayList<BServiciosAdicional> list = new ArrayList<BServiciosAdicional>();

        try {

            String sql = "SELECT tipo, descripcion, idproducto  FROM servicion_adicional where idproducto='" + id + "';";
            //System.out.println("-----------SQL Servicio-----" + sql);
            pstmts = conns.prepareStatement(sql);
            rss = pstmts.executeQuery();

            while (rss.next()) {
                BServiciosAdicional bServiciosAdicional = new BServiciosAdicional();

                bServiciosAdicional.setTipo(rss.getString("tipo"));
                bServiciosAdicional.setDescripcion(rss.getString("descripcion"));
                bServiciosAdicional.setIdproducto(rss.getString("idproducto"));
                list.add(bServiciosAdicional);
            }
            pstmts.close();
            rss.close();

        } catch (SQLException ex) {
            System.out.println("Error en Listar Servicio Adicional " + ex);
        }
        return list;

    }

    public ArrayList<BPromocion> listarpromocion(String id) {

        ArrayList<BPromocion> list = new ArrayList<BPromocion>();

        try {

            String sql = "SELECT tipo, descripcion, idproducto FROM promocion where idproducto='" + id + "';";
            //System.out.println("-----------SQL promocion-----" + sql);
            pstmts = conns.prepareStatement(sql);
            rss = pstmts.executeQuery();

            while (rss.next()) {
                BPromocion bPromocion = new BPromocion();

                bPromocion.setTipo(rss.getString("tipo"));
                bPromocion.setDescripcion(rss.getString("descripcion"));
                bPromocion.setIdproducto(rss.getString("idproducto"));
                list.add(bPromocion);
            }
            pstmts.close();
            rss.close();

        } catch (SQLException ex) {
            System.out.println("Error en Listar promocion " + ex);
        }
        return list;

    }
}