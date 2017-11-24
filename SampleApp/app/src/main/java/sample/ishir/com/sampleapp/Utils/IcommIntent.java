package sample.ishir.com.sampleapp.Utils;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public interface IcommIntent {

    String SURVEY_OBJECT = "SURVEY_OBJECT";
    String LANGUAGE_SELECTED = "LANGUAGE_SELECTED";
    String QUESTION_LIST = "QUESTION_LIST";

    enum QUESTIONTYPE { TEXT, MULTIPLE_CHOICE_SINGLE , MULTIPLE_IMAGE ,DROPDOWN ,ACKNOWLEDGEMENT ,YES_NO }
}
