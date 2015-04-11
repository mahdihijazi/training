package com.training.passingpercelableobjects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    EditText nameEditBox, mobileEditBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditBox = (EditText) findViewById(R.id.name);
        mobileEditBox = (EditText) findViewById(R.id.mobile);

        Button showDataButton = (Button) findViewById(R.id.show_data);
        showDataButton.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Contact contact = new Contact(nameEditBox.getText().toString(),
                    mobileEditBox.getText().toString());

            Intent intent = new Intent(MainActivity.this,
                    WelcomeActivity.class);
            intent.putExtra("contact", contact);
            startActivity(intent);

        }
    };


}
