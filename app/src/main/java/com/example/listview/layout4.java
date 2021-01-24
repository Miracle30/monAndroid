package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class layout4 extends AppCompatActivity {

    private int second=0;
    private boolean running; //check trạng thái của đồng hồ
    Button btnStart, btnStop, btnReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout4);
        addControls();
        addEvents();
        runTimer();
    }

    private void addControls() {
        btnStart = findViewById(R.id.btnStart);
        btnReset = findViewById(R.id.btnReset);
        btnStop = findViewById(R.id.btnStop);

    }

    private void addEvents() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true; // bắt đầu đồng hồ
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
                second = 0; //reset lại đồng hồ
            }
        });


    }

    private void runTimer() {
        final TextView time_view = findViewById(R.id.time_view);;
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = second/3600;
                int minutes = (second%3600)/60;
                int sec = second%60;
                String time = String.format("%d:%02d:%02d", hours,minutes,sec);
                time_view.setText(time);

                if(running){
                    second++;
                }
                //post lại code sau khi delay 1s
                handler.postDelayed(this, 1000);
            }
        });

    }
}