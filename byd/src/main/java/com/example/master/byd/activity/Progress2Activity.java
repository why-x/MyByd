package com.example.master.byd.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class Progress2Activity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.fre)
    TextView mFre;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_progress2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("进度查询");
        mFre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void destoryData() {

    }

}
