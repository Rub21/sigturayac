/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.manager;

import java.sql.Connection;
import java.util.List;
import twitter.bean.BHotel;
import twitter.dao.DAOHotel;
import twitter.datasource.BDConnecion;

/**
 *
 * @author ruben
 */
public class ManagerHotel {

    DAOHotel dAOHotel;
    BHotel bHotel;
    Connection cn = null;

    public ManagerHotel(BDConnecion connecion) {

        this.cn = connecion.getConnection();
    }

    public void registrarHotel(BHotel bHotel) {

        dAOHotel = new DAOHotel(cn);
        dAOHotel.registrarhotel(bHotel);
    }

    public List listarhotel() {
        dAOHotel = new DAOHotel(cn);
        return dAOHotel.listarhotel();
    }
}
