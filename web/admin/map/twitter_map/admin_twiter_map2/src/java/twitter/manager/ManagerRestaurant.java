/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.manager;

import java.sql.Connection;
import java.util.List;
import twitter.bean.BHotel;
import twitter.bean.BRestaurant;
import twitter.dao.DAOHotel;
import twitter.dao.DAORestaurant;
import twitter.datasource.BDConnecion;

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
