package com.example.bryan.singletoneleakmemory;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.leakcanary.LeakCanary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LeakCanary.install(getApplication());
        MySingleton.getInstance(MainActivity.this).doSomeThing();
    }

    public static class MySingleton  {

        private static   MySingleton instance;
        private Context context;

        public static MySingleton getInstance(Context context) {
            if (instance == null) {
                // context của activity hiện tại bị giữ.
//                instance = new MySingleton(context);
                //context.getApplicationContext() => context of App.
                instance = new MySingleton(context.getApplicationContext());
            }
            return instance;
        }

        private MySingleton(final Context context) {
            this.context = context;
        }
        private void doSomeThing(){
            int a=3;
        }
    }

}
