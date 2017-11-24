package sample.ishir.com.sampleapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import sample.ishir.com.sampleapp.Dataset.SurveyParse;
import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.adapter.LanguageAdapter;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class LanguageSelectActivity extends BaseActivity {

    SurveyParse.SurveyDetail surveyDetail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        try {
            surveyDetail = new SurveyParse().new SurveyDetail(new JSONObject(i.getStringExtra(SURVEY_OBJECT)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        initalize();
    }

    LanguageAdapter surveyAdapter;
    TextView txtSurveyName;
    RecyclerView recyMain;
    private void initalize() {
        txtSurveyName = findViewById(R.id.txtSurveyName);
        recyMain = findViewById(R.id.recyMain);
        recyMain.setLayoutManager(new LinearLayoutManager(LanguageSelectActivity.this));

        txtSurveyName.setText(surveyDetail.getName());
        surveyAdapter = new LanguageAdapter(LanguageSelectActivity.this, surveyDetail);
        recyMain.setAdapter(surveyAdapter);
    }
}
