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

public class Button_1_Fragment extends Fragment {
    View view;
    private RecyclerView recyclerView_1;
    private List<ListViewModel> data;
    private ListAdapter adapter;
    private NewsRepository newsRepository;

    public Button_1_Fragment() { }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.button1_fragment, container, false);
        recyclerView_1 = view.findViewById(R.id.button_1_recyclerView);
        adapter = new ListAdapter(data, getContext());
        recyclerView_1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView_1.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newsRepository = new NewsRepository();
        data = newsRepository.setNews("https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=be4d0d91d59c419688d7d1c5be8311ff");
        adapter = new ListAdapter(data, getContext());
    }
}