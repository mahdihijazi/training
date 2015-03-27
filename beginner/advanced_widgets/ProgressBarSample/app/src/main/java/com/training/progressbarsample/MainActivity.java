package com.training.progressbarsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {
    int myProgress = 0;
    ProgressBar myProgressBar;
    Button startButton;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myProgressBar = (ProgressBar) findViewById(R.id.progressbar_Horizontal);
        startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startLongWorkingProcess();
            }
        });

    }

    private void startLongWorkingProcess() {
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask,
                0,
                100);

    }

    private TimerTask timerTask = new TimerTask() {

        @Override
        public void run() {
            myProgress++;

            if(myProgress> 100) {
                timer.cancel();
            } else {

                runOnUiThread(new Runnable() {
                    public void run() {
                        myProgressBar.setProgress(myProgress);
                    }
                });
            }
        }

    };

}
