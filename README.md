# Android-RatingBar
Simple and fully customizable rating bar library with animations.


### Usage


#### Using XML
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

#### Using JAva code
MainActivity.java
```
ArkRatingBar ratingBar = (ArkRakingBar) findViewbyId(R.id.rate);

```
