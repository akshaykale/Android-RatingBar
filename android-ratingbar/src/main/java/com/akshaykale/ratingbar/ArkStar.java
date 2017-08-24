package com.akshaykale.ratingbar;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by akshay.kale on 24/08/2017.
 */

public class ArkStar extends RelativeLayout {

    ImageView imageView;
    LinearLayout linearLayout;

    public ArkStar(Context context) {
        super(context);
    }

    public ArkStar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ArkStar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setupStar(){

    }

    /*Make it square based on the height of the parent view*/
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);
    }
}
