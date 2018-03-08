package com.example.bryan.singletoneleakmemory;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.leakcanary.LeakCanary;

public class LeakTHRA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_thr);
        LeakCanary.install(getApplication());
        new Thread(new Run()).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(200000);
//            }
//        }).start();
    }
    private static class  Run implements Runnable{

        @Override
        public void run() {
            SystemClock.sleep(20000);
            }
    }
}
