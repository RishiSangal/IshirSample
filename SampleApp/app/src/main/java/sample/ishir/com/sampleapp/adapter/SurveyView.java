package sample.ishir.com.sampleapp.adapter;

import android.view.View;
import android.widget.TextView;

import sample.ishir.com.sampleapp.R;


/**
 * Created by Rishi.Sangal on 11/20/2017.
 */

public class SurveyView extends DefaultViewHolder {

    public TextView txtSingleText;
    public View view;
    public SurveyView(View itemView) {
        super(itemView);
        view = itemView;
        txtSingleText = itemView.findViewById(R.id.txtSingleText);
    }
}