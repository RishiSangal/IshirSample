package sample.ishir.com.sampleapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sample.ishir.com.sampleapp.Dataset.Language;
import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.activity.PageDetailActivity;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class PageListAdapter extends BaseRecyIshirAdapter<SurveyView>{

    ArrayList<Language> languageList;
    Activity activity;
    public PageListAdapter(Activity activity, ArrayList<Language> surveyParse) {
        super(activity);
        this.activity = activity;
        this.languageList = surveyParse;
    }

    @Override
    public SurveyView onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v2 = inflater.inflate(R.layout.layout_single_text, parent, false);
        return new SurveyView(v2);
    }

    @Override
    public void onBindViewHolder(SurveyView holder, int position) {
        holder.txtSingleText.setText(languageList.get(position).getPageTitle());

        holder.view.setTag(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (int) v.getTag();
                Intent i = new Intent(activity, PageDetailActivity.class);
                i.putExtra(QUESTION_LIST, languageList.get(pos).getJsonArray().toString());
                activity.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return languageList.size();
    }
}
