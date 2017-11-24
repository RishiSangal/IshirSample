package sample.ishir.com.sampleapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import sample.ishir.com.sampleapp.Dataset.Questions;
import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.adapter.ProductDetailAdapter;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class PageDetailActivity extends BaseActivity{

    ArrayList<Questions> questions;
    JSONArray array;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            array = new JSONArray(getIntent().getStringExtra(QUESTION_LIST));
            if (array == null)
                array = new JSONArray();

            questions = new ArrayList<>(array.length());
            for (int i=0; i<array.length(); i++){
                questions.add(new Questions(array.optJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        initalize();
    }

    ProductDetailAdapter questionAdapter;
    RecyclerView recyMain;
    private void initalize() {
        recyMain = findViewById(R.id.recyMain);
        recyMain.setLayoutManager(new LinearLayoutManager(PageDetailActivity.this));

        questionAdapter = new ProductDetailAdapter(PageDetailActivity.this, questions);
        recyMain.setAdapter(questionAdapter);
    }
}
