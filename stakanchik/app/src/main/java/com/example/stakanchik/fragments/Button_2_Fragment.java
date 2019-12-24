package com.example.stakanchik.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.stakanchik.Adapter.ListAdapter;
import com.example.stakanchik.R;
import com.example.stakanchik.repository.NewsRepository;
import com.example.stakanchik.viewmodels.ListViewModel;
import java.util.List;

public class Button_2_Fragment extends Fragment {
    View view;
    private RecyclerView recyclerView_2;
    private List<ListViewModel> data;
    private ListAdapter adapter;
    private NewsRepository newsRepository;

    public Button_2_Fragment() {  }

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsRepository = new NewsRepository();
        data = newsRepository.setNews("https://newsapi.org/v2/everything?q=apple&from=2019-12-05&to=2019-12-05&sortBy=popularity&apiKey=be4d0d91d59c419688d7d1c5be8311ff");
        adapter = new ListAdapter(data, getContext());
    }
}