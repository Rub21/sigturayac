/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.manager;

import java.sql.Connection;
import java.util.List;
import tur.bean.BRestaurant;
import tur.bean.BTransporte;
import tur.dao.DAORestaurant;
import tur.dao.DAOTransporte;
import tur.datasource.BDConnecion;

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
