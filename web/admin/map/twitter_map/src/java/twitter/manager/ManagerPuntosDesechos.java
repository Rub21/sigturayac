/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.manager;

import java.sql.Connection;
import java.util.List;
import twitter.bean.BPuntoDesecho;
import twitter.dao.DAOPuntoDesecho;
import twitter.datasource.BDConnecion;

/**
 *
 * @author ruben
 */
public class ManagerPuntosDesechos {

    DAOPuntoDesecho dAOPuntoDesecho;
    Connection cn = null;

    public ManagerPuntosDesechos(BDConnecion connecion) {
        this.cn = connecion.getConnection();
    }

    public List<BPuntoDesecho> getids_twitter() {
        dAOPuntoDesecho = new DAOPuntoDesecho(cn);
        return dAOPuntoDesecho.getids_twitter();
    }

    public String registrar(BPuntoDesecho b) {
        dAOPuntoDesecho = new DAOPuntoDesecho(cn);
        return dAOPuntoDesecho.registrar(b);

    }

    public List listarpuntospendientes() {
        dAOPuntoDesecho = new DAOPuntoDesecho(cn);
        return dAOPuntoDesecho.listarpuntospendientes();
    }

    public List listardate() {
        dAOPuntoDesecho = new DAOPuntoDesecho(cn);
        return dAOPuntoDesecho.listardate();
    }

    public void actualizar_punto(String id_punto) {
        dAOPuntoDesecho = new DAOPuntoDesecho(cn);
        dAOPuntoDesecho.actualizar_punto(id_punto);

    }

    public List listarestadisticas() {
        dAOPuntoDesecho = new DAOPuntoDesecho(cn);
        return dAOPuntoDesecho.listarestadisticas();

    }

    public List listarpuntos() {
       dAOPuntoDesecho = new DAOPuntoDesecho(cn);
        return dAOPuntoDesecho.listarpuntos();  
    }
}
