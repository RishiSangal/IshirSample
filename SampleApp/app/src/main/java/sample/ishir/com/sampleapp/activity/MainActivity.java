package sample.ishir.com.sampleapp.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.adapter.SurveyAdapter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callJsonFile();
        initalize();
    }

    SurveyAdapter surveyAdapter;
    RecyclerView recyMain;
    private void initalize() {
        recyMain = findViewById(R.id.recyMain);
        recyMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        surveyAdapter = new SurveyAdapter(MainActivity.this, surveyParse);
        recyMain.setAdapter(surveyAdapter);
    }
}
