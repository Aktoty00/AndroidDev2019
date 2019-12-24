package com.example.stakanchik.repository;

import android.os.AsyncTask;
import android.util.Log;
import com.example.stakanchik.models.News;
import com.example.stakanchik.viewmodels.ListViewModel;
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

public class NewsRepository {
    private List<ListViewModel> data;
    String content;
    class MyArticle extends AsyncTask<String,Void,String> {
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
                while (data != -1) {
                    ch = (char) data;
                    content = content + ch;
                    data = inputStreamReader.read();
                }
                return content;
            }
            catch (MalformedURLException e) { e.printStackTrace(); }
            catch (IOException e) { e.printStackTrace(); }
            return null;
        }
    }

    public List<ListViewModel> setNews(String link){
        data = new ArrayList<>();
        MyArticle article = new MyArticle();
        try {
            content = article.execute(link).get();
            Log.i("content", content);

            //JSON
            JSONObject jsonObject = new JSONObject(content);
            String articleData = jsonObject.getString("articles");
            Log.i("articleData", articleData);

            //news data is in array
            JSONArray array = new JSONArray(articleData);
            ListViewModel listViewModel;
            News news = new News();

            for(int i=0; i<array.length(); i++){
                JSONObject articlePart = array.getJSONObject(i);

                news.title = articlePart.getString("title");
                news.decription= articlePart.getString("description");
                news.imageURL = articlePart.getString("urlToImage");
                news.dateTime = articlePart.getString("publishedAt");
                news.content = articlePart.getString("content");

                SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                Date dt = sd1.parse(news.dateTime);
                SimpleDateFormat sd2 = new SimpleDateFormat("dd.mm.yyyy hh:mm");
                news.dateTime = sd2.format(dt);

                listViewModel= new ListViewModel(news);
                data.add(listViewModel);

                Log.i("title", news.title);
                Log.i("description", news.decription);
                Log.i("dateTime", news.dateTime);
                Log.i("urlToImage", news.imageURL);
                Log.i("content", news.content);
            }
        } catch (Exception e) {e.printStackTrace();}
        return data;
    }
}
