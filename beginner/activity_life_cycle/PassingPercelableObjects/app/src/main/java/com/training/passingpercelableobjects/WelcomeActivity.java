package com.training.passingpercelableobjects;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class WelcomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Contact contact = getIntent().getParcelableExtra("contact");

        TextView textView = (TextView) findViewById(R.id.welcome_me);
        textView.setText("Name: " + contact.name + "\nMobile: "
                + contact.mobile);

    }
}
