/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.manager;

import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;
import twitter.bean.BPuntoDesecho;
import twitter.bean.BTwitter;
import twitter.datasource.BDConnecion;
import twitter.utilities.Tweets;

/**
 *
 * @author ruben
 */
public class Processingtweets extends TimerTask {

    ManagerPuntosDesechos managerPuntosDesechos = null;

    public void run() {
        BDConnecion conexion = new BDConnecion();
        managerPuntosDesechos = new ManagerPuntosDesechos(conexion);
        List<BPuntoDesecho> list = new LinkedList<BPuntoDesecho>();
        list = managerPuntosDesechos.getids_twitter();//from datat base

        System.out.println("size in data base : "+ list.size());
        Tweets tweets = new Tweets();//cals fro get data twitter
        list = tweets.get_tweets(list);
        System.out.println("Lista de twettes que se registraron : "+list.size());
        for (int i = 0; i < list.size(); i++) {
            String resultado = managerPuntosDesechos.registrar((BPuntoDesecho) list.get(i));
            System.out.println(list.get(i));
        }



    }
}
