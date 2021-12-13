package com.example.news_on_go;

import java.net.URL;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<TopNews> getNews(
            @Query("country") String country,
            @Query("pageSize") int pageize,
            @Query("apiKey") String apikey
    );

    @GET("top-headlines")
    Call<TopNews> getCategoryNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pageize,
            @Query("apiKey") String apikey
    );
}
