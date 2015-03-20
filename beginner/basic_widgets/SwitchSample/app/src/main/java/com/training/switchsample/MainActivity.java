package com.training.switchsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView switchStatus;
    Switch mySwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchStatus = (TextView) findViewById(R.id.switchStatus);
        mySwitch = (Switch) findViewById(R.id.mySwitch);

        //set the switch to ON
        mySwitch.setChecked(true);
        //attach a listener to check for changes in state
        mySwitch.setOnCheckedChangeListener(switchListener);

    }

    CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {

            if(isChecked){
                switchStatus.setText("Switch is currently ON");
            }else{
                switchStatus.setText("Switch is currently OFF");
            }

        }
    };

}
