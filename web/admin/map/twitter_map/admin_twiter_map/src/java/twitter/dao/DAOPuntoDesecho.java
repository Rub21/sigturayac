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

        String resultado= null;
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
            conn.commit();
            resultado ="Registro Exitoso";
        } catch (SQLException ex) {
            Logger.getLogger(DAOPuntoDesecho.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  resultado;
    }
}
