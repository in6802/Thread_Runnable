package com.example.edu.thread_runnable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ProgressBar progressBarPost;
    Button buttonRun;
    private int progressBarStatus = 0;
    TextView textViewProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBarPost = findViewById(R.id.progressBarPost);
        textViewProgress = findViewById(R.id.textViewProgress);
        buttonRun = findViewById(R.id.buttonRun);
        buttonRun.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new Thread(new Runnable(){//Runnable을 Thread로 감싸줌. 큐에 올리기 위해서
            @Override
            public void run() {
                while (progressBarStatus < 100) {
                    try {
                        Thread.sleep(1000);//시간을 주는 것
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    progressBarStatus++;
                    progressBarPost.post(new Runnable() {//post()는 runnuble을 큐에 싣고
                        @Override
                        public void run() { // run() 동작명세서를 만들어줌
                            progressBarPost.setProgress(progressBarStatus);
                            textViewProgress.setText(String.valueOf(progressBarStatus) + "%");
                        }
                    });
                }
            }
        }).start();//Thread를 동작시키기 위해서 꼭해줘야함.
    }
}
