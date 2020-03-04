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
import butterknife.ButterKnife;

public class PayHouseActivity extends BaseActivity {


    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.pay11)
    TextView mPay11;
    @BindView(R.id.pay22)
    TextView mPay22;
    @BindView(R.id.pay1)
    TextView mPay1;
    @BindView(R.id.pay2)
    TextView mPay2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_house;
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
        mPay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPay1.setVisibility(View.GONE);
                mPay11.setVisibility(View.GONE);
                mPay2.setVisibility(View.VISIBLE);
                mPay22.setVisibility(View.VISIBLE);
            }
        });
        mPay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), Pay2Activity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void destoryData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
