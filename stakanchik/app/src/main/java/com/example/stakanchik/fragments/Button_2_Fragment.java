package com.example.stakanchik.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stakanchik.Adapter.ListAdapter;
import com.example.stakanchik.R;
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

public class Button_2_Fragment extends Fragment {
    View view;
    private RecyclerView recyclerView_2;
    private List<ListViewModel> data;
    private ListAdapter adapter;

    public Button_2_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.button2_fragment, container, false);
        recyclerView_2 = view.findViewById(R.id.button_2_recyclerView);
        adapter = new ListAdapter(data, getContext());
        recyclerView_2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_2.setAdapter(adapter);
        return view;
    }
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

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ArrayList<>();
        String content;
        MyArticle article = new MyArticle();
        try {
            content = article.execute("https://newsapi.org/v2/everything?q=apple&from=2019-12-05&to=2019-12-05&sortBy=popularity&apiKey=be4d0d91d59c419688d7d1c5be8311ff").get();
            Log.i("content", content);

            //JSON
            JSONObject jsonObject = new JSONObject(content);
            String articleData = jsonObject.getString("articles");
            Log.i("articleData", articleData);

            //news data is in array
            JSONArray array = new JSONArray(articleData);
            ListViewModel listViewModel = new ListViewModel();

            for(int i=0; i<array.length(); i++){
                JSONObject articlePart = array.getJSONObject(i);

                listViewModel.title = articlePart.getString("title");
                listViewModel.decription= articlePart.getString("description");
                listViewModel.imageURL = articlePart.getString("urlToImage");
                listViewModel.dateTime = articlePart.getString("publishedAt");
                listViewModel.content = articlePart.getString("content");

                SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                Date dt = sd1.parse(listViewModel.dateTime);
                SimpleDateFormat sd2 = new SimpleDateFormat("dd.mm.yyyy hh:mm");
                listViewModel.dateTime = sd2.format(dt);

                listViewModel = new ListViewModel(listViewModel.title, listViewModel.decription, listViewModel.dateTime,  listViewModel.content, listViewModel.imageURL);

                data.add(listViewModel);

                Log.i("title", listViewModel.title);
                Log.i("description", listViewModel.decription);
                Log.i("dateTime", listViewModel.dateTime);
                Log.i("urlToImage", listViewModel.imageURL);
                Log.i("content", listViewModel.content);
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}