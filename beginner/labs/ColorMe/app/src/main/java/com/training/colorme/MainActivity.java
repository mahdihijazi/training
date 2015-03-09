package com.training.colorme;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.root);

        Button btnRed = (Button) findViewById(R.id.redButton);
        btnRed.setOnClickListener(buttonsHandler);

        // TODO: Complete the sample to switch the colors to blue & green
    }

    View.OnClickListener buttonsHandler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id) {
                case R.id.redButton:
                    rootView.setBackgroundColor(Color.RED);

                    break;

            }

        }
    };

}
