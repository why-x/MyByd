package com.example.master.byd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.bean.BsznDetail;
import com.example.master.byd.bean.Result;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.BsznDetailPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;

import butterknife.BindView;

public class DetailsActivity extends BaseActivity {


    @BindView(R.id.freturn)
    ImageView mFreturn;
    @BindView(R.id.set)
    TextView mSet;
    @BindView(R.id.title1)
    TextView mTitle1;
    @BindView(R.id.sljgdz)
    TextView mSljgdz;
    @BindView(R.id.title2)
    TextView mTitle2;
    @BindView(R.id.mwebview)
    WebView mMwebview;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        mFreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mSet.setText("业务指南");
        mMwebview.setBackgroundColor(0);
        mMwebview.getSettings().setJavaScriptEnabled(true);//启用js
        mMwebview.getSettings().setBlockNetworkImage(false);//解决图片不显示
        BsznDetailPresenter bsznDetailPresenter = new BsznDetailPresenter(new BsznDetailCall());
        bsznDetailPresenter.reqeust(id);

    }

    @Override
    protected void destoryData() {

    }

    private class BsznDetailCall implements DataCall<Result<BsznDetail>> {
        @Override
        public void success(Result<BsznDetail> data) {
            if (data.getMapResult() != null) {
                BsznDetail.DataBean data1 = data.getMapResult().getData();
//                Toast.makeText(MyApp.getContext(), data.getMapResult().getData().toString(), Toast.LENGTH_SHORT).show();




                mTitle1.setText(data1.getYwlxmc() + "(" + data1.getYwdlmc() + ")");
                mTitle2.setText(data1.getYwlxmc() + "(" + data1.getYwdlmc() + ")");
                mSljgdz.setText(data1.getSljgdz());
                mMwebview.loadData(data1.getBszn(),  "text/html; charset=UTF-8", null);
            }
        }

        @Override
        public void fail(ApiException e) {

        }
    }
}
