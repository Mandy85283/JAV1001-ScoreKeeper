package com.Mandeep.singh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
//import android.view.View;
import android.os.CountDownTimer;
import android.provider.CallLog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  {
    private static final long START_TIME_IN_MILLIS = 1200000;
    private TextView TextViewCountDown;
    private Button ButtonStartPause;
    private Button ButtonReset;
    private CountDownTimer CountDownTimer;
    private boolean TimerRunning;
    private long TimeLeftInMillies = START_TIME_IN_MILLIS;

    SwitchCompat switchCompat;

    TextView Score1,Score2;
    Button incscore1,incscore2,decscore1,decscore2;
    int score1 = 0;
    int score2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Dark);
        }else{
            setTheme(R.style.Theme_Light);
        }
        setContentView(R.layout.activity_main);
        Score1 = findViewById(R.id.Score1);
        incscore1 = findViewById(R.id.incscore1);
        Score1.setText(String.valueOf(score1));
        incscore1.setOnClickListener(view -> {
            score1++;
            Score1.setText(String.valueOf(score1));

        });
        Score2 = findViewById(R.id.Score2);
        incscore2 = findViewById(R.id.incscore2);
        Score2.setText(String.valueOf(score2));
        incscore2.setOnClickListener(view -> {
            score2++;
            Score2.setText(String.valueOf(score2));
        });
        Score1 = findViewById(R.id.Score1);
        decscore1 = findViewById(R.id.decscore1);
        decscore1.setOnClickListener(view -> {
            score1--;
            Score1.setText(String.valueOf(score1));
        });
        Score2 = findViewById(R.id.Score2);
        decscore2 = findViewById(R.id.decscore2);
        decscore2.setOnClickListener(view -> {
            score2--;
            Score2.setText(String.valueOf(score2));
        });
        switchCompat=findViewById(R.id.theme);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
        TextViewCountDown = findViewById(R.id.countdown);
        ButtonStartPause = findViewById(R.id.start_pause);
        ButtonReset = findViewById(R.id.reset);
        ButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TimerRunning){
                    pauseTimer();
                }else{
                    startTimer();
                }
            }
        });
        ButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }
    private void startTimer(){
        CountDownTimer = new CountDownTimer(TimeLeftInMillies,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TimeLeftInMillies = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                TimerRunning = false;
                ButtonStartPause.setText("Start");
                ButtonStartPause.setVisibility(View.INVISIBLE);
                ButtonReset.setVisibility(View.VISIBLE);

            }
        }.start();
        TimerRunning = true;
        ButtonStartPause.setText("pause");
        ButtonReset.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer(){
        CountDownTimer.cancel();
        TimerRunning = false;
        ButtonStartPause.setText("start");
        ButtonReset.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        TimeLeftInMillies = START_TIME_IN_MILLIS;
        updateCountDownText();
        ButtonReset.setVisibility(View.INVISIBLE);
        ButtonStartPause.setVisibility(View.VISIBLE);
    }
    private void updateCountDownText(){
        int minutes = (int) (TimeLeftInMillies / 1000) /60;
        int seconds = (int) (TimeLeftInMillies / 1000) %60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        TextViewCountDown.setText(timeLeftFormatted);
    }
}
