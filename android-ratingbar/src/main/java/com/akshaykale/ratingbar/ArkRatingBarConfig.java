package com.akshaykale.ratingbar;

/**
 * Created by akshay.kale on 24/08/2017.
 */

public class ArkRatingBarConfig {

    public static int COLOUR_FILL_STAR_ACTIVE = R.color.fill_colour_active;//"#dd9609";
    public static int COLOUR_FILL_STAR_INACTIVE = R.color.fill_colour_inactive;//"#FFA5A5A5";

    public static int COLOUR_STROKE_STAR_ACTIVE = R.color.stroke_colour_active;//"#000000";
    public static int COLOUR_STROKE_STAR_INACTIVE = R.color.stroke_colour_inactive;//"#000000";

    public static int SIZE_STROKE_STAR = 0;

    public static boolean STAR_ANIMATION = true;



    public static int getColourFillStarActive() {
        return COLOUR_FILL_STAR_ACTIVE;
    }

    public static void setColourFillStarActive(int colourFillStarActive) {
        COLOUR_FILL_STAR_ACTIVE = colourFillStarActive;
    }

    public static int getColourFillStarInactive() {
        return COLOUR_FILL_STAR_INACTIVE;
    }

    public static void setColourFillStarInactive(int colourFillStarInactive) {
        COLOUR_FILL_STAR_INACTIVE = colourFillStarInactive;
    }

    public static int getColourStrokeStarActive() {
        return COLOUR_STROKE_STAR_ACTIVE;
    }

    public static void setColourStrokeStarActive(int colourStrokeStarActive) {
        COLOUR_STROKE_STAR_ACTIVE = colourStrokeStarActive;
    }

    public static int getColourStrokeStarInactive() {
        return COLOUR_STROKE_STAR_INACTIVE;
    }

    public static void setColourStrokeStarInactive(int colourStrokeStarInactive) {
        COLOUR_STROKE_STAR_INACTIVE = colourStrokeStarInactive;
    }

    public static boolean isStarAnimation() {
        return STAR_ANIMATION;
    }

    public static void setStarAnimation(boolean starAnimation) {
        STAR_ANIMATION = starAnimation;
    }


    public static int getSizeStrokeStar() {
        return SIZE_STROKE_STAR;
    }

    public static void setSizeStrokeStar(int sizeStrokeStar) {
        SIZE_STROKE_STAR = sizeStrokeStar;
    }


}
