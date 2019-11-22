package com.example.wiprotest.service;

import com.example.wiprotest.ui.main.service.RestApiService;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.wiprotest.ui.main.service.RetrofitInstance.BASE_URL;
import static org.junit.Assert.assertEquals;

/**
 * Created by jbathula on 22,November,2019
 */
public class RestApiServiceTest {
    RestApiService apiService;
    @Before
    public void createService() {
        apiService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestApiService.class);
    }


    @Test
    public void getFeedListResponse() {
        try {
            Response response = apiService.getFeedList().execute();
            assertEquals(response.code(), 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
