package sample.ishir.com.sampleapp.Utils;

import android.view.View;
import android.widget.TextView;

import sample.ishir.com.sampleapp.R;
import sample.ishir.com.sampleapp.adapter.DefaultViewHolder;

/**
 * Created by Rishi.Sangal on 11/24/2017.
 */

public class AcknowView extends DefaultViewHolder {

    public TextView txtAck;
    public AcknowView(View ackView) {
        super(ackView);

        txtAck = ackView.findViewById(R.id.txtAck);
    }
}
