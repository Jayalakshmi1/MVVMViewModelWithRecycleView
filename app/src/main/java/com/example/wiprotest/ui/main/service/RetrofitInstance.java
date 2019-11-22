package com.example.wiprotest.ui.main.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jbathula on 21,November,2019
 */
public class RetrofitInstance {
    public static final String BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";
    private static Retrofit retrofit = null;

    public static RestApiService getApiService() {
        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(RestApiService.class);

    }

}
