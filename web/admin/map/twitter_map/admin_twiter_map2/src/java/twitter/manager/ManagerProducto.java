/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.manager;

import java.sql.Connection;
import java.util.List;
import twitter.bean.BProducto;
import twitter.dao.DAOProducto;
import twitter.datasource.BDConnecion;

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
        dAOProducto = new DAOProducto(cn);
        return dAOProducto.getlast();
    }

    public List listarproducto() {
        dAOProducto = new DAOProducto(cn);
        return dAOProducto.listarproducto();
    }
}
