package sample.ishir.com.sampleapp.Dataset;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class Language {

    String pageTitle, pageSubTitle, picture;
    ArrayList<Questions> questionsArrayList;
    JSONArray jsonArray;

    public Language(JSONObject jsonObject) {
        if (jsonObject == null)
            jsonObject = new JSONObject();

        pageTitle = jsonObject.optString("pageTitle");
        pageSubTitle = jsonObject.optString("pageSubTitle");
        picture = jsonObject.optString("picture");

        JSONArray questions = jsonObject.optJSONArray("questions");
        if (questions == null)
            questions =new JSONArray();
        jsonArray = questions;

        questionsArrayList = new ArrayList<>(questions.length());
        for (int i=0; i<questions.length(); i++){
            questionsArrayList.add(new Questions(questions.optJSONObject(i)));
        }
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageSubTitle() {
        return pageSubTitle;
    }

    public String getPicture() {
        return picture;
    }

    public ArrayList<Questions> getQuestionsArrayList() {
        return questionsArrayList;
    }

    public JSONArray getJsonArray() {
        return jsonArray;
    }
}
