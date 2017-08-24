package com.akshaykale.ratingbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by akshay.kale on 24/08/2017.
 */

public class ArkRatingBar extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.addView(new SquareLinearLayout(getContext()));
        linearLayout.addView(new SquareLinearLayout(getContext()));
        linearLayout.addView(new SquareLinearLayout(getContext()));
        linearLayout.addView(new SquareLinearLayout(getContext()));
        linearLayout.addView(new SquareLinearLayout(getContext()));
        return linearLayout;
    }


}
