package com.example.master.byd.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.BusinessAdapter;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.UserBLYW;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.UserBLYWPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

public class BusinessActivity extends BaseActivity {

    @BindView(R.id.set)
    TextView mSet;
    @BindView(R.id.freturn)
    ImageView mFreturn;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private BusinessAdapter mBusinessAdapter;
    private SharedPreferences mShare;
    private UserBLYWPresenter mBlywPresenter;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_business;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mShare = MyApp.getShare();
        mFreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mSet.setText("我的业务");

        mBlywPresenter = new UserBLYWPresenter(new UserBLYWCall());
        mBlywPresenter.reqeust(mShare.getString("sfzhm", ""));
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mBlywPresenter.reqeust(mShare.getString("sfzhm", ""));
                mRefreshLayout.finishRefresh();
            }
        });

        myrecyler();
    }

    private void myrecyler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mBusinessAdapter = new BusinessAdapter(this);
        mRecyclerView.setAdapter(mBusinessAdapter);
    }

    @Override
    protected void destoryData() {
        mRefreshLayout.finishRefresh();

    }

    private class UserBLYWCall implements DataCall<Result<UserBLYW>> {
        @Override
        public void success(Result<UserBLYW> data) {
            List<UserBLYW.DataBean> dataX = data.getMapResult().getData();
            mBusinessAdapter.addAll(dataX);
        }

        @Override
        public void fail(ApiException e) {

        }
    }
}
