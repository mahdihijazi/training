package com.training.spinnerssample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.typeSpinners);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types, android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(spinnerListsner);

    }


    AdapterView.OnItemSelectedListener spinnerListsner = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, (CharSequence) parent.getItemAtPosition(position), Toast.LENGTH_LONG).show();

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(MainActivity.this, "Nothing is selected", Toast.LENGTH_LONG).show();
        }
    };

}
