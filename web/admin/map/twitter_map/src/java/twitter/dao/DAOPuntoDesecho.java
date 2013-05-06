/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter.bean.BEstadistica;
import twitter.bean.BGeometry;
import twitter.bean.BPuntoDesecho;
import twitter.bean.BTwitter;

/**
 *
 * @author ruben
 */
public class DAOPuntoDesecho {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public DAOPuntoDesecho(Connection conn) {
        this.conn = conn;
    }

    public List<BPuntoDesecho> getids_twitter() {

        List<BPuntoDesecho> list = new LinkedList<BPuntoDesecho>();
        try {
            String sql = "select idpunto from select_punto where tipo='t';";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BPuntoDesecho bPuntoDesecho = new BPuntoDesecho();
                bPuntoDesecho.setIdpunto(rs.getString("idpunto"));
                list.add(bPuntoDesecho);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return list;
    }

    public String registrar(BPuntoDesecho bPuntoDesecho) {

        String resultado = null;
        try {

            String sql = "select insert_punto("
                    + "'" + bPuntoDesecho.getIdpunto() + "',"
                    + "'" + bPuntoDesecho.getUsuario() + "',"
                    + "'" + bPuntoDesecho.getNombre() + "',"
                    + "'" + bPuntoDesecho.getFecha() + "',"
                    + "'" + bPuntoDesecho.getHora() + "',"
                    + "'" + bPuntoDesecho.getUrl_img() + "',"
                    + "' " + bPuntoDesecho.getPerfil_img() + "',"
                    + " '" + bPuntoDesecho.getDescripcion() + "',"
                    + "'" + bPuntoDesecho.getTipo() + "',"
                    + bPuntoDesecho.getEstado() + ","
                    + bPuntoDesecho.getGeometry().getLatitud() + ","
                    + bPuntoDesecho.getGeometry().getLongitud() + ");";
            System.out.println("SQL" + sql);
            pstmt = conn.prepareStatement(sql);
            //pstmt.executeUpdate();
            pstmt.executeQuery();
            // conn.commit();
            resultado = "Registro Exitoso";
        } catch (SQLException ex) {
            Logger.getLogger(DAOPuntoDesecho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    public List listarpuntospendientes() {


        List list = new LinkedList();
        try {
            String sql = "select idpunto, usuario, nombre, fecha, hora, url_img, perfil_img, descripcion, tipo, estado ,fecharegistro,lat, lon from select_punto where estado=true;";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                BPuntoDesecho bPuntoDesecho = new BPuntoDesecho();

                bPuntoDesecho.setIdpunto(rs.getString("idpunto"));
                bPuntoDesecho.setUsuario(rs.getString("usuario"));
                bPuntoDesecho.setNombre(rs.getString("nombre"));
                bPuntoDesecho.setFecha(rs.getString("fecha"));
                bPuntoDesecho.setHora(rs.getString("hora"));
                bPuntoDesecho.setUrl_img(rs.getString("url_img"));
                bPuntoDesecho.setPerfil_img(rs.getString("perfil_img"));
                bPuntoDesecho.setDescripcion(rs.getString("descripcion"));
                bPuntoDesecho.setTipo(rs.getString("tipo"));
                bPuntoDesecho.setEstado(rs.getBoolean("estado"));


                BGeometry bGeometry = new BGeometry();
                bGeometry.setLatitud(rs.getDouble("lat"));
                bGeometry.setLongitud(rs.getDouble("lon"));
                bGeometry.setCoordinates();
                bPuntoDesecho.setGeometry(bGeometry);
                list.add(bPuntoDesecho);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return list;
    }

    public List listardate() {
        // System.out.println("ingreso aquir");
        List list = new LinkedList();
        try {

            for (int i = 1; i <= 12; i++) {
                List list_day = new LinkedList();
                String m = "";
                if (i < 9) {
                    m = "0" + i;
                } else {
                    m = i + "";
                }
                String sql = "select substring(fecha,1,2) as day   FROM punto_desecho where substring(fecha,4,2)='" + m + "' GROUP BY day ORDER BY day DESC;";
                System.out.println(sql);
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();

                int contador = 0;
                System.out.println("---contador" + contador);
                while (rs.next()) {
                    list_day.add(Integer.parseInt(rs.getString("day")));
                    contador++;
                    System.out.println("---contador" + contador);
                }
                list.add(list_day);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return list;

    }

    public void actualizar_punto(String id_punto) {

        try {

            String sql = "UPDATE punto_desecho SET estado=false WHERE idpunto='" + id_punto + "';";
            System.out.println("SQL" + sql);
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            // pstmt.executeQuery();
            // conn.commit();
        } catch (SQLException ex) {
        }
    }

    public List listarestadisticas() {
        List list = new LinkedList();
        try {
            String sql = "SELECT fecha,p_pen, p_ate FROM select_stadistic;";
            System.out.println(sql);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BEstadistica bEstadistica = new BEstadistica();
                bEstadistica.setFecha(rs.getString("fecha"));
                bEstadistica.setP_pen(rs.getInt("p_pen"));
                bEstadistica.setP_ate(rs.getInt("p_ate"));
                list.add(bEstadistica);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return list;

    }

    public List listarpuntos() {
        
    
        List list = new LinkedList();
        try {
            String sql = "select idpunto, usuario, nombre, fecha, hora, url_img, perfil_img, descripcion, tipo, estado ,fecharegistro,lat, lon from select_punto";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                BPuntoDesecho bPuntoDesecho = new BPuntoDesecho();

                bPuntoDesecho.setIdpunto(rs.getString("idpunto"));
                bPuntoDesecho.setUsuario(rs.getString("usuario"));
                bPuntoDesecho.setNombre(rs.getString("nombre"));
                bPuntoDesecho.setFecha(rs.getString("fecha"));
                bPuntoDesecho.setHora(rs.getString("hora"));
                bPuntoDesecho.setUrl_img(rs.getString("url_img"));
                bPuntoDesecho.setPerfil_img(rs.getString("perfil_img"));
                bPuntoDesecho.setDescripcion(rs.getString("descripcion"));
                bPuntoDesecho.setTipo(rs.getString("tipo"));
                bPuntoDesecho.setEstado(rs.getBoolean("estado"));


                BGeometry bGeometry = new BGeometry();
                bGeometry.setLatitud(rs.getDouble("lat"));
                bGeometry.setLongitud(rs.getDouble("lon"));
                bGeometry.setCoordinates();
                bPuntoDesecho.setGeometry(bGeometry);
                list.add(bPuntoDesecho);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error : " + ex);
        }
        return list;
    
    
    }
}
