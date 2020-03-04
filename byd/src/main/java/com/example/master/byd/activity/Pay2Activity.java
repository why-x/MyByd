package com.example.master.byd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class Pay2Activity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.fre)
    TextView mFre;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("在线缴费－房屋交易在线登记");
        myonclick();

    }

    private void myonclick() {
        mFre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), Complete2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void destoryData() {

    }


}
