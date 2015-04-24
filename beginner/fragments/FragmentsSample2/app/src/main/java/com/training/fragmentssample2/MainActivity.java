package com.training.fragmentssample2;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        FragmentA fragment = new FragmentA();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(onClickListener);


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // Create new fragment and transaction
            FragmentB newFragment = new FragmentB();
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();

            // Replace whatever is in the fragment_container view with this
            // fragment,
            // and add the transaction to the back stack
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();

        }
    };



}
