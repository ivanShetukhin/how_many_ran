package com.shet.ivo.appone;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //determine elements
    private TextView distance_total;
    private TextView time;
    private SeekBar seek_bar_time;
    private TextView speed;
    private SeekBar seek_bar_speed;

    //determine constants
    private static final String CUSTOM_TIME = "TIME";
    private static final String CUSTOM_SPEED = "SPEED";

    //determine custom variables
    private double custom_time;
    private double custom_speed;
    private double custom_distance_total;
    private int current_time;
    private int current_speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setElement();
        if (savedInstanceState == null)
        {
            custom_time = 0.0;
            custom_speed = 0.0;
        }
        else
        {
            custom_time = savedInstanceState.getDouble(CUSTOM_TIME);
            custom_speed = savedInstanceState.getInt(CUSTOM_SPEED);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putDouble(CUSTOM_TIME,current_time);
        outState.putDouble(CUSTOM_SPEED, current_speed);
    }

    private void setElement()
    {
        distance_total = (TextView) findViewById(R.id.distance_total);
        time = (TextView) findViewById(R.id.time);
        seek_bar_time = (SeekBar) findViewById(R.id.seek_bar_time);
        seek_bar_time.setOnSeekBarChangeListener(customSeekBarListenerTime);
        speed = (TextView) findViewById(R.id.speed);
        seek_bar_speed = (SeekBar) findViewById(R.id.seek_bar_speed);
        seek_bar_speed.setOnSeekBarChangeListener(customSeekBarListenerSpeed);
    }

    private void setTime()
    {
        time.setText(String.valueOf(custom_time));
        custom_distance_total = current_time * current_speed / 60;
        distance_total.setText(String.valueOf(custom_distance_total) + " km");
        time.setText(String.valueOf(current_time) + " min");
        speed.setText(String.valueOf(current_speed) + " km/h");
        //apsent listener for seek bar
    }

    private void setSpeed()
    {
        speed.setText(String.valueOf(custom_speed));
    }

    private SeekBar.OnSeekBarChangeListener customSeekBarListenerTime = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            current_time = seekBar.getProgress();
            setTime();

        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    private SeekBar.OnSeekBarChangeListener customSeekBarListenerSpeed = new SeekBar.OnSeekBarChangeListener()
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            current_speed = seekBar.getProgress() / 10;
            setTime();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
