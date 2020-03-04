package com.example.master.byd.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class OnSellerActivity extends BaseActivity {
    @BindView(R.id.freturn)
    TextView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.pay11)
    TextView pay11;
    @BindView(R.id.pay22)
    TextView pay22;
    @BindView(R.id.pay2)
    TextView pay2;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_on_seller;
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
        myonclick();
    }

    private void myonclick() {
        pay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(SKMessageActivity.class);
            }
        });

    }

    @Override
    protected void destoryData() {

    }

}
