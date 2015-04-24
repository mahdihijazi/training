package com.training.loginhomelab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class IntroActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Button btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(clickListener);

    }


    View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(IntroActivity.this, LoginActivity.class);
            startActivity(intent);

        }
    };

}
