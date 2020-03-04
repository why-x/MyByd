package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.util.CustomDigitalClock;
import com.example.myapplication.util.GoodsDetailTimerView;
import com.example.myapplication.util.RushBuyCountDownTimerView;

public class Main3Activity extends AppCompatActivity {

    CustomDigitalClock tv_time;
    private RushBuyCountDownTimerView timerView;
    private GoodsDetailTimerView timerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        timerView = (RushBuyCountDownTimerView) findViewById(R.id.timerView);
//        // ÉčÖĂĘąźä(hour,min,sec)
//        timerView.setTime(10, 0, 10);
//        // żŞĘźľšźĆĘą
//        timerView.start();

        timerView1 = findViewById(R.id.lay_timerview);
        timerView1.setTime(1, 2, 20, 50);// 设置时间(day,hour,min,sec)
        timerView1.start();// 开始倒计时
    }
}
