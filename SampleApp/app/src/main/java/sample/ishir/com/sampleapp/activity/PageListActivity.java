package sample.ishir.com.sampleapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import sample.ishir.com.sampleapp.Dataset.Language;
import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.adapter.PageListAdapter;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class PageListActivity extends BaseActivity{

    ArrayList<Language> languages;
    JSONArray array;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            array = new JSONArray(getIntent().getStringExtra(LANGUAGE_SELECTED));
            if (array == null)
                array = new JSONArray();

            languages = new ArrayList<>(array.length());
            for (int i=0; i<array.length(); i++){
                languages.add(new Language(array.optJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        initalize();
    }

    PageListAdapter surveyAdapter;
    TextView txtSurveyName;
    RecyclerView recyMain;
    private void initalize() {
        txtSurveyName = findViewById(R.id.txtSurveyName);
        recyMain = findViewById(R.id.recyMain);
        recyMain.setLayoutManager(new LinearLayoutManager(PageListActivity.this));

        surveyAdapter = new PageListAdapter(PageListActivity.this, languages);
        recyMain.setAdapter(surveyAdapter);
    }
}
