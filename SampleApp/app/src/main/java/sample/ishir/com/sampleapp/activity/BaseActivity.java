package sample.ishir.com.sampleapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import sample.ishir.com.sampleapp.Dataset.SurveyParse;
import sample.ishir.com.sampleapp.Utils.IcommIntent;
import sample.ishir.com.sampleapp.Utils.Utils;

/**
 * Created by Rishi Sangal on 23-11-2017.
 */

public class BaseActivity extends AppCompatActivity implements IcommIntent{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    SurveyParse surveyParse;
    public void callJsonFile() {
        try {
            JSONObject jsonObject = new JSONObject(Utils.loadJSONFromAsset(BaseActivity.this));
            surveyParse = new SurveyParse(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
