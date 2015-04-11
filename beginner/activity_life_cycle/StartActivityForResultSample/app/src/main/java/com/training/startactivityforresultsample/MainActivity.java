package com.training.startactivityforresultsample;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private static final int REQUEST_CODE_PICK_CAR = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPick = (Button) findViewById(R.id.pick);
        btnPick.setOnClickListener(clickListener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_PICK_CAR) {
                Toast.makeText(MainActivity.this,
                        "You picked: " + data.getStringExtra("car"),
                        Toast.LENGTH_SHORT).show();

            }
        }
    }

    View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,
                    CarPickerActivity.class);
            startActivityForResult(intent, REQUEST_CODE_PICK_CAR);

        }
    };



}
