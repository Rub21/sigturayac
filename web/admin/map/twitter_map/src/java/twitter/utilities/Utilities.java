/*
 * To change this template, choose Tools | Templates
 * anm open the template in the emitor.
 */
package twitter.utilities;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ruben
 */
public class Utilities {

    public String get_Date(String date) {
        //01 May 2013 
        //"Wed, 01 May 2013 01:11:12 +0000";

        String m = date.substring(8, 11);
        String d = date.substring(5, 7);
        String y = date.substring(12, 16);
        String month = "";
        if (m.equals("Jan")) {
            month = "01";

        } else if (m.equals("Feb")) {
            month = "02";

        } else if (m.equals("Mar")) {
            month = "03";

        } else if (m.equals("Apr")) {
            month = "04";

        } else if (m.equals("May")) {
            month = "05";

        } else if (m.equals("Jun")) {
            month = "06";

        } else if (m.equals("Jul")) {
            month = "07";

        } else if (m.equals("Aug")) {
            month = "08";

        } else if (m.equals("Sep")) {
            month = "09";

        } else if (m.equals("Oct")) {
            month = "10";

        } else if (m.equals("Nov")) {
            month = "11";

        } else if (m.equals("Dec")) {
            month = "12";

        }

        return d + "/" + month + "/" + y;

    }

    public String get_hour(String hour) {

        //"Wed, 01 May 2013 01:11:12 +0000";
        //return hour.substring(17, 25);

        int hours = Integer.parseInt(hour.substring(17, 19));
        int minutes = Integer.parseInt(hour.substring(20, 22));
        String minutes_string = minutes + "";
        String suffix = "AM";

        if (hours >= 12) {
            suffix = "PM";
            hours = hours - 12;
        }
        if (hours == 0) {
            hours = 12;
        }
        if (minutes < 10) {
            minutes_string = "0" + minutes;
        }

        return hours + ":" + minutes_string + " " + suffix;
    }    
}
