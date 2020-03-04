package com.example.master.byd.activity.advance;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.adapter.MyAdapter;
import com.example.master.byd.core.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * 预告注销
 */
public class AdvanceDataZXActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.spinner2)
    Spinner spinner2;
    @BindView(R.id.starsearch)
    TextView starsearch;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_advancezx_data;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("卖方数据校验－预告登记");
        ArrayList<String> list = new ArrayList<>();
        list.add(" 滨州市不动产证明");

        MyAdapter myAdapter = new MyAdapter(list, this);
        spinner2.setAdapter(myAdapter);
        myonclick();
    }

    private void myonclick() {
        starsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(AdvanceProposerZXActivity.class);
            }
        });
    }

    @Override
    protected void destoryData() {

    }
}
