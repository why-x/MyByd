package com.example.master.byd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.AttestationAdapter;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AttestationActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.startr)
    TextView mStartr;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_attestation;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("刷脸认证－房屋交易在线登记");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        AttestationAdapter attestationAdapter = new AttestationAdapter(MyApp.getContext());
        mRecyclerView.setAdapter(attestationAdapter);
        myonclick();

    }

    private void myonclick() {
        mStartr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), Attestation2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void destoryData() {

    }
}
