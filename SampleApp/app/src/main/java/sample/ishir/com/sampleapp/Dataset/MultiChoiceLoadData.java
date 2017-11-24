package sample.ishir.com.sampleapp.Dataset;

import android.app.Activity;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.Utils.MultiChoiceView;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class MultiChoiceLoadData {

    Activity activity;
    MultiChoiceView multiChoiceView;
    ArrayList<String> options;
    public MultiChoiceLoadData(Activity activity, MultiChoiceView multiChoiceView, ArrayList<String> options) {

        this.activity = activity;
        this.multiChoiceView = multiChoiceView;
        this.options = options;

        initalize();
    }


    private void initalize() {

        for (int i=0; i<options.size(); i++){
            setCompareItem(options.get(i));
        }
    }

    private void setCompareItem(String s) {

        View currentView;
        RadioButton radButton;
        currentView = activity.getLayoutInflater().inflate(R.layout.cell_radio_button, null);
        radButton =  currentView.findViewById(R.id.radButton);

        radButton.setText(s);

        multiChoiceView.layRadioContainer.addView(currentView);
    }
}
