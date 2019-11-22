package com.example.wiprotest.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wiprotest.ui.main.model.Row;
import com.example.wiprotest.ui.main.repository.SocialFeedRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private SocialFeedRepository socialFeedRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        socialFeedRepository = new SocialFeedRepository(application);
    }

    public LiveData<List<Row>> getAllBlog() {
        return socialFeedRepository.getMutableLiveData();
    }


}
