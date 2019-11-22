package com.example.wiprotest.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wiprotest.R;
import com.example.wiprotest.databinding.FeedItemsBinding;
import com.example.wiprotest.ui.main.model.Row;

import java.util.ArrayList;

/**
 * Created by jbathula on 21,November,2019
 */
public class FeedNewsAdapter extends RecyclerView.Adapter<FeedNewsAdapter.FeedViewHolder> {
    private static final String TAG = "FeedNewsAdapter";

        private ArrayList<Row> rows;

        @NonNull
        @Override
        public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            FeedItemsBinding listItemBinding =
                    DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                            R.layout.feed_items, viewGroup, false);
            return new FeedViewHolder(listItemBinding);
        }

        @Override
        public void onBindViewHolder(@NonNull FeedViewHolder feedViewHolder, int i) {
            Row row = rows.get(i);
            feedViewHolder.listItemBinding.setFeed(row);
        }

        @Override
        public int getItemCount() {
            if (rows != null) {
                return rows.size();
            } else {
                return 0;
            }
        }

    public void setFeedList(ArrayList<Row> list) {
            rows = list;
            notifyDataSetChanged();
    }


    class FeedViewHolder extends RecyclerView.ViewHolder {

            private FeedItemsBinding listItemBinding;

            public FeedViewHolder(@NonNull FeedItemsBinding listItemBinding) {
                super(listItemBinding.getRoot());

                this.listItemBinding = listItemBinding;
            }
        }
}