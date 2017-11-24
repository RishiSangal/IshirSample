package sample.ishir.com.sampleapp.Dataset;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import sample.ishir.com.sampleapp.Utils.IcommIntent;
import sample.ishir.com.sampleapp.Utils.Utils;

/**
 * Created by Rishi Sangal on 23-11-2017.
 */

public class Questions implements IcommIntent{

    String name, placeholder, type, description;
    boolean required;
    QUESTIONTYPE questiontype;
    ArrayList<String> options;
    ArrayList<ImageIshir> images;
    public Questions(JSONObject jsonObject) {
        if (jsonObject == null)
            jsonObject = new JSONObject();

        name = jsonObject.optString("name");
        placeholder = jsonObject.optString("placeholder");
        type = jsonObject.optString("type");
        required = jsonObject.optString("required").contains("true");
        questiontype = Utils.setQuestionType(getType());


        switch (questiontype){
            case MULTIPLE_CHOICE_SINGLE:
                options = new ArrayList<>();
                JSONArray array = jsonObject.optJSONArray("options");
                for (int i=0; i<array.length(); i++){
                    options.add(array.optString(i));
                }
                break;
            case DROPDOWN:
                options = new ArrayList<>();
                JSONArray arrayDrop = jsonObject.optJSONArray("options");
                for (int i=0; i<arrayDrop.length(); i++){
                    options.add(arrayDrop.optString(i));
                }
                break;
            case MULTIPLE_IMAGE:
                images = new ArrayList<>();
                JSONArray jsonArray = jsonObject.optJSONArray("images");
                for (int i=0; i<jsonArray.length(); i++){
                    images.add(new ImageIshir(jsonArray.optJSONObject(i)));
                }
                break;
            case ACKNOWLEDGEMENT:
                description = jsonObject.optString("description");
                break;
        }
    }

    public String getName() {
        return name;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public String getType() {
        return type;
    }

    public boolean isRequired() {
        return required;
    }

    public QUESTIONTYPE getQuestiontype() {
        return questiontype;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public ArrayList<ImageIshir> getImages() {
        return images;
    }

    public String getDescription() {
        return description;
    }
}
