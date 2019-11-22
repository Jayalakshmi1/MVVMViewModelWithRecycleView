package com.example.wiprotest.ui.main.service;

import com.example.wiprotest.ui.main.model.SocialFeedNewBO;

import retrofit2.Call;
import retrofit2.http.GET;
/**
 * Created by jbathula on 21,November,2019
 */
public interface  RestApiService {
    @GET("facts.json")
    Call<SocialFeedNewBO> getFeedList();
}
