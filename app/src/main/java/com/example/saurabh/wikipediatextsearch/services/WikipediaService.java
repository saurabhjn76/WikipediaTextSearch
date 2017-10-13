package com.example.saurabh.wikipediatextsearch.services;

import com.example.saurabh.wikipediatextsearch.models.WikipediaResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by danilolemes on 13/10/2017.
 */

public interface WikipediaService {

    @GET("w/api.php?action=query&utf8=true&list=search&format=json")
    Call<WikipediaResponse> search(@QueryMap(encoded=false) Map<String, String> options);

}
