package com.example.vb_note01.whichmeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int index = 0;
    int end_index = 8;
    int role_count;
    int hit_number;
    private Spinner spinner;
    private Timer timer;
    private Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner2);
        timer = new Timer();
        r = new Random();

        Button timerStartButton = (Button) findViewById(R.id.button5);

        timerStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                role_count = 0;
                hit_number = r.nextInt(9);
                timer.scheduleAtFixedRate(
                    new TimerTask()
                    {
                        @Override
                        public void run()
                        {
                            MainActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    spinner.setSelection(index);
                                    index++;
                                    if( index == end_index ){
                                        role_count++;
                                        index = 0;
                                    }
                                    if( role_count == 3 && hit_number == index ){
                                        timer.cancel();
                                        timer = new Timer();
                                    }
                                }
                            });
                        }
                    }, 50, 200
                );
            }
        });
    }
}
