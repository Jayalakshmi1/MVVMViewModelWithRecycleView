package com.example.wiprotest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.wiprotest.databinding.MainActivityBinding;
import com.example.wiprotest.ui.main.MainViewModel;
import com.example.wiprotest.ui.main.model.Row;
import com.example.wiprotest.ui.main.adapter.FeedNewsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    FeedNewsAdapter feedNewsAdapter;
    MainViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainActivityBinding activityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.main_activity);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
         recyclerView = activityMainBinding.recycleView;
         swipeRefreshLayout = activityMainBinding.swipeRefresh;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        prepareRecyclerView();
        getPopularBlog();


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                MainActivity.this.getPopularBlog();
            }
        });
    }

    public void getPopularBlog() {
        swipeRefreshLayout.setRefreshing(true);
        mViewModel.getAllBlog().observe(this, new Observer<List<Row>>() {
            @Override
            public void onChanged(List<Row> blogList) {
                swipeRefreshLayout.setRefreshing(false);
                feedNewsAdapter.setFeedList((ArrayList<Row>) blogList);

            }
        });
    }

    private void prepareRecyclerView() {

        feedNewsAdapter = new FeedNewsAdapter();
        recyclerView.setAdapter(feedNewsAdapter);
        feedNewsAdapter.notifyDataSetChanged();

    }
}
