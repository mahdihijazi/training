package com.training.listviewsample2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Contact[] contacts = new Contact[3];
        contacts[0] = new Contact("Nurik");
        contacts[1] = new Contact("Matias");
        contacts[2] = new Contact("Nick");

        ListView lsvContacts = (ListView) findViewById(R.id.list);
        lsvContacts.setAdapter(new ArrayAdapter<Contact>(this, R.layout.row, R.id.name, contacts));

    }

}
