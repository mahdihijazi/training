package com.training.radiobuttonsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private RadioGroup genderRadioGroup;
    private RadioButton genderRadioButton;
    private Button displaySelectedOptionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        genderRadioGroup = (RadioGroup) findViewById(R.id.genderRadioGroup);
        displaySelectedOptionButton = (Button) findViewById(R.id.displaySelectedOptionButton);
        displaySelectedOptionButton.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            // get selected radio button from radioGroup
            int selectedId = genderRadioGroup.getCheckedRadioButtonId();

            // find the radiobutton by returned id
            genderRadioButton = (RadioButton) findViewById(selectedId);

            Toast.makeText(MainActivity.this,
                    genderRadioButton.getText(), Toast.LENGTH_SHORT).show();

        }

    };

}
