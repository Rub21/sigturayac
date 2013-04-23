/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.manager;

import java.sql.Connection;
import twitter.dao.DAOLogin;
import twitter.datasource.BDConnecion;

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
