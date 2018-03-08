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
        // install  leak canary
        LeakCanary.install(getApplication());
        // leak gone by static inner class.
        new Thread(new Run()).start();
        // leak by non static inner class.
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SystemClock.sleep(200000);
//            }
//        }).start();
    }

    // static inner class.
    private static class  Run implements Runnable{

        @Override
        public void run() {
            SystemClock.sleep(20000);
            }
    }
}
