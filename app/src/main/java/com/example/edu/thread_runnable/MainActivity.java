package com.example.edu.thread_runnable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar progressBar;
    Button buttonRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBarPost);
        buttonRun = findViewById(R.id.buttonRun);
        buttonRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


    }
}
