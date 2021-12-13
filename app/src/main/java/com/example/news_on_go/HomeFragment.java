package com.example.news_on_go;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    String api = "69e3b00176b646b7ab68380f74b450ee";
    Adapter adapter;
    ArrayList<ModelClass> modelClassArrayList;
    String country = "in";
    private RecyclerView homerecyclerView;

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,null);

        homerecyclerView = view.findViewById(R.id.homerecyclerview);
        modelClassArrayList = new ArrayList<>();
        homerecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        homerecyclerView.setAdapter(adapter);

        findNews();
        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<TopNews>() {
            @Override
            public void onResponse(Call<TopNews> call, Response<TopNews> response) {
                if(response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<TopNews> call, Throwable t) {

            }
        });
    }
}
