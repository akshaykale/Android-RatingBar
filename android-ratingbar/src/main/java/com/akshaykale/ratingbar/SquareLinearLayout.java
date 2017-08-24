package com.akshaykale.ratingbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by akshay.kale on 24/08/2017.
 */

public class SquareLinearLayout extends LinearLayout implements View.OnClickListener {

    boolean bActive = false;
    ImageView imageView;

    public SquareLinearLayout(Context context) {
        super(context);
        init();
    }

    public SquareLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SquareLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);
    }


    private void init() {
        //setup the Fill layout
        this.setOrientation(HORIZONTAL);
        this.setBackgroundResource(R.drawable.ark_rounded_corners_10);
        this.setPadding(10,10,10,10);

        imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.ico_star_96);

        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
        );
        params.setMargins(3, 5, 3, 5);
        this.setLayoutParams(params);

        this.addView(imageView);

        setFillColour(ArkRatingBarConfig.getColourFillStarInactive(),
                ArkRatingBarConfig.getColourStrokeStarInactive(),
                ArkRatingBarConfig.getSizeStrokeStarInactive());

        this.setOnClickListener(this);
        //setFill(0.5f);
    }

    /**
     * @param colourFillStar
     * @param colourStrokeStar
     * @param sizeStrokeStar
     * */
    public void setFillColour(String colourFillStar, String colourStrokeStar, int sizeStrokeStar){
        Drawable fillDrawable = getBackground();
        if (fillDrawable instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) fillDrawable;
            gradientDrawable.setColor(Color.parseColor(colourFillStar));
            gradientDrawable.setStroke(sizeStrokeStar,Color.parseColor(colourStrokeStar));
        }
    }

    public void setCornerRadius(int radius){
        Drawable fillDrawable = getBackground();
        if (fillDrawable instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) fillDrawable;
            gradientDrawable.setCornerRadius(radius);
        }
    }

    public void setStarPadding(int padding){
        this.setPadding(padding,padding,padding,padding);
    }

    public void setFill(float fill){
        LinearLayout.LayoutParams layoutParams = (LayoutParams) new LayoutParams(0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                fill);
        //layoutParams.weight = fill;
        setLayoutParams(layoutParams);
    }

    public void setFillStroke(String fill, String stroke){
        Drawable fillDrawable = getBackground();
        if (fillDrawable instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) fillDrawable;
            gradientDrawable.setColor(Color.parseColor(fill));
            gradientDrawable.setStroke(1,Color.parseColor(stroke));
        }
    }

    public void toggleStar(){
        bActive = !bActive;
        if (bActive){
            setFillColour(ArkRatingBarConfig.getColourFillStarActive(),
                    ArkRatingBarConfig.getColourStrokeStarActive(),
                    ArkRatingBarConfig.getSizeStrokeStarActive());
        }else {
            setFillColour(ArkRatingBarConfig.getColourFillStarInactive(),
                    ArkRatingBarConfig.getColourStrokeStarInactive(),
                    ArkRatingBarConfig.getSizeStrokeStarInactive());
        }
    }

    public boolean isActive(){
        return bActive;
    }


    @Override
    public void onClick(View view) {
        //toggle the star state
        toggleStar();
        //animate the star
        Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.start_bounce_animation);
        // Use bounce interpolator with amplitude 0.2 and frequency 20
        ArkBounceInterpolator interpolator = new ArkBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        imageView.startAnimation(myAnim);

    }
}
