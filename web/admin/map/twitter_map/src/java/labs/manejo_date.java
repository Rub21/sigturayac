/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labs;

/**
 *
 * @author ruben
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import twitter.utilities.Utilities;

public class manejo_date {

    public static void main(String[] args) throws ParseException {
        String date_s = "Wed, 01 May 2013 01:11:12 +0000";
      
        System.out.println(date_s);

        Utilities u = new Utilities();
        System.out.println(u.get_Date(date_s));
        System.out.println(u.get_hour(date_s));
        
        

    }
}
