package sample.ishir.com.sampleapp.Utils;

import android.view.View;
import android.widget.GridView;

import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.adapter.DefaultViewHolder;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class MultiImageView extends DefaultViewHolder {

    public GridView grdImage;
    public MultiImageView(View v31) {
        super(v31);
        grdImage = v31.findViewById(R.id.grdImage);
    }
}
