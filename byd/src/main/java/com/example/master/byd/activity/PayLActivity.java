package com.example.master.byd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.PayIAdapter;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class PayLActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.pay)
    TextView mPay;
    @BindView(R.id.rtn1)
    RadioButton mRtn1;
    @BindView(R.id.rtn2)
    RadioButton mRtn2;
    @BindView(R.id.rtn3)
    RadioButton mRtn3;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_l;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("在线缴费");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        PayIAdapter payIAdapter = new PayIAdapter(MyApp.getContext());
        mRecyclerView.setAdapter(payIAdapter);
        myonclick();
    }

    @Override
    protected void destoryData() {

    }

    private void myonclick() {
        mPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PayLActivity.this, "支付成功！！！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyApp.getContext(), SellFinshActivity.class);
                startActivity(intent);
                finish();


            }
        });

        mRtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRtn1.setChecked(true);
                mRtn2.setChecked(false);
                mRtn3.setChecked(false);

            }
        });
        mRtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRtn2.setChecked(true);
                mRtn1.setChecked(false);
                mRtn3.setChecked(false);

            }
        });
        mRtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRtn3.setChecked(true);
                mRtn1.setChecked(false);
                mRtn2.setChecked(false);

            }
        });

    }

}
