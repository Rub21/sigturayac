/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tur.manager;

import java.sql.Connection;
import tur.dao.DAOLogin;
import tur.datasource.BDConnecion;

/**
 *
 * @author ruben
 */
public class ManagerLogin {
        DAOLogin dAOLogin;
 
    Connection cn = null;

    public ManagerLogin(BDConnecion connecion) {
        this.cn = connecion.getConnection();
    }

    public boolean autenticar(String usuario, String password) {
      dAOLogin = new DAOLogin(cn);
       return  dAOLogin.autenticar(usuario,password);
    }
}
