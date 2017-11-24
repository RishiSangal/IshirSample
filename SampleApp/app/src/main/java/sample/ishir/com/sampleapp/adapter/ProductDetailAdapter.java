package sample.ishir.com.sampleapp.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import sample.ishir.com.sampleapp.Dataset.DropDownView;
import sample.ishir.com.sampleapp.Dataset.MultiChoiceLoadData;
import sample.ishir.com.sampleapp.Dataset.Questions;
import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.Utils.AcknowView;
import sample.ishir.com.sampleapp.Utils.MultiChoiceView;
import sample.ishir.com.sampleapp.Utils.MultiImageView;
import sample.ishir.com.sampleapp.Dataset.MultiImageViewLoadData;
import sample.ishir.com.sampleapp.Utils.RecyTextView;


/**
 * Created by Rishi.Sangal on 7/18/2017.
 */

public class ProductDetailAdapter extends BaseRecyIshirAdapter<DefaultViewHolder> {


    Activity activity;
    ArrayList<Questions> questions;
    public ProductDetailAdapter(Activity activity, ArrayList<Questions> questions) {
        super(activity);
        this.activity = activity;
        this.questions = questions;
    }


    @Override
    public DefaultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (questions.get(viewType).getQuestiontype()) {
            case TEXT: //
                View v2 = inflater.inflate(R.layout.cell_recy_text, parent, false);
                return new RecyTextView(v2);
            case MULTIPLE_CHOICE_SINGLE:
                View v3 = inflater.inflate(R.layout.cell_multi_choice, parent, false);
                return new MultiChoiceView(v3);

            case MULTIPLE_IMAGE:
                View v31 = inflater.inflate(R.layout.layout_multi_image, parent, false);
                return new MultiImageView(v31);

            case DROPDOWN:
                View dropDown = inflater.inflate(R.layout.layout_drop_down, parent, false);
                return new DropDownView(dropDown);

            case ACKNOWLEDGEMENT:
                View ackView = inflater.inflate(R.layout.layout_ackno, parent, false);
                return new AcknowView(ackView);

            case YES_NO:
                View v5 = inflater.inflate(R.layout.cell_multi_choice, parent, false);
                return new MultiChoiceView(v5);

            default:
//                View viewDefault = inflater.inflate(R.layout.layout_usage, parent, false);
//                return new DefaultViewHolder(viewDefault);
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(DefaultViewHolder viewHolder, int position) {
        try {
            switch (questions.get(position).getQuestiontype()) {
                case TEXT:
                    RecyTextView recyTextView = (RecyTextView) viewHolder;
                    break;

                case MULTIPLE_CHOICE_SINGLE:
                    MultiChoiceView multiChoiceView = (MultiChoiceView) viewHolder;
                    new MultiChoiceLoadData(activity, multiChoiceView, questions.get(position).getOptions());
                    break;

                case MULTIPLE_IMAGE:
                    MultiImageView multiImageView = (MultiImageView) viewHolder;
                    new MultiImageViewLoadData(activity, multiImageView, questions.get(position).getImages());
                    break;
                case DROPDOWN:
                    DropDownView dropDownView = (DropDownView) viewHolder;
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter
                            <String>(activity, android.R.layout.simple_spinner_item, questions.get(position).getOptions());
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dropDownView.spinner.setAdapter(dataAdapter);
                    break;
                case ACKNOWLEDGEMENT:
                    AcknowView ackView = (AcknowView) viewHolder;
                    ackView.txtAck.setText(questions.get(position).getDescription());
                    break;
                case YES_NO:
                    MultiChoiceView yesNoView = (MultiChoiceView) viewHolder;
                    ArrayList<String> yesStrings = questions.get(position).getOptions();
                    yesStrings.add("Yes");
                    yesStrings.add("No");
                    new MultiChoiceLoadData(activity, yesNoView, yesStrings);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }


}
