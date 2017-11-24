package sample.ishir.com.sampleapp.Utils;

import android.view.View;
import android.widget.RadioGroup;

import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.adapter.DefaultViewHolder;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class MultiChoiceView extends DefaultViewHolder{

    public RadioGroup layRadioContainer;
    public MultiChoiceView(View itemView) {
        super(itemView);
        layRadioContainer = itemView.findViewById(R.id.layRadioContainer);

    }
}
