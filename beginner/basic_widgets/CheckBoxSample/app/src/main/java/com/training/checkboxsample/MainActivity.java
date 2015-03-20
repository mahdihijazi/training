package com.training.checkboxsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private CheckBox iOSCheckBox, androidCheckBox, windowsCheckBox;
    private Button displayButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iOSCheckBox = (CheckBox) findViewById(R.id.iOSCheckBox);
        androidCheckBox = (CheckBox) findViewById(R.id.androidCheckBox);
        windowsCheckBox = (CheckBox) findViewById(R.id.windowsCheckBox);
        displayButton = (Button) findViewById(R.id.displayButton);

        iOSCheckBox.setOnClickListener(checkBoxListener);
        displayButton.setOnClickListener(buttonListener);

    }

    View.OnClickListener checkBoxListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            if (iOSCheckBox.isChecked()) {
                Toast.makeText(MainActivity.this,
                        "Bro, try Android :)", Toast.LENGTH_LONG).show();
            }

        }
    };

    View.OnClickListener buttonListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            StringBuffer result = new StringBuffer();

            result.append("IPhone check : ")
                    .append(iOSCheckBox.isChecked());

            result.append("\nAndroid check : ").append(
                    androidCheckBox.isChecked());

            result.append("\nWindows Mobile check :").append(
                    windowsCheckBox.isChecked());

            Toast.makeText(MainActivity.this, result.toString(),
                    Toast.LENGTH_LONG).show();

        }
    };

}
