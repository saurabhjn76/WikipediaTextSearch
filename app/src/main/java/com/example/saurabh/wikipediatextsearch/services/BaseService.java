package com.example.saurabh.wikipediatextsearch.services;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by danilolemes on 13/10/2017.
 */

public class BaseService {
    private static final BaseService ourInstance = new BaseService();
    private static final String BASE_URL = "https://en.wikipedia.org/";

    private Retrofit retrofit;

    private final static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(2, TimeUnit.MINUTES)
            .build();

    public static BaseService getInstance() {
        return ourInstance;
    }

    private BaseService() {
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public WikipediaService getWikiService() {
        return retrofit.create(WikipediaService.class);
    }
}
