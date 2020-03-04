package com.example.master.byd.activity.advance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.adapter.MyAdapter;
import com.example.master.byd.core.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvSellActivity extends BaseActivity {

    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.time)
    EditText time;
    @BindView(R.id.spinner2)
    Spinner spinner2;
    @BindView(R.id.number)
    EditText number;
    @BindView(R.id.namenum)
    TextView namenum;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.fyxxhy)
    TextView fyxxhy;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.tdxxhy)
    TextView tdxxhy;
    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.dycfhy)
    TextView dycfhy;
    @BindView(R.id.textView11)
    TextView textView11;
    @BindView(R.id.mfzghy)
    TextView mfzghy;
    @BindView(R.id.starsearch)
    TextView starsearch;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_adv_sell;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("卖方数据校验－预告抵押登记");
        ArrayList<String> list = new ArrayList<>();
        list.add(" 滨州市不动产证明");

        MyAdapter myAdapter = new MyAdapter(list, this);
        spinner2.setAdapter(myAdapter);
        starsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent(AdvProposerActivity.class);
            }
        });
    }

    @Override
    protected void destoryData() {

    }
}
