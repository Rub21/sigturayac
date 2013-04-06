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
import tur.bean.BDestino;
import tur.bean.BGeometry;
import tur.bean.BImagen;
import tur.bean.BTransporte;
import tur.bean.BTransporte;
import tur.bean.BTransporte;

/**
 *
 * @author ruben
 */
public class DAOTransporte {
    
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    //imagen
    Connection conni = null;
    PreparedStatement pstmti = null;
    ResultSet rsi = null;
    //destino
    Connection connd = null;
    PreparedStatement pstmtd = null;
    ResultSet rsd = null;
    
    public DAOTransporte(Connection conn) {
        this.conn = conn;
        this.conni = conn;
        this.connd = conn;
        
    }
    
    public void registrartransporte(BTransporte bTransporte) {

//SELECT insert_transporte('16p', 'Cruz del sur', 'Transporte', true, '16pre' , 'muy caros', 'Jr Mariscal Caceres', '310225','www..w.w.','de lunes a viernes',-74.265, -12.9845)

        try {
            String sql = "SELECT insert_transporte('" + bTransporte.getIdproducto() + "',"
                    + " '" + bTransporte.getNombre() + "',"
                    + " '" + bTransporte.getClase() + "', "
                    + bTransporte.isEstado() + ", "
                    + "'" + bTransporte.getIdtransporte() + "' ,"
                    + " '" + bTransporte.getDescripcion() + "', "
                    + "'" + bTransporte.getDireccion() + "', "
                    + "'" + bTransporte.getTelefono() + "',"
                    + "'" + bTransporte.getSitio() + "',"
                    + "'" + bTransporte.getHora_aten() + "',"
                    + bTransporte.getGeometry().getLatitud() + ", "
                    + bTransporte.getGeometry().getLongitud() + ");";

            //System.out.println(sql);
            String sql_dest = "";
            for (int i = 0; i < bTransporte.getDestinos().size(); i++) {
                sql_dest += "INSERT INTO destino( nombre, idtransporte) VALUES ('" + bTransporte.getDestinos().get(i).getNombre() + "', '" + bTransporte.getDestinos().get(i).getIdtransporte() + "');";
            }
            System.out.println(sql);
            String sql_img = "";
            for (int i = 0; i < bTransporte.getImagenes().size(); i++) {
                sql_img += "INSERT INTO imagen(url, titulo, decripcion, idproducto) "
                        + "VALUES ('" + bTransporte.getImagenes().get(i).getUrl()
                        + "','" + bTransporte.getImagenes().get(i).getTitulo()
                        + "','" + bTransporte.getImagenes().get(i).getDescripcion()
                        + "', '" + bTransporte.getImagenes().get(i).getIdproducto() + "');";
            }
            sql = sql + sql_img + sql_dest;
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
    
    public List listarTransporte() {
        
        List list = new LinkedList();
        
        try {
            
            String sql = "SELECT idproducto, nombre, clase, estado, idtransporte, descripcion, direccion, telefono,sitio, hora_aten, lat, lon FROM select_transporte;";
            //System.out.println("--:" + sql);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                
                BTransporte bTransporte = new BTransporte();
                BGeometry bGeometry = new BGeometry();
                //Producto                
                bTransporte.setIdproducto(rs.getString("idproducto"));
                bTransporte.setNombre(rs.getString("nombre"));
                bTransporte.setClase(rs.getString("clase"));
                bTransporte.setEstado(rs.getBoolean("estado"));
                //Transporte
                bTransporte.setIdtransporte(rs.getString("idtransporte"));
                bTransporte.setDescripcion(rs.getString("descripcion"));
                bTransporte.setDireccion(rs.getString("direccion"));
                bTransporte.setTelefono(rs.getString("telefono"));
                bTransporte.setSitio(rs.getString("sitio"));
                bTransporte.setHora_aten(rs.getString("hora_aten"));

                //Geometry
                bGeometry.setLatitud(rs.getDouble("lat"));
                bGeometry.setLongitud(rs.getDouble("lon"));
                bGeometry.setIdproducto(rs.getString("idproducto"));
                bGeometry.setCoordinates();
                bTransporte.setGeometry(bGeometry);
                //Imagen
                bTransporte.setImagenes(listarimagen(bTransporte.getIdproducto()));
                //destion
                bTransporte.setDestinos(listardestinos(bTransporte.getIdtransporte()));
                
                list.add(bTransporte);
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
    
    public ArrayList<BDestino> listardestinos(String id) {
        
        ArrayList<BDestino> list = new ArrayList<BDestino>();
        try {
            String sql = "SELECT nombre, idtransporte  FROM destino where idtransporte='" + id + "'";
            System.out.println("--------------destino" + sql);            
            pstmtd = connd.prepareStatement(sql);
            rsd = pstmtd.executeQuery();
            while (rsd.next()) {
                BDestino bDestino = new BDestino();
                bDestino.setNombre(rsd.getString("nombre"));
                bDestino.setIdtransporte(rsd.getString("idtransporte"));
                list.add(bDestino);
            }
            pstmtd.close();
            rsd.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en Listar Destino: " + ex);
        }
        return list;
        
    }
}
