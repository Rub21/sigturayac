package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
/*
 import android.app.Activity;
 import android.os.Bundle;
 import android.util.Log;
 import android.widget.Toast;*/

import com.google.gson.Gson;
import java.io.BufferedInputStream;
import org.apache.http.client.HttpClient;

public class JsonParsingActivity {

    String url = "http://search.twitter.com/search.json?q=javacodegeeks";
    InputStream source = retrieveStream(url);
    Gson gson = new Gson();
    Reader reader = new InputStreamReader(source);
    
    SearchResponse response = gson.fromJson(reader, SearchResponse.class);
    List<Result> results = response.results;    


    private InputStream retrieveStream(String url) {

        DefaultHttpClient client = new DefaultHttpClient();

        HttpGet getRequest = new HttpGet(url);

        try {

            HttpResponse getResponse = client.execute(getRequest);

            final int statusCode = getResponse.getStatusLine().getStatusCode();
            System.out.println(HttpStatus.SC_OK);
            if (statusCode != HttpStatus.SC_OK) {

                //Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL " + url);

                return null;

            }

            HttpEntity getResponseEntity = getResponse.getEntity();

            System.out.println(getResponseEntity);
            return getResponseEntity.getContent();

        } catch (IOException e) {

            getRequest.abort();

            // Log.w(getClass().getSimpleName(), "Error for URL " + url, e);

        }

        return null;

    }

  
}