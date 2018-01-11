package com.telran.mishpahug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class EventViewDone extends AppCompatActivity {
    private static final String TAG = "myLog";

    TextView title, text;
    RatingBar rating;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_view_done);

        rating = findViewById(R.id.rating);
        image = findViewById(R.id.image);
        title = findViewById(R.id.title);//title
        title.setText(R.string.title);

        text = findViewById(R.id.text);
        text.setText(R.string.text);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float value, boolean fromUser) {
                Toast.makeText(EventViewDone.this, "your mark is " + String.valueOf(value),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        float result = rating.getRating();//куда-то это надо отправить...
        super.onBackPressed();
    }
}
