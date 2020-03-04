package com.example.master.byd.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 协议
 */
public class AgreementActivity extends BaseActivity {

    @BindView(R.id.cancle)
    TextView mCancle;
    @BindView(R.id.agree)
    TextView mAgree;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_agreement;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
