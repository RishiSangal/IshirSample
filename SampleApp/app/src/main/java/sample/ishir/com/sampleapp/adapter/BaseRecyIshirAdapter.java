package sample.ishir.com.sampleapp.adapter;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import sample.ishir.com.sampleapp.Utils.IcommIntent;
import sample.ishir.com.sampleapp.activity.BaseActivity;


/**
 * Created by Rishi.Sangal on 11/7/2016.
 *
 * @param <VH> the type parameter
 */
public abstract class BaseRecyIshirAdapter<VH extends RecyclerView.ViewHolder> extends
        RecyclerView.Adapter<VH> implements IcommIntent {


    /**
     * The Activity.
     */
    Activity activity_;

    /**
     * Instantiates a new Base smart adapter.
     *
     * @param activity the activity
     */
    public BaseRecyIshirAdapter(Activity activity) {
        activity_ = activity;
    }

    /**
     * Get smart activity base smart activity.
     *
     * @return the base smart activity
     */
    public BaseActivity GetActivity(){
        return (BaseActivity)activity_;
    }
    @Override
    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType) ;

    @Override
    public abstract void onBindViewHolder(VH holder, int position);

    @Override
    public abstract int getItemCount() ;

    /**
     * Set type face.
     *
     * @param textView the text view
     */
    public void setTypeFace(TextView textView){
        Typeface type = Typeface.createFromAsset(activity_.getAssets(), "Myriad_Pro.ttf");
        textView.setTypeface(type);
    }
}
