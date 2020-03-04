package com.example.master.byd.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class AppMessActivity extends BaseActivity {


    @BindView(R.id.freturn)
    ImageView mFreturn;
    @BindView(R.id.set)
    TextView mSet;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_app_mess;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mFreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void destoryData() {

    }
}
