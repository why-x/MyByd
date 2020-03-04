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
import butterknife.ButterKnife;

public class AdvanceDataActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.spinner1)
    Spinner spinner1;
    @BindView(R.id.starsearch)
    TextView starsearch;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_advance_data;
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
        list.add("不动产单元号");

        MyAdapter myAdapter = new MyAdapter(list, this);
        spinner1.setAdapter(myAdapter);
        myonclick();
    }

    private void myonclick() {
        starsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(AdvanceProposerActivity.class);
            }
        });
    }

    @Override
    protected void destoryData() {

    }
}
