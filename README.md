# Android-RatingBar
Simple and fully customizable rating bar library with animations.


## Usage

<br>
### Using XML

activity_main.xml
```
 <com.akshaykale.ratingbar.ArkRatingBar
            android:id="@+id/rate"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:num_stars="5"
            app:animation="true"
            />
 ```
#### XML arrtibutes <br>

| Attributes | Usage |
|---|---|
|```app:num_stars```|Number of stars|
|```app:rating```|Default rating|
|```app:fill_colour_active```| Star fill colour when it is selected or active|
|```app:fill_colour_inactive```| Star fill colour when it is deselected or inactive|
|```app:stroke_colour_active```| Star Strike colour when it is selected or active|
|```app:stroke_colour_inactive```| Star Strike colour when it is deselected or inactive|
|```app:stroke_size```| Stroke size|
|```app:animation```|Star click animation|

<br><br>
### Using Java code
MainActivity.java
```
ArkRatingBar ratingBar = (ArkRakingBar) findViewbyId(R.id.rate);

```


