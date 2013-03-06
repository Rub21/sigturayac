/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.manager;

import java.sql.Connection;
import tur.bean.BProducto;
import tur.dao.DAOProducto;
import tur.datasource.BDConnecion;

/**
 *
 * @author ruben
 */
public class ManagerProducto {

    DAOProducto dAOProducto; 
    BProducto bProducto;
    Connection cn = null;

    public ManagerProducto(BDConnecion connecion) {
        this.cn = connecion.getConnection();
    }

    public int getlast() {
        dAOProducto= new DAOProducto(cn);  
        return dAOProducto.getlast();
    }

 
    
   

}
