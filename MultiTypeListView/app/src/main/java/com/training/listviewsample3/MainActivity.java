package com.training.listviewsample3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Object[] items = new Object[5];
		items[0] = new Separator("N");
		items[1] = new Contact("Nurik", R.drawable.nurik);
		items[2] = new Contact("Nick", R.drawable.nick);
		items[3] = new Separator("M");
		items[4] = new Contact("Matias", R.drawable.matias);

		ListView lsvContacts = (ListView) findViewById(R.id.list);
		ContactsAdapter adapter = new ContactsAdapter(this, items);
		lsvContacts.setAdapter(adapter);

	}

}
