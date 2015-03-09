package com.training.showmetime;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends ActionBarActivity {
    private TextView txvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvTime = (TextView) findViewById(R.id.timeTextView);

        Button btnShowTime = (Button) findViewById(R.id.timeButton);
        btnShowTime.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            String time = sdf.format(new Date());
            txvTime.setText(time);

        }
    };
}
