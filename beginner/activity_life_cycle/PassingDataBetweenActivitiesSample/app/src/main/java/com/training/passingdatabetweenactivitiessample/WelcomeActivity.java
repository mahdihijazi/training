package com.training.passingdatabetweenactivitiessample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class WelcomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        TextView textView = (TextView) findViewById(R.id.welcome_me);
        textView.setText("Welcome " + getIntent().getStringExtra("name"));

    }
}
