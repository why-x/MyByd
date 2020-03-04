package com.example.master.byd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.MyAdapter;
import com.example.master.byd.adapter.Proposer3Adapter;
import com.example.master.byd.core.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

public class CompleteActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.save)
    TextView mSave;
    @BindView(R.id.clear)
    ImageView mClear;
    @BindView(R.id.clear2)
    LinearLayout mClear2;
    @BindView(R.id.adddeal)
    TextView mAdddeal;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_complete;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("完税－房屋交易在线登记");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        Proposer3Adapter proposerAdapter = new Proposer3Adapter(MyApp.getContext());
        mRecyclerView.setAdapter(proposerAdapter);
        ArrayList<String> list = new ArrayList<>();
        list.add("(151)鲁地现");

        MyAdapter myAdapter = new MyAdapter(list, this);
        spinner.setAdapter(myAdapter);

        myonclick();
    }

    private void myonclick() {
        mAdddeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), PayHouseActivity.class);
                startActivity(intent);
            }
        });
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent(OnSellerActivity.class);
            }
        });

    }

    @Override
    protected void destoryData() {

    }

}
