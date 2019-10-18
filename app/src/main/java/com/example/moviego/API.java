package com.example.moviego;

import com.example.moviego.model.MovieResponse;
import com.example.moviego.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {
    @GET("top-headlines")
    Call<NewsResponse> News (@Query("country") String _id,
                             @Query("category") String category,
                             @Query("apiKey") String apiKey
                     );

    @GET("movie/popular")
    Call<MovieResponse> Movie (@Query("page") String page);

}
