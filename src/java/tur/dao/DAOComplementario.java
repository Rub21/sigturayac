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
import tur.bean.BComplementario;
import tur.bean.BGeometry;
import tur.bean.BComplementario;
import tur.bean.BImagen;

/**
 *
 * @author ruben
 */
public class DAOComplementario {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //imagen
    Connection conni = null;
    PreparedStatement pstmti = null;
    ResultSet rsi = null;

    public DAOComplementario(Connection conn) {
        this.conn = conn;
        this.conni = conn;

    }

    public void registrarcomplementario(BComplementario bComplementario) {


        try {
            String sql = "SELECT insert_complementario('" + bComplementario.getIdproducto() + "',"
                    + " '" + bComplementario.getNombre() + "',"
                    + " '" + bComplementario.getClase() + "', "
                    + bComplementario.isEstado() + ", "
                    + "'" + bComplementario.getIdcomplementario()+ "' ,"
                    + "'" + bComplementario.getTipo() + "' ,"
                    + " '" + bComplementario.getDescripcion() + "', "
                    + "'" + bComplementario.getDireccion() + "', "
                    + "'" + bComplementario.getTelefono() + "',"
                    + "'" + bComplementario.getSitio() + "',"
                    + "'" + bComplementario.getHora_aten() + "',"
                    + bComplementario.getGeometry().getLatitud() + ", "
                    + bComplementario.getGeometry().getLongitud() + ");";

            System.out.println(sql);
            String sql_img = "";
            for (int i = 0; i < bComplementario.getImagenes().size(); i++) {
                sql_img += "INSERT INTO imagen(url, titulo, decripcion, idproducto) "
                        + "VALUES ('" + bComplementario.getImagenes().get(i).getUrl()
                        + "','" + bComplementario.getImagenes().get(i).getTitulo()
                        + "','" + bComplementario.getImagenes().get(i).getDescripcion()
                        + "', '" + bComplementario.getImagenes().get(i).getIdproducto() + "');";
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

    public List listarcomplementario() {
        List list = new LinkedList();

        try {

            String sql = "SELECT idproducto, nombre, clase, estado, idcomplementario,tipo, descripcion, direccion, telefono,sitio, hora_aten, lat, lon FROM select_complementario;";
            //System.out.println("--:" + sql);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                BComplementario bComplementario = new BComplementario();
                BGeometry bGeometry = new BGeometry();
                //Producto                
                bComplementario.setIdproducto(rs.getString("idproducto"));
                bComplementario.setNombre(rs.getString("nombre"));
                bComplementario.setClase(rs.getString("clase"));
                bComplementario.setEstado(rs.getBoolean("estado"));
                //Complementario
                bComplementario.setIdcomplementario(rs.getString("idcomplementario"));
                
                bComplementario.setTipo(rs.getString("tipo"));
                bComplementario.setDescripcion(rs.getString("descripcion"));
                bComplementario.setDireccion(rs.getString("direccion"));
                bComplementario.setTelefono(rs.getString("telefono"));
                bComplementario.setSitio(rs.getString("sitio"));
                bComplementario.setHora_aten(rs.getString("hora_aten"));

                //Geometry
                bGeometry.setLatitud(rs.getDouble("lat"));
                bGeometry.setLongitud(rs.getDouble("lon"));
                bGeometry.setIdproducto(rs.getString("idproducto"));
                bGeometry.setCoordinates();
                bComplementario.setGeometry(bGeometry);
                //Imagen
                bComplementario.setImagenes(listarimagen(bComplementario.getIdproducto()));


                list.add(bComplementario);
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
            //System.out.println("-----------SQL IMAGEN-----" + sql);
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
