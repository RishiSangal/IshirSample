package sample.ishir.com.sampleapp.Dataset;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class LanguageList {

    Hashtable<String, ArrayList<Language>> stringArrayListHashtable;
    ArrayList<JSONArray> jsonArrays;
    public LanguageList(){
        stringArrayListHashtable = new Hashtable<>();
        jsonArrays = new ArrayList<>();
    }

    public void setLanguage(String en, JSONArray array) {
        if (array == null)
            array = new JSONArray();

        jsonArrays.add(array);
        ArrayList<Language> englishArrayList = new ArrayList<>(array.length());
        for (int i=0; i<array.length(); i++){
            englishArrayList.add(new Language(array.optJSONObject(i)));
        }

        stringArrayListHashtable.put(en, englishArrayList);
    }

    public Hashtable<String, ArrayList<Language>> getStringArrayListHashtable() {
        return stringArrayListHashtable;
    }

    public String getkeyname(int position) {
        List keys = new ArrayList(stringArrayListHashtable.keySet());
        return String.valueOf(keys.get(position));
    }

    public ArrayList<JSONArray> getJsonArrays() {
        return jsonArrays;
    }
}
