/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import tur.bean.BGeometry;
import tur.bean.BHotel;

/**
 *
 * @author ruben
 */
public class DAOLogin {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public DAOLogin(Connection conn) {
        this.conn = conn;

    }

    public boolean autenticar(String usuario, String password) {
       
  boolean banndera=false;

        try {

            String sql = "SELECT contrasenia FROM login where usuario='"+usuario+"';";
           
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                
                String contrasenia=rs.getString("contrasenia");
                if(contrasenia.equals(password))
                {banndera=true;
                }
                
            }

            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error en en User: " + ex);
        }
        return banndera;
    }
}
