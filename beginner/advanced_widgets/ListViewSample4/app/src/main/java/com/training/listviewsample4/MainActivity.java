package com.training.listviewsample4;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Nurik", R.drawable.nurik));
        contacts.add(new Contact("Matias", R.drawable.matias));
        contacts.add(new Contact("Nick", R.drawable.nick));

        ListView lsvContacts = (ListView) findViewById(R.id.list);
        ContactsAdapter adapter = new ContactsAdapter(MainActivity.this,
                contacts);
        lsvContacts.setAdapter(adapter);
    }

}
