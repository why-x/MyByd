package com.example.master.byd.activity.advance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.activity.SellFinshActivity;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class AdvHouse2Activity extends BaseActivity {

    @BindView(R.id.freturn)
    TextView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.pay11)
    TextView pay11;
    @BindView(R.id.pay2)
    TextView pay2;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_adv_house2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        set.setText("在线缴费");
        myonclick();
    }
    private void myonclick() {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //业务办理
                intent(AdvYWBLActivity.class);
            }
        });
    }

    @Override
    protected void destoryData() {

    }
}
