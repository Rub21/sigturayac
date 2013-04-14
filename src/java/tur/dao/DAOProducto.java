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
import tur.bean.BComplementario;
import tur.bean.BGeometry;
import tur.bean.BProducto;
import tur.bean.BTransporte;

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

            System.out.println("==========SQL producto= : " + sql);
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

    public List listarproducto() {
        List list = new LinkedList();
        try {

            String sql = "select idproducto, nombre, clase,estado from producto;";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BProducto bProducto = new BProducto();

                //Producto                
                bProducto.setIdproducto(rs.getString("idproducto"));
                bProducto.setNombre(rs.getString("nombre"));
                bProducto.setClase(rs.getString("clase"));
                bProducto.setEstado(rs.getBoolean("estado"));
                list.add(bProducto);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error en Listar Producto: " + ex);
        }
        return list;
    }
}
