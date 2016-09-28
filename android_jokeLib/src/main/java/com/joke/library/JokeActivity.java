package com.joke.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView tv;
    public static final String INTENT_ID = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        tv = (TextView)findViewById(R.id.textView);
        tv.setText(getIntent().getStringExtra(INTENT_ID));
    }
}
