/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.manager;

import java.sql.Connection;
import java.util.List;
import tur.bean.BHotel;
import tur.bean.BRestaurant;
import tur.dao.DAOHotel;
import tur.dao.DAORestaurant;
import tur.datasource.BDConnecion;

/**
 *
 * @author ruben
 */
public class ManagerRestaurant {

    DAORestaurant dAORestaurant;
    BRestaurant bRestaurant;
    Connection cn = null;

    public ManagerRestaurant(BDConnecion connecion) {

        this.cn = connecion.getConnection();
    }

    public void registrarrestaurant(BRestaurant bRestaurant) {

        dAORestaurant = new DAORestaurant(cn);
        dAORestaurant.registrarrestaurant(bRestaurant);
    }

    public List listarrestaurant() {
        dAORestaurant = new DAORestaurant(cn);
        return dAORestaurant.listarrestaurant();
    }
}
