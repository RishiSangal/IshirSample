package sample.ishir.com.sampleapp.Dataset;

import org.json.JSONObject;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class ImageIshir {

    String title, url;
    public ImageIshir(JSONObject jsonObject) {
        if (jsonObject == null)
            jsonObject = new JSONObject();

        title = jsonObject.optString("title");
        url = jsonObject.optString("url");
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
