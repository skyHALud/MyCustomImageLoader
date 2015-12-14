package com.ebay.codepath.mycustomimageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        // 1. Download an image from URL and put it in an image view
        // 2. Download, resize and put into an image view

        // MyPhotoLib.load("http://", imageView)

        String url = "https://i.imgur.com/tGbaZCY.jpg";
        ImageView ivPhoto = (ImageView) findViewById(R.id.ivPhoto);

        MyPhotoLib.load(url, ivPhoto);
    }
}
