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

public class SellFinshActivity extends BaseActivity {

    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.express_status_tv)
    TextView mExpressStatusTv;
    @BindView(R.id.express_company_tv)
    TextView mExpressCompanyTv;
    @BindView(R.id.express_number_tv)
    TextView mExpressNumberTv;
    @BindView(R.id.savephoto)
    TextView mSavephoto;
    @BindView(R.id.fan)
    TextView mFan;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sell_finsh;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("业务办理");
        myonclick();

    }

    private void myonclick() {
        mSavephoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApp.getShare().edit().putInt("zsnum",2).commit();

                Intent intent = new Intent(MyApp.getContext(), CertificateActivity.class);
                startActivity(intent);
            }
        });
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void destoryData() {

    }
    
}
