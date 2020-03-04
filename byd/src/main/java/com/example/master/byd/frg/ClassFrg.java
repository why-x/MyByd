package com.example.master.byd.frg;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.NoMoveAdapter;
import com.example.master.byd.bean.BsznL;
import com.example.master.byd.bean.Result;
import com.example.master.byd.core.BaseFragment;
import com.example.master.byd.presenter.BsznLPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.List;

import butterknife.BindView;

/**
 * 业务指南
 *
 * @author byd
 * @date 2019/5/17 16:51
 */
public class ClassFrg extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.land)
    LinearLayout mLand;
    @BindView(R.id.house)
    LinearLayout mHouse;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private NoMoveAdapter mNoMoveAdapter;
    private BsznLPresenter mBsznLPresenter;

    @Override
    public String getPageName() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.class_frg;
    }

    @Override
    protected void initView() {

        //查询土地办事指南列表
        mBsznLPresenter = new BsznLPresenter(new BsznCall());
        mBsznLPresenter.reqeust("t");

        //背景颜色默认选中土地
        mLand.setBackground(getResources().getDrawable(R.drawable.blueback));
        mHouse.setBackgroundColor(Color.WHITE);


        myonclick();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mNoMoveAdapter = new NoMoveAdapter(MyApp.getContext());
        mRecyclerView.setAdapter(mNoMoveAdapter);
        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(MyApp.getContext())
                .color(Color.parseColor("#f2f2f2"))  //颜色
                .size(2)        //大小
                .margin(0, 2)    //距离
                .build());

    }

    private void myonclick() {
        //刷新
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mBsznLPresenter.reqeust("t");
                refreshlayout.finishRefresh();
            }
        });

//        土地
        mLand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //背景颜色
                mLand.setBackground(getResources().getDrawable(R.drawable.blueback));
                mHouse.setBackgroundColor(Color.WHITE);
                mBsznLPresenter.reqeust("t");

                mLand.setVisibility(View.VISIBLE);
                mHouse.setVisibility(View.VISIBLE);
                mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                    @Override
                    public void onRefresh(RefreshLayout refreshlayout) {
                        mBsznLPresenter.reqeust("t");

                        refreshlayout.finishRefresh();
                    }
                });

            }
        });
//        房屋
        mHouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //背景颜色
                mHouse.setBackground(getResources().getDrawable(R.drawable.blueback));
                mLand.setBackgroundColor(Color.WHITE);
                mBsznLPresenter.reqeust("f");

                mHouse.setVisibility(View.VISIBLE);
                mLand.setVisibility(View.VISIBLE);
                mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
                    @Override
                    public void onRefresh(RefreshLayout refreshlayout) {
                        mBsznLPresenter.reqeust("f");

                        refreshlayout.finishRefresh();
                    }
                });
            }
        });
    }


    private class BsznCall implements DataCall<Result<BsznL>> {
        @Override
        public void success(Result<BsznL> data) {
            List<BsznL.DataBean> data1 = data.getMapResult().getData();
            mNoMoveAdapter.addAll(data1);
        }

        @Override
        public void fail(ApiException e) {

        }
    }
}
