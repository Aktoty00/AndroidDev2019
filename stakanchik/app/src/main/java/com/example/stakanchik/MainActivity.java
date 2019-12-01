package com.example.stakanchik;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    private List<ListItem> listItems;

    class MyArticle extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... address) {

            try {
                URL url = new URL(address[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();
                String content = "";
                char ch;
                while(data != -1){
                    ch = (char) data;
                    content = content + ch;
                    data = inputStreamReader.read();
                }
                return  content;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        String content;
        listItems = new ArrayList<>();

        MyArticle article = new MyArticle();
        try {
            content = article.execute("https://newsapi.org/v2/everything?q=bitcoin&from=2019-11-01&sortBy=publishedAt&apiKey=be4d0d91d59c419688d7d1c5be8311ff").get();
            Log.i("content", content);

            //JSON
            JSONObject jsonObject = new JSONObject(content);
            String articleData = jsonObject.getString("articles");
            Log.i("articleData", articleData);

            //news data is in array
            JSONArray array = new JSONArray(articleData);
            String title = "";
            String description = "";
            String urlToImage = "";
            String dateTime = "";

            String myContent = "";

            for(int i=0; i<array.length(); i++){
                JSONObject articlePart = array.getJSONObject(i);
                title = articlePart.getString("title");
                description = articlePart.getString("description");
                urlToImage = articlePart.getString("urlToImage");
                myContent = articlePart.getString("content");

                dateTime = articlePart.getString("publishedAt");
                SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                Date dt = sd1.parse(dateTime);
                SimpleDateFormat sd2 = new SimpleDateFormat("dd.mm.yyyy hh:mm");
                dateTime = sd2.format(dt);

                ListItem listItem = new ListItem(
                  title, description, dateTime, urlToImage, myContent
                );
                listItems.add(listItem);
            }

            Log.i("title", title);
            Log.i("description", description);
            Log.i("dateTime", dateTime);
            Log.i("urlToImage", urlToImage);
            Log.i("content", myContent);

        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter = new Adapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }
}
