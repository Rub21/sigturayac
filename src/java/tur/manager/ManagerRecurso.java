
package tur.manager;

import java.sql.Connection;
import java.util.List;
import tur.bean.BRecurso;
import tur.dao.DAORecurso;
import tur.datasource.BDConnecion;

/**
 *
 * @author ruben
 */
public class ManagerRecurso {

    DAORecurso dAORecurso;
    BRecurso bRecurso;
    Connection cn = null;

    public ManagerRecurso(BDConnecion connecion) {

        this.cn = connecion.getConnection();
    }

    public void registrarrecurso(BRecurso bRecurso) {
        dAORecurso = new DAORecurso(cn);
        dAORecurso.registrarrecurso(bRecurso);
    }

    public List listarrecurso() {
         dAORecurso = new DAORecurso(cn);
        return dAORecurso.listarrecurso();
    }

    /*public int getlast() {
       dAORecurso = new DAORecurso(cn);
        return dAORecurso.getlast();
    }*/
}
