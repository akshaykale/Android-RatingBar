package com.akshaykale.ratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by akshay.kale on 24/08/2017.
 */

public class ArkRatingBar extends LinearLayout implements View.OnClickListener, IStarClickListener {

    int current_rating = 0;
    int num_stars = 5;

    ArrayList<ArkStar> stars = new ArrayList<>();

    public ArkRatingBar(Context context) {
        super(context);
        init();
    }

    public ArkRatingBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ArkRatingBar,
                0, 0);
        try {
            current_rating = typedArray.getInteger(R.styleable.ArkRatingBar_rating, 0);
            num_stars = typedArray.getInteger(R.styleable.ArkRatingBar_num_stars, 5);
            ArkRatingBarConfig.setColourFillStarActive(typedArray.getColor(R.styleable.ArkRatingBar_fill_colour_active,getResources().getColor(R.color.fill_colour_active)));
            ArkRatingBarConfig.setColourFillStarInactive(typedArray.getColor(R.styleable.ArkRatingBar_fill_colour_inactive,getResources().getColor(R.color.fill_colour_inactive)));
            ArkRatingBarConfig.setColourStrokeStarActive(typedArray.getColor(R.styleable.ArkRatingBar_stroke_colour_active,getResources().getColor(R.color.stroke_colour_active)));
            ArkRatingBarConfig.setColourStrokeStarInactive(typedArray.getColor(R.styleable.ArkRatingBar_stroke_colour_inactive,getResources().getColor(R.color.stroke_colour_inactive)));
            ArkRatingBarConfig.setSizeStrokeStar(typedArray.getInteger(R.styleable.ArkRatingBar_stroke_size,0));
        } finally {
            typedArray.recycle();
        }
        init();
    }

    public ArkRatingBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ArkRatingBar,
                0, 0);
        try {
            current_rating = typedArray.getInteger(R.styleable.ArkRatingBar_rating, 0);
            num_stars = typedArray.getInteger(R.styleable.ArkRatingBar_num_stars, 5);
            ArkRatingBarConfig.setColourFillStarActive(typedArray.getColor(R.styleable.ArkRatingBar_fill_colour_active,getResources().getColor(R.color.fill_colour_active)));
            ArkRatingBarConfig.setColourFillStarInactive(typedArray.getColor(R.styleable.ArkRatingBar_fill_colour_inactive,getResources().getColor(R.color.fill_colour_inactive)));
            ArkRatingBarConfig.setColourStrokeStarActive(typedArray.getColor(R.styleable.ArkRatingBar_stroke_colour_active,getResources().getColor(R.color.stroke_colour_active)));
            ArkRatingBarConfig.setColourStrokeStarInactive(typedArray.getColor(R.styleable.ArkRatingBar_stroke_colour_inactive,getResources().getColor(R.color.stroke_colour_inactive)));
            ArkRatingBarConfig.setSizeStrokeStar(typedArray.getInteger(R.styleable.ArkRatingBar_stroke_size,0));
        } finally {
            typedArray.recycle();
        }
        init();
    }

    public void init(){
        //clear view
        this.removeAllViewsInLayout();
        //Add num stars
        for (int i=0;i<=num_stars;i++){
            ArkStar star = new ArkStar(getContext());
            star.NUM = i;
            stars.add(i, star);
            star.setClickListener(this);
            //skip the first star at 0th index
            if (i!=0)
                this.addView(star);
        }

    }


    @Override
    public void onClick(View view) {
        ArkStar arkStar = (ArkStar) view;
        int N = arkStar.NUM;
        current_rating = N;
        //set active untill N
        int i = 0;
        for (i=1;i<=N;i++){
            stars.get(i).setActive();
        }
        //set inactive after N
        //i++;
        for (;i<=num_stars;i++){
            stars.get(i).setInActive();
        }

        //Toast.makeText(getContext(),"Rating:"+getRating(), Toast.LENGTH_SHORT).show();
    }


    public int getRating() {
        return current_rating ;//== 0 ? current_rating :current_rating+1;
    }
    public void setRating(int rating) {
        if (rating<=0){
            current_rating = 0;
            for (int i=1;i<=num_stars;i++){
                stars.get(i).setInActive();
            }
            return;
        }else if (rating>num_stars){
            rating = num_stars;
        }
        this.current_rating = rating;// == 0?0:current_rating;
        for (int i=1;i<=rating;i++){
            stars.get(i).performClick();
        }

    }
    public int getNumstars() {
        return num_stars;
    }
    public void setNumStars(int max_stars) {
        this.num_stars = max_stars;
    }


    @Override
    public void onStarClicked(View view, int NUM) {
        ArkStar arkStar = (ArkStar) view;
        int N = arkStar.NUM;
        current_rating = N;
        //set active untill N
        int i = 0;
        for (i=1;i<=N;i++){
            stars.get(i).setActive();
            stars.get(i).animate();
        }
        //set inactive after N
        //i++;
        for (;i<=num_stars;i++){
            stars.get(i).setInActive();
        }
    }
}
