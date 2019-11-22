package com.example.wiprotest.ui.main.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.wiprotest.ui.main.model.Row;
import com.example.wiprotest.ui.main.model.SocialFeedNewBO;
import com.example.wiprotest.ui.main.service.RestApiService;
import com.example.wiprotest.ui.main.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jbathula on 21,November,2019
 */
public class SocialFeedRepository {
    private ArrayList<Row> movies = new ArrayList<>();
    private MutableLiveData<List<Row>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public SocialFeedRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Row>> getMutableLiveData() {

        RestApiService apiService = RetrofitInstance.getApiService();

        Call<SocialFeedNewBO> call = apiService.getFeedList();

        call.enqueue(new Callback<SocialFeedNewBO>() {
            @Override
            public void onResponse(Call<SocialFeedNewBO> call, Response<SocialFeedNewBO> response) {
                SocialFeedNewBO socialFeedNewBO = response.body();
                if (socialFeedNewBO != null && socialFeedNewBO.getRows() != null) {
                    movies = (ArrayList<Row>) socialFeedNewBO.getRows();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<SocialFeedNewBO> call, Throwable t) {

            }
        });


        return mutableLiveData;
    }
}
