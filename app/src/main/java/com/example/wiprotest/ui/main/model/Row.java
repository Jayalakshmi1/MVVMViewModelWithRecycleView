package com.example.wiprotest.ui.main.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.wiprotest.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

/**
 * Created by jbathula on 21,November,2019
 */
public class Row {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageHref")
    @Expose
    private String imageHref;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageHref() {
        return imageHref;
    }

    public void setImageHref(String imageHref) {
        this.imageHref = imageHref;
    }

    @BindingAdapter({ "profileImage" })
    public static  void loadImage(ImageView imageView, String imageURL) {

        if (imageURL != null) {
            Picasso.with(imageView.getContext()).load(imageURL).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).noFade().into(imageView);
        }
    }
}
