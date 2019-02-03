package com.example.user.anthariksh;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private HttpURLConnection connection;
    private StringBuffer buffer;
    private BufferedReader bufferedReader;
    private TimesOfIndia timesOfIndia = null;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        new json().execute("https://newsapi.org/v2/everything?q=bitcoin&from=2019-01-01&sortBy=publishedAt&apiKey=7e277a78bcdd485facdc9eb745ea5ba1");


    }


    class json extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... urls) {

            try {
                URL url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(stream));
               buffer = new StringBuffer();
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    buffer.append(line);
                }
                    return  buffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            try{

                Log.e("tarunkonda",buffer.toString());
                timesOfIndia = fromJSON(buffer.toString());
                CustomAdapter customAdapter=new CustomAdapter(MainActivity.this,timesOfIndia.getArticles());
                listView.setAdapter(customAdapter);
                Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();




            }catch (Exception e){
                Toast.makeText(MainActivity.this, "exception"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public  TimesOfIndia fromJSON(String json) {
        return new Gson().fromJson(json, TimesOfIndia.class);
    }
}