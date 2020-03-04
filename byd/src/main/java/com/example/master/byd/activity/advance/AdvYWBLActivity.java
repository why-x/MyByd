package com.example.master.byd.activity.advance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.activity.CertificateActivity;
import com.example.master.byd.activity.HomeActivity;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class AdvYWBLActivity extends BaseActivity {

    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.fan)
    TextView mFan;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_adv_ywbl;
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
