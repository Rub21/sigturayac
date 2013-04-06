/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.manager;

import java.sql.Connection;
import java.util.List;
import tur.bean.BComplementario;
import tur.dao.DAOComplementario;
import tur.datasource.BDConnecion;

/**
 *
 * @author ruben
 */
public class ManagerComplementario {

    DAOComplementario dAOComplementario;  
    Connection cn = null;

    public ManagerComplementario(BDConnecion connecion) {

        this.cn = connecion.getConnection();
    }

    public void registrartransporte(BComplementario bComplementario) {
        dAOComplementario = new DAOComplementario(cn);
        dAOComplementario.registrarcomplementario(bComplementario);
    }

    public List listarcomplementario() {
        dAOComplementario = new DAOComplementario(cn);
        return dAOComplementario.listarcomplementario();
    }
}
