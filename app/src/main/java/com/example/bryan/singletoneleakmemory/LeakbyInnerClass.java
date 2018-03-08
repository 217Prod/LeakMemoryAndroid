package com.example.bryan.singletoneleakmemory;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.leakcanary.LeakCanary;

import java.lang.ref.WeakReference;


public class LeakbyInnerClass extends AppCompatActivity {

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
     // use weak reference to keep context.

     private static class MyRunnable implements Runnable {
         private WeakReference activityWeakReference;

         public MyRunnable(Activity activity) {
             activityWeakReference = new WeakReference<>(activity);
         }
         @Override
         public void run() {
             SystemClock.sleep(20000);
             Activity activity = (Activity) activityWeakReference.get();
             if (activity != null) {
                 doSomething(activity);
             }
         }

         private void doSomething(Activity activity) {

         }
     }
}
