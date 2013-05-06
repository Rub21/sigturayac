/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labs;

/**
 *
 * @author ruben
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter.bean.BGeometry;

public class CrunchifyJSON {

    public static void main(String[] args) {
        String jsonString = callURL("http://search.twitter.com/search.json?q=%23aquid&include_entities=1&&geocode=-13.16074,-74.22563,0.5mi");
        //System.out.println("\n\njsonString: " + jsonString);

        //quitar el primero 
        String word = "\"results\":";
        //System.out.println(jsonString.indexOf(word));
        int first_position = jsonString.indexOf(word) + 10;
        jsonString = jsonString.substring(first_position);
        //System.out.println(jsonString);

        //quitar la ultima parte
        // prints "4"
        String last_word = "results_per_page";
        //System.out.println(jsonString.indexOf(word)); 
        int last_position = jsonString.indexOf(last_word);
        jsonString = jsonString.substring(0, last_position);
        //System.out.println("------------------");
        // System.out.println(jsonString);
        /*try {
         JSONArray jsonArray = new JSONArray(jsonString);

         int count = jsonArray.length(); // get totalCount of all jsonObjects
         for (int i = 0; i < count; i++) {   // iterate through jsonArray 
         JSONObject jsonObject = jsonArray.getJSONObject(i);  // get jsonObject @ i position 
         System.out.println("jsonObject " + i + ": " + jsonObject);
         }
         } catch (JSONException e) {
         e.printStackTrace();
         }*/

        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            JSONObject jsonObj = new JSONObject();  // these 4 files add jsonObject to jsonArray
            /*jsonObj.put("color", "CrunchifyColor1");
             jsonObj.put("value", "#111");*/
            jsonArray.put(jsonObj);

            int count = jsonArray.length(); // get totalCount of all jsonObjects
            for (int i = 0; i < count - 1; i++) {   // iterate through jsonArray 
                JSONObject jsonObject = jsonArray.getJSONObject(i);  // get jsonObject @ i position 
                /*System.out.println("jsonObject " + i);
                 System.out.println("id: " + jsonObject.get("id"));
                 System.out.println("Text " + jsonObject.get("text"));
                 System.out.println("created_at " + jsonObject.get("created_at"));
                 System.out.println("media_url " + get_media_url(jsonObject + ""));
                 System.out.println("from_user " + jsonObject.get("from_user"));
                 System.out.println("from_user_id " + jsonObject.get("from_user_id"));
                 System.out.println("from_user_name " + jsonObject.get("from_user_name"));
                 System.out.println("profile_image_url " + jsonObject.get("profile_image_url"));*/
                System.out.println("" + get_geo(jsonObject + ""));
                System.out.println("******************************************");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String get_media_url(String json) {
        /*{"text":"#aquid alameda http://t.co/vowx23eMSp","from_user_id":713303390,"from_user_name":"EDITH YESENIA Q.P.",
         "geo":{"type":"Point","coordinates":[-13.16728063,-74.22774986]},
         "profile_image_url_https":"https://si0.twimg.com/profile_images/2426796802/8hevn3ed4dpqx6l8pkh0_normal.jpeg",
         "iso_language_code":"es","entities":{"urls":[],"hashtags":[{"text":"aquid","indices":[0,6]}],
         "media":[{"sizes":{"orig":{"w":2560,"resize":"fit","h":1920},"small":{"w":340,"resize":"fit","h":255},
         "thumb":{"w":150,"resize":"crop","h":150},"large":{"w":1024,"resize":"fit","h":768},"medium":{"w":600,"resize":"fit","h":450}},
         "id":324935334209126401,"media_url_https":"https://pbs.twimg.com/media/BIJm9wKCAAEXy5F.jpg",
         "media_url":"http://pbs.twimg.com/media/BIJm9wKCAAEXy5F.jpg","expanded_url":
         "http://twitter.com/ediqp8/status/324935334204932096/photo/1",
         "indices":[15,37],"id_str":"324935334209126401","type":"photo","display_url":
         "pic.twitter.com/vowx23eMSp","url":"http://t.co/vowx23eMSp"}],"user_mentions":[]},
         "id":324935334204932096,"source":"&lt;a href=&quot;http://twitter.com/download/android&quot;&gt;Twitter for Android&lt;/a&gt;","from_user_id_str":"713303390",
         "from_user":"ediqp8","created_at":"Thu, 18 Apr 2013 17:19:55 +0000","id_str":"324935334204932096","profile_image_url":
         * "http://a0.twimg.com/profile_images/2426796802/8hevn3ed4dpqx6l8pkh0_normal.jpeg","metadata":{"result_type":"recent"}}*/

        String first_word = "http://pbs.twimg.com/";
        //System.out.println(jsonString.indexOf(word));
        int first_position = json.lastIndexOf(first_word);
        //System.out.println(first_position);
        json = json.substring(first_position);
        //System.out.println("-------" + json);
        String second_word = "\",\"expanded_url\":";
        int second_position = json.lastIndexOf(second_word);
        //System.out.println(second_position);
        json = json.substring(0, second_position);
        //System.out.println(json);
        return json;
    }

    public static BGeometry get_geo(String json) {
        //"geo":{"type":"Point","coordinates":[-13.16728063,-74.22774986]},
        //"profile_image_url_https":"https://si0.twimg.com/profile_images/2426796802/8hevn3ed4dpqx6l8pkh0_normal.jpeg",

        BGeometry bGeometry = new BGeometry();
        String second_word = "]},\"profile_image_url_https\":";
        int second_position = json.lastIndexOf(second_word);
        //System.out.println(second_position);
        json = json.substring(0, second_position);
        //System.out.println(json);

        if (json.contains("\"type\":\"Point\"")) {

            bGeometry.setType("Point");

            //vedifica primeros Caracteres
            String first_word = "\"type\":\"Point\",\"coordinates\":[";
            //System.out.println(jsonString.indexOf(word));
            int first_position = json.indexOf(first_word);
            //System.out.println(first_position);
            json = json.substring(first_position);



            //sacar el tamaño de este String para obtener cordenadas 
            int string_lengt = "\"type\":\"Point\",\"coordinates\":[".length();

            json = json.substring(string_lengt);

            String lat = json.substring(0, json.indexOf(","));
            //System.out.println("Lat" + lat);
            String lon = json.substring(json.indexOf(","));
            lon = lon.substring(1);
            double[] conIsrdinates = {Double.parseDouble(lat), Double.parseDouble(lon)};

            //bGeometry.setCoordinates(conIsrdinates);


        }

        return bGeometry;
    }

    public static String callURL(String myURL) {
        System.out.println("Requested URL:" + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);
            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + myURL, e);
        }

        return sb.toString();
    }
}