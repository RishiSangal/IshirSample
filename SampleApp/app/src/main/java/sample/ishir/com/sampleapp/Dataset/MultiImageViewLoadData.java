package sample.ishir.com.sampleapp.Dataset;

import android.app.Activity;

import java.util.ArrayList;

import sample.ishir.com.sampleapp.Utils.MultiImageView;
import sample.ishir.com.sampleapp.adapter.ImageAdapter;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class MultiImageViewLoadData {

    Activity activity;
    MultiImageView multiImageView;
    ArrayList<ImageIshir> imageIshirs;

    public MultiImageViewLoadData(Activity activity, MultiImageView multiImageView, ArrayList<ImageIshir> images) {
    this.activity = activity;
    this.multiImageView = multiImageView;
    imageIshirs = images;

    initalize();
    }

    private void initalize() {

        multiImageView.grdImage.setAdapter(new ImageAdapter(activity, imageIshirs));
    }
}
