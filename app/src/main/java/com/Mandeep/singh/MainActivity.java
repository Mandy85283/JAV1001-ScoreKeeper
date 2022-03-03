package com.Mandeep.singh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Score1,Score2;
    Button incscore1,incscore2,decscore1,decscore2;
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Score1 =  findViewById(R.id.Score1);
        incscore1 = findViewById(R.id.incscore1);
        Score1.setText(String.valueOf(score));
        incscore1.setOnClickListener(view -> {
                score++;
                Score1.setText(String.valueOf(score));

        });
        Score2 =  findViewById(R.id.Score2);
        incscore2 = findViewById(R.id.incscore2);
        Score2.setText(String.valueOf(score));
        incscore2.setOnClickListener(view -> {
                score++;
                Score2.setText(String.valueOf(score));
        });
        Score1 = findViewById(R.id.Score1);
        decscore1 =  findViewById(R.id.decscore1);
        decscore1.setOnClickListener(view -> {
                score--;
                Score1.setText(String.valueOf(score));
        });
        Score2 =  findViewById(R.id.Score2);
        decscore2 =  findViewById(R.id.decscore2);
        decscore2.setOnClickListener(view -> {
                score--;
                Score2.setText(String.valueOf(score));
        });
    }
}