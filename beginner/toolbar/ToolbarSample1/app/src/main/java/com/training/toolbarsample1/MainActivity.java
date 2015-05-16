package com.training.toolbarsample1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                Toast.makeText(this, "About", Toast.LENGTH_LONG).show();

                return true;

            case R.id.action_refresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_LONG).show();

                return true;

            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();

                return true;

        }

        return super.onOptionsItemSelected(item);
    }
}
