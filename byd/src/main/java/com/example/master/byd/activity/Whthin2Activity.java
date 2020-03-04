package com.example.master.byd.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.bean.WhthinG;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class Whthin2Activity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.fan)
    TextView mFan;
    @BindView(R.id.text)
    TextView mText;
    @BindView(R.id.zl)
    TextView mZl;
    @BindView(R.id.time)
    TextView mTime;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_whthin2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("查档服务");
        mFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        WhthinG.DataBean whthin = (WhthinG.DataBean) extras.getSerializable("whthin");

        mText.setText("      经查档案，截止" + whthin.getCxsj() + "，查询");

        for (WhthinG.DataBean.CdrBean cdrBean : whthin.getCdr()) {
            mText.append(cdrBean.getName() + "(" + cdrBean.getIdnumber() + ")");
        }

        mText.append("共" + whthin.getCdr().size() + "人名下的不动产登记情况如下：");

        mZl.setText("");
        for (WhthinG.DataBean.BdcBean bdcBean : whthin.getBdc()) {
            mZl.append(bdcBean.getZl() + "\n");
        }

        mTime.setText(whthin.getCxsj());

    }

    @Override
    protected void destoryData() {

    }
}
