package com.example.master.byd.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.EquityAdapter;
import com.example.master.byd.bean.MyRealEstate;
import com.example.master.byd.bean.Result;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.MyRealEstatePresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import butterknife.BindView;

public class EquityActivity extends BaseActivity {

    @BindView(R.id.set)
    TextView mSet;
    @BindView(R.id.freturn)
    ImageView mFreturn;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private EquityAdapter mEquityAdapter;
    private ProgressDialog mProgressDialog;
    private MyRealEstatePresenter mMyRealEstatePresenter;
    private String mSfzhm;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_equity;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mFreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mSet.setText("我的产权");
        qingqiu();
        myrecyler();


        mProgressDialog = ProgressDialog.show(this, "提示", "Loading", true);

        mProgressDialog.setCanceledOnTouchOutside(true);
    }

    private void qingqiu() {
        mSfzhm = MyApp.getShare().getString("sfzhm", "");

        mMyRealEstatePresenter = new MyRealEstatePresenter(new MyRealEstateCall());

//        mMyRealEstatePresenter.reqeust(mSfzhm);
        mMyRealEstatePresenter.reqeust("372301198803181445");
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mMyRealEstatePresenter.reqeust(mSfzhm);
                mRefreshLayout.finishRefresh();
            }
        });
    }

    private void myrecyler() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mEquityAdapter = new EquityAdapter(this);
        mRecyclerView.setAdapter(mEquityAdapter);
    }

    @Override
    protected void destoryData() {

    }

    private class MyRealEstateCall implements DataCall<Result<MyRealEstate>> {
        @Override
        public void success(Result<MyRealEstate> data) {
            List<MyRealEstate.DataBean> data1 = data.getMapResult().getData();
            mEquityAdapter.addAlll(data1);
            mProgressDialog.dismiss();
            MyApp.getShare().edit().putInt("chanqnum",data1.size()).commit();

        }

        @Override
        public void fail(ApiException e) {
            mProgressDialog.dismiss();
        }
    }
}
