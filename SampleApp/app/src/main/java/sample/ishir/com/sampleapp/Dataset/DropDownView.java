package sample.ishir.com.sampleapp.Dataset;

import android.view.View;
import android.widget.Spinner;

import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.adapter.DefaultViewHolder;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class DropDownView extends DefaultViewHolder {

    public Spinner spinner;
    public DropDownView(View dropDown) {
        super(dropDown);
        spinner = dropDown.findViewById(R.id.spinner);

    }
}
