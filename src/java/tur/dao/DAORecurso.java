package tur.dao;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tur.bean.BDetalle;
import tur.bean.BGeometry;
import tur.bean.BImagen;
import tur.bean.BRecurso;
import tur.datasource.BDConnecion;
import tur.utilities.Utilities;

/**
 *
 * @author ruben
 */
public class DAORecurso {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Connection conni = null;
    PreparedStatement pstmti = null;
    ResultSet rsi = null;
    /*Connection conng = null;
    PreparedStatement pstmtg = null;
    ResultSet rsg = null;*/
    Utilities util = new Utilities();

    public DAORecurso(Connection conn) {
        this.conn = conn;
        this.conni = conn;
       // this.conng = conn;
    }

    public void registrarrecurso(BRecurso bRecurso) {
        try {
            String sql = "SELECT insert_recurso('" + bRecurso.getIdproducto() + "',"
                    + "'" + bRecurso.getNombre() + "',"
                    + "'" + bRecurso.getClase() + "',"
                    + bRecurso.isEstado() + ","
                    + "'" + bRecurso.getIdrecurso() + "',"
                    + "'" + bRecurso.getCategoria() + "',"
                    + "'" + bRecurso.getTipo() + "',"
                    + "'" + bRecurso.getDescripcion() + "',"
                    + "'" + bRecurso.getCorredor() + "',"
                    + bRecurso.getGeometry().getLatitud() + ","
                    + bRecurso.getGeometry().getLongitud() + ","
                    + "'" + bRecurso.getDetalle().getDistancia() + "',"
                    + "'" + bRecurso.getDetalle().getCosto_ingreso() + "',"
                    + "'" + bRecurso.getDetalle().getHora_atencion() + "',"
                    + "'" + bRecurso.getDetalle().getTemperatura() + "',"
                    + "'" + bRecurso.getDetalle().getComo_llegar() + "'"                    
                    + ");";
            
        
            String sql_img = "";
            for (int i = 0; i < bRecurso.getImagenes().size(); i++) {

                sql_img += "INSERT INTO imagen(url, titulo, decripcion, idproducto) "
                        + "VALUES ('" + bRecurso.getImagenes().get(i).getUrl()
                        + "','" + bRecurso.getImagenes().get(i).getTitulo()
                        + "','" + bRecurso.getImagenes().get(i).getDescripcion()
                        + "', '" + bRecurso.getImagenes().get(i).getIdproducto() + "');";
            }


            sql = sql + sql_img;
            System.out.println("SQL" + sql);
            pstmt = conn.prepareStatement(sql);
            //pstmt.executeUpdate();
            pstmt.executeQuery();
            //conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DAORecurso.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public List listarrecurso() {
        List list = new LinkedList();

        try {

            String sql = "SELECT idproducto, nombre, clase, estado,idrecurso, categoria, tipo, descripcion,corredor,lat, lon ,distancia, costo_ingreso, hora_atencion, temperatura, como_llegar FROM select_recurso;";
            //System.out.println("--:" + sql);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BRecurso bRecurso = new BRecurso();
                BGeometry bGeometry = new BGeometry();
                BDetalle bDetalle=new BDetalle();

                //Producto                
                bRecurso.setIdproducto(rs.getString("idproducto"));
                bRecurso.setNombre(rs.getString("nombre"));
                bRecurso.setClase(rs.getString("clase"));
                bRecurso.setEstado(rs.getBoolean("estado"));

                //Recurso
                bRecurso.setIdrecurso(rs.getString("idrecurso"));
                bRecurso.setCategoria(rs.getString("categoria"));
                bRecurso.setTipo(rs.getString("tipo"));
                bRecurso.setDescripcion(rs.getString("descripcion"));
                bRecurso.setCorredor(rs.getString("corredor"));

                //Geometry
                bGeometry.setLatitud(rs.getDouble("lat"));
                bGeometry.setLongitud(rs.getDouble("lon"));
                bGeometry.setIdproducto(rs.getString("idproducto"));  
                bGeometry.setCoordinates();
                bRecurso.setGeometry(bGeometry);
                
                //Detalle
                bDetalle.setDistancia(rs.getString("distancia"));
                bDetalle.setCosto_ingreso(rs.getString("costo_ingreso"));
                bDetalle.setHora_atencion(rs.getString("hora_atencion"));
                bDetalle.setTemperatura(rs.getString("temperatura"));
                bDetalle.setComo_llegar(rs.getString("como_llegar"));
                bDetalle.setIdrecurso(rs.getString("idrecurso"));
                bRecurso.setDetalle(bDetalle);
                
                //Imagen
                bRecurso.setImagenes(listarimagen(bRecurso.getIdproducto()));          
                list.add(bRecurso);
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

            String sql = "SELECT url, titulo, decripcion, idproducto  FROM imagen where idproducto='"+id+"';";
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

   /* public int getlast() {
        int num = 0;
        try {
            String sql = "select count(*) as num from producto;";

            System.out.println(sql);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();


            while (rs.next()) {
                num = rs.getInt("num");
            }

            pstmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error en optener posisicon de producto : " + ex);
        }
        return num + 1;
    }*/
}
