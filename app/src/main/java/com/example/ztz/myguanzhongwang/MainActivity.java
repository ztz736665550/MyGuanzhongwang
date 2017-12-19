package com.example.ztz.myguanzhongwang;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.ztz.myguanzhongwang.activity.HomeActivity;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉状态栏
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        intent = new Intent(MainActivity.this, HomeActivity.class);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                date();
                finish();
            }
        };
        timer.schedule(task, 3 * 1000);//此处的Delay可以是3*1000，代表三秒
    }
    private void date() {
        //Intent in=new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}