/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ruben
 */
public class DAOProducto {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public DAOProducto(Connection conn) {
        this.conn = conn;
    }

    public int getlast() {
        int num = 0;
        try {
            String sql = "select count(*) as num from producto;";

            System.out.println("==========SQL producto= : "+sql);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();


            while (rs.next()) {
                num = rs.getInt("num");
            }

            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error en optener posicion de producto : " + ex);
        }
        return num + 1;
    }
}
