package sample.ishir.com.sampleapp.Utils;

import android.view.View;
import android.widget.EditText;

import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.adapter.DefaultViewHolder;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class RecyTextView extends DefaultViewHolder {

    public EditText edtUsertext;
    public RecyTextView(View itemView) {
        super(itemView);
        edtUsertext = itemView.findViewById(R.id.edtUsertext);
    }
}
