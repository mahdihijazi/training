package com.training.listviewslab2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    EditText name, mobile;
    Button add;
    ContactsAdapter contactsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        mobile = (EditText) findViewById(R.id.mobile);
        add = (Button) findViewById(R.id.add);
        ListView listView = (ListView) findViewById(R.id.list);

        contactsAdapter = new ContactsAdapter(MainActivity.this);
        listView.setAdapter(contactsAdapter);
        listView.setOnItemLongClickListener(onItemLongClickListener);

        add.setOnClickListener(clickListener);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            contactsAdapter.addContact(new Contact(name.getText().toString(), mobile.getText().toString()));
            name.setText("");
            mobile.setText("");

        }
    };

    AdapterView.OnItemLongClickListener onItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            contactsAdapter.deleteContact(position);

            return true;
        }
    };


}
