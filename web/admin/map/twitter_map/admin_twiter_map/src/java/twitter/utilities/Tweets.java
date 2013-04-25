/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import static labs.CrunchifyJSON.callURL;
import static labs.CrunchifyJSON.get_geo;
import twitter.bean.BGeometry;
import twitter.bean.BPuntoDesecho;

/**
 *
 * @author ruben
 */
public class Tweets {

    public List<BPuntoDesecho> get_tweets(List<BPuntoDesecho> list_in_db) { //list_in_db= listado de tweets en la base de datos

        List<BPuntoDesecho> list = new LinkedList<BPuntoDesecho>();
        String jsonString = callURL("http://search.twitter.com/search.json?q=%23aquid&include_entities=1&&geocode=-13.16074,-74.22563,0.5mi");
        //System.out.println("\n\njsonString: " + jsonString);
        //quitar el primero 
        String word = "\"results\":";
        //System.out.println(jsonString.indexOf(word));
        int first_position = jsonString.indexOf(word) + 10;
        jsonString = jsonString.substring(first_position);
        //System.out.println(jsonString);

        //quitar la ultima parte
        String last_word = "results_per_page";
        //System.out.println(jsonString.indexOf(word)); 
        int last_position = jsonString.indexOf(last_word);
        jsonString = jsonString.substring(0, last_position);
        // System.out.println(jsonString);

        try {

            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObj = new JSONObject();
            jsonArray.put(jsonObj);

            for (int i = 0; i < jsonArray.length() - 1; i++) {   // iterate through jsonArray 
                JSONObject jsonObject = jsonArray.getJSONObject(i);


                for (int j = 0; j < list_in_db.size(); j++) {
                    BPuntoDesecho bp = new BPuntoDesecho();
                    bp.setIdpunto(jsonObject.get("id") + "t");
                    System.out.println("de Twiter "+ bp.getIdpunto());
                    System.out.println("de DB "+list_in_db.get(j).getIdpunto());
                    if ((list_in_db.get(j).getIdpunto()+"").equals(bp.getIdpunto()+"")) {
                        BPuntoDesecho bPuntoDesecho = new BPuntoDesecho();
                        bPuntoDesecho.setIdpunto(jsonObject.get("id") + "t");
                        bPuntoDesecho.setDescripcion(jsonObject.get("text") + "");
                        bPuntoDesecho.setFecha(jsonObject.get("created_at") + "");
                        bPuntoDesecho.setUrl_img(get_media_url(jsonObject + ""));
                        bPuntoDesecho.setUsuario(jsonObject.get("from_user") + "");
                        bPuntoDesecho.setNombre(jsonObject.get("from_user_id") + "");
                        //bPuntoDesecho.setFrom_user_name((String) jsonObject.get("from_user_name"));
                        bPuntoDesecho.setPerfil_img((String) jsonObject.get("profile_image_url"));

                        bPuntoDesecho.setEstado(true);
                        bPuntoDesecho.setTipo("t");

                        bPuntoDesecho.setGeometry(get_geo(jsonObject + ""));
                        //System.out.println(bPuntoDesecho.getIdpunto());
                        list.add(bPuntoDesecho);
                    }

                    System.out.println("Verifica  " +(list_in_db.get(j).getIdpunto()+"").equals(bp.getIdpunto()+""));
                }




            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        // System.out.println(list.size());

        return list;
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
            bGeometry.setLatitud(Double.parseDouble(lat));
            bGeometry.setLongitud(Double.parseDouble(lon));
            //double[] conIsrdinates = {Double.parseDouble(lat), Double.parseDouble(lon)};

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