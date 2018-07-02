package com.nabinbhandari.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SwipeButton swipeButton = findViewById(R.id.swipeBtn);
        final TextView textView = findViewById(R.id.textView);

        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                textView.setText(/*active*/swipeButton.isActive() ? "Active" : "Inactive");
            }
        });
    }

}
