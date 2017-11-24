package sample.ishir.com.sampleapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sample.ishir.com.sampleapp.Dataset.SurveyParse;
import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.activity.LanguageSelectActivity;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class SurveyAdapter extends BaseRecyIshirAdapter<SurveyView>{

    SurveyParse surveyParse;
    Activity activity;
    public SurveyAdapter(Activity activity, SurveyParse surveyParse) {
        super(activity);
        this.activity = activity;
        this.surveyParse = surveyParse;
    }

    @Override
    public SurveyView onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v2 = inflater.inflate(R.layout.layout_single_text, parent, false);
        return new SurveyView(v2);
    }

    @Override
    public void onBindViewHolder(SurveyView holder, final int position) {
        holder.txtSingleText.setText(surveyParse.getSurveyDetails().get(position).getName());

        holder.view.setTag(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (int) v.getTag();

                Intent i = new Intent(activity, LanguageSelectActivity.class);
                i.putExtra(SURVEY_OBJECT, surveyParse.getSurveyDetails().get(pos).getJsonObject().toString());
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return surveyParse.getSurveyDetails().size();
    }
}
