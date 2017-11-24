package sample.ishir.com.sampleapp.Dataset;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Rishi.Sangal on 11/23/2017.
 */

public class SurveyParse {

    ArrayList<SurveyDetail> surveyDetails;
    public SurveyParse(JSONObject jsonObject) {
        if (jsonObject == null)
            jsonObject = new JSONObject();

        JSONObject object = jsonObject.optJSONObject("data");
        JSONArray surveys = object.optJSONArray("surveys");
        if (surveys == null)
            surveys = new JSONArray();
        surveyDetails = new ArrayList<>(surveys.length());

        for (int i=0; i<surveys.length(); i++){
            surveyDetails.add(new SurveyDetail(surveys.optJSONObject(i)));
        }
    }

    public SurveyParse() {

    }

    public class SurveyDetail{
        String id, name, en, es;
//        ArrayList<English> englishArrayList;
//        ArrayList<Spanish> spanishArrayList;
        JSONObject jsonObject;
        LanguageList languageLists;
        public SurveyDetail(JSONObject jsonObject) {
            if (jsonObject == null)
                jsonObject = new JSONObject();

            this.jsonObject = jsonObject;
            id = jsonObject.optString("id");
            name = jsonObject.optString("name");

            languageLists = new LanguageList();
            if (jsonObject.has("en")){
                languageLists.setLanguage("en",jsonObject.optJSONArray("en"));
            }


            if (jsonObject.has("es")){
                languageLists.setLanguage("es",jsonObject.optJSONArray("es"));
            }

//            JSONArray array1 = jsonObject.optJSONArray("es");
//            if (array1 == null)
//                array1 = new JSONArray();
//            spanishArrayList = new ArrayList<>(array1.length());
//            for (int i=0; i<array1.length(); i++){
//                spanishArrayList.add(new Spanish(array1.optJSONObject(i)));
//            }
        }

        public LanguageList getLanguageLists() {
            return languageLists;
        }

        public JSONObject getJsonObject() {
            return jsonObject;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEn() {
            return en;
        }

        public String getEs() {
            return es;
        }

//        public ArrayList<English> getEnglishArrayList() {
//            return englishArrayList;
//        }
//
//        public ArrayList<Spanish> getSpanishArrayList() {
//            return spanishArrayList;
//        }
    }

    public ArrayList<SurveyDetail> getSurveyDetails() {
        return surveyDetails;
    }
}
