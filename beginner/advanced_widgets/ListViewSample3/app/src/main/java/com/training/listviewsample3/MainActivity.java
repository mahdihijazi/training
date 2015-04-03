package com.training.listviewsample3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Contact[] contacts = new Contact[3];
        contacts[0] = new Contact("Nurik", R.drawable.nurik);
        contacts[1] = new Contact("Matias", R.drawable.matias);
        contacts[2] = new Contact("Nick", R.drawable.nick);

        ListView lsvContacts = (ListView) findViewById(R.id.list);
        ContactsAdapter adapter = new ContactsAdapter(MainActivity.this,
                contacts);
        lsvContacts.setAdapter(adapter);
    }


}
