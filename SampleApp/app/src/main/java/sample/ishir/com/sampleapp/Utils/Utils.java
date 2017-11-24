package sample.ishir.com.sampleapp.Utils;

import android.app.Activity;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Rishi.Sangal on 11/23/2017.
 */

public class Utils {

    public static String loadJSONFromAsset(Activity activity) {
        String json = null;
        try {
            InputStream is = activity.getAssets().open("surveys.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static IcommIntent.QUESTIONTYPE setQuestionType(String question){
        if (question.equalsIgnoreCase("TEXT")){
            return IcommIntent.QUESTIONTYPE.TEXT;
        }
        else if (question.equalsIgnoreCase("MULTIPLE_CHOICE_SINGLE")){
            return IcommIntent.QUESTIONTYPE.MULTIPLE_CHOICE_SINGLE;
        }
        else if (question.equalsIgnoreCase("DROPDOWN")){
            return IcommIntent.QUESTIONTYPE.DROPDOWN;
        }
        else if (question.equalsIgnoreCase("MULTIPLE_IMAGE")){
            return IcommIntent.QUESTIONTYPE.MULTIPLE_IMAGE;
        }
        else if (question.equalsIgnoreCase("YES_NO")){
            return IcommIntent.QUESTIONTYPE.YES_NO;
        }
        else if (question.equalsIgnoreCase("ACKNOWLEDGEMENT")){
            return IcommIntent.QUESTIONTYPE.ACKNOWLEDGEMENT;
        }
        else {
            return IcommIntent.QUESTIONTYPE.TEXT;
        }
    }
}
