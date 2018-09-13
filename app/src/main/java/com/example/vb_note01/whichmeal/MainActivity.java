package com.example.vb_note01.whichmeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int index = 1;
    int end_index = 9;
    private Spinner spinner;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner2);
        timer = new Timer();

        Button timerStartButton = (Button) findViewById(R.id.button5);

        timerStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                                        timer.cancel();
                                        timer = new Timer();
                                    }
                                }
                            });
                        }
                    }, 50, 500
                );
            }
        });
    }
}
