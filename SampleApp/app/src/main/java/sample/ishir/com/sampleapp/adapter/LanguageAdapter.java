package sample.ishir.com.sampleapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sample.ishir.com.sampleapp.Dataset.SurveyParse;
import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.activity.PageListActivity;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class LanguageAdapter extends BaseRecyIshirAdapter<SurveyView>{

    SurveyParse.SurveyDetail surveyParse;
    Activity activity;
    public LanguageAdapter(Activity activity, SurveyParse.SurveyDetail surveyParse) {
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
        holder.txtSingleText.setText(surveyParse.getLanguageLists().getkeyname(position));

        holder.view.setTag(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (int) v.getTag();
                Intent i = new Intent(activity, PageListActivity.class);
                i.putExtra(LANGUAGE_SELECTED, surveyParse.getLanguageLists().getJsonArrays().get(pos).toString());
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return surveyParse.getLanguageLists().getStringArrayListHashtable().size();
    }
}
