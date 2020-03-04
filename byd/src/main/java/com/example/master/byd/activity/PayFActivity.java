package com.example.master.byd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.PayIAdapter;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class PayFActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.editText)
    EditText mEditText;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.imageView1)
    ImageView mImageView1;
    @BindView(R.id.pay)
    TextView mPay;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_f;
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

    private void myonclick() {
        mPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PayFActivity.this, "下单成功！！！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MyApp.getContext(), PayLActivity.class);
                startActivity(intent);

            }
        });


    }

    @Override
    protected void destoryData() {

    }

}
