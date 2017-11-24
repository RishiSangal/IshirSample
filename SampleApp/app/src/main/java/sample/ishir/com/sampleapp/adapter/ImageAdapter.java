package sample.ishir.com.sampleapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import sample.ishir.com.sampleapp.Dataset.ImageIshir;
import sample.ishir.com.sampleapp.R;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class ImageAdapter extends BaseAdapter {

    ArrayList<ImageIshir> imageIshirs;
    Activity activity;
    public ImageAdapter(Activity activity, ArrayList<ImageIshir> imageIshirs) {
        this.imageIshirs = imageIshirs;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return imageIshirs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        final Holder holder;
        if (convertview == null) {
            convertview = activity.getLayoutInflater().inflate(R.layout.cell_image_holder, null);
            holder = new Holder(convertview);
        } else
            holder = (Holder) convertview.getTag(R.string.Tag_View);

        convertview.setTag(R.string.Tag_View, holder);

        holder.txtImage.setText("Image Url not available");
        holder.txtTitle.setText(imageIshirs.get(position).getTitle());
        return convertview;
    }

    private class Holder {
        public TextView txtImage,txtTitle;
        public Holder(View convertView) {
            txtImage= convertView.findViewById(R.id.txtImage);
            txtTitle=  convertView.findViewById(R.id.txtTitle);
        }
    }
}
