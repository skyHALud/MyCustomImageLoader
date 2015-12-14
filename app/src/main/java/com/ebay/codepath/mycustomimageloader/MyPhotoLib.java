package com.ebay.codepath.mycustomimageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by renyedi on 12/13/15.
 */
public class MyPhotoLib {
    private static class PhotoLoaderTask extends AsyncTask<String, Void, Bitmap> {
        private ImageView iv;

        public PhotoLoaderTask(ImageView iv) {
            this.iv = iv;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            try {
                // 1. Declare a URL Connection
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                // 2. Open InputStream to connection
                conn.connect();
                InputStream in = conn.getInputStream();
                // 3. Download and decode the bitmap using BitmapFactory
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                in.close();

                return bitmap;
            } catch(IOException ex) {
                Log.e("myphotoid", ex.getLocalizedMessage(), ex);
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if(bitmap != null) {
                iv.setImageBitmap(bitmap);
            }
        }
    }

    public static void load(String url, ImageView ivPhoto) {
        PhotoLoaderTask loaderTask = new PhotoLoaderTask(ivPhoto);
        loaderTask.execute(url);
    }
}
