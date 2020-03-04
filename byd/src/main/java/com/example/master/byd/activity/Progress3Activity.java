package com.example.master.byd.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.adapter.TraceAdapter;
import com.example.master.byd.bean.MyJDBean;
import com.example.master.byd.core.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Progress3Activity extends BaseActivity {
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
    @BindView(R.id.traceRv)
    RecyclerView mTraceRv;
    @BindView(R.id.fre)
    TextView mFre;
    private RecyclerView traceRv; //物流追踪列表
    private List<MyJDBean.DataBean.SpgcBean> mTraceList; //物流追踪列表的数据源
    private TraceAdapter mAdapter;
    private MyJDBean.DataBean mProgress;
    private String mCxlx;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_progress3;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mFre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("进度查询");

        Bundle extras = getIntent().getExtras();
        mCxlx = extras.getString("cxlx");
        mProgress = (MyJDBean.DataBean) extras.getSerializable("progress");
        mExpressStatusTv.setText(mProgress.getYwlxmc());
        mExpressCompanyTv.setText("权利人："+ mProgress.getQlr());
        mExpressNumberTv.setText("流水号："+ mProgress.getSlbh());
        initData();
        initRecyclerView();

    }

    @Override
    protected void destoryData() {

    }

    //加载物流信息的数据，这里是模拟一些假数据
    private void initData() {
        mTraceList = new ArrayList<>();
        if (mCxlx.equals("1")){
            mTraceList=mProgress.getSpgc();

        }else {
            mTraceList=mProgress.getSPGC();

        }
//        mTraceList.add(new Trace(1, "09-18", "11:54", "未缮证", "申请人选择纸质证书"));
//        mTraceList.add(new Trace(0, "09-18", "08:47", "已审批", "办件完成审批，正在准备登簿。"));
//        mTraceList.add(new Trace(1, "09-18", "07:26", "已完成税费缴纳", "卖方完成税费缴纳"));
//        mTraceList.add(new Trace(1, "09-18", "05:02", " ", "买卖双方已通过支付宝完成税费缴纳。"));
//        mTraceList.add(new Trace(1, "09-18", "03:02", " ", "已核税，等待买卖双方缴税、缴费。"));
//        mTraceList.add(new Trace(1, "09-17", "20:02", " ", "发送核税请求，正在等待税务平台返回结果。"));
//        mTraceList.add(new Trace(1, "09-17", "20:02", "登记已受理", "您的登记办件已提交，并由不动产登记中心平台核验权利人和权证信息后自动受理。"));
//        mTraceList.add(new Trace(1, "09-17", "18:32", "已网签", "买卖双方达成意愿，已网签备案"));

    }

    //初始化显示物流追踪的RecyclerView
    private void initRecyclerView() {
        traceRv = (RecyclerView) findViewById(R.id.traceRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
        mAdapter = new TraceAdapter(this, mTraceList);
//        mAdapter.add();
        traceRv.setLayoutManager(layoutManager);
        traceRv.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

}
