/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.manager;

import java.util.Calendar;
import java.util.Timer;

/**
 *
 * @author ruben
 */
public class Scheduler {

    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        //Setting the date from when you want to activate scheduling  
        date.set(2012, 4, 24, 18, 00);
        //execute every 3 seconds       
        timer.schedule(new Processingtweets(), date.getTime(), 5000);
    }
}
