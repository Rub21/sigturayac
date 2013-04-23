/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.manager;

import java.sql.Connection;
import java.util.List;
import twitter.bean.BRestaurant;
import twitter.bean.BTransporte;
import twitter.dao.DAORestaurant;
import twitter.dao.DAOTransporte;
import twitter.datasource.BDConnecion;

/**
 *
 * @author ruben
 */
public class ManagerTransporte {

    DAOTransporte dAOTransporte;
    BTransporte bTransporte;
    Connection cn = null;

    public ManagerTransporte(BDConnecion connecion) {

        this.cn = connecion.getConnection();
    }

    public void registrartransporte(BTransporte bTransporte) {
        dAOTransporte = new DAOTransporte(cn);
        dAOTransporte.registrartransporte(bTransporte);
    }

    public List listarTransporte() {
        dAOTransporte = new DAOTransporte(cn);
        return dAOTransporte.listarTransporte();
    }
}
