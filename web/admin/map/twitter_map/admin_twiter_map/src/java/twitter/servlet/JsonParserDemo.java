/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter.servlet;

/**
 *
 * @author ruben
 */
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class JsonParserDemo {
 
  private String jsonSource;
  private boolean sourceFromFile;
  public JsonParserDemo(String jsonSource, boolean sourceFromFile){
    this.jsonSource = jsonSource;
    this.sourceFromFile = sourceFromFile;
  }
  public static void main(String[] args){
    JsonParserDemo jsonParserDemo =
     new JsonParserDemo("http://search.twitter.com/search.json?q=%23aquid&include_entities=1", true);
    try{
        JsonReader jsonReader = jsonParserDemo.getJsonReader();
      Gson myGson = new Gson();
      JsonParser jsonParser = new JsonParser();
      JsonArray userArray =  jsonParser.parse(jsonReader).getAsJsonArray();
      List twitterUsers = new ArrayList();
      for ( JsonElement aUser : userArray ){
        TwitterUser aTwitterUser = myGson.fromJson(aUser, TwitterUser.class);
        twitterUsers.add(aTwitterUser);
      }
      for ( Object tUser : twitterUsers){
        System.out.println(tUser);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
 
  /**
  * Obtain the JsonReader for the given source details.
  * @return the JsonReader instance
  * @throws FileNotFoundException
  */
  private JsonReader getJsonReader () throws FileNotFoundException{
    JsonReader reader = null;
    if (sourceFromFile){
      reader = new JsonReader(
        new InputStreamReader(new FileInputStream(this.jsonSource)));
    }
    return reader;
  }
}
 
/**
* Model class for storing the selected few attributes
* for a Twitter User profile.
*/
class TwitterUser{
  private String id;
  private String name;
  private String screen_name;
  private String url;
  private int friends_count;
  private int followers_count;
  private int favourites_count;
  private int statuses_count;
 
  public TwitterUser(){
  }
 
  @Override
  public String toString(){
    return "Name: "+this.name+"n" +
      "Screen Name: "+this.screen_name+"n" +
      "Number of Friends: "+ this.friends_count + "n" +
      "Number of Followers: "+ this.followers_count +"n" +
      "Number of Status updates: "+this.statuses_count +"n" +
      "Number of favorites: "+this.favourites_count +"n";
  }
}