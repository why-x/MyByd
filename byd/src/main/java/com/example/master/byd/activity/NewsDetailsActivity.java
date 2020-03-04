package com.example.master.byd.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.bean.NewsDetail;
import com.example.master.byd.bean.Result;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.NewsDetailPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.just.agentweb.AgentWeb;

import butterknife.BindView;

public class NewsDetailsActivity extends BaseActivity {

    @BindView(R.id.freturn)
    ImageView mFreturn;
    @BindView(R.id.set)
    TextView mSet;

    @BindView(R.id.container)
    FrameLayout mContainer;
    private ProgressDialog mProgressDialog;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_details;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mSet.setText("资讯详情");
        mFreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        NewsDetailPresenter newsDetailPresenter = new NewsDetailPresenter(new NewsDetailCall());
        mProgressDialog = ProgressDialog.show(this, "提示", "loading...", true);

        mProgressDialog.setCanceledOnTouchOutside(true);
        newsDetailPresenter.reqeust(id);
    }

    @Override
    protected void destoryData() {

    }

    private class NewsDetailCall implements DataCall<Result<NewsDetail>> {
        @Override
        public void success(Result<NewsDetail> data) {
            String newsContent = data.getMapResult().getData().getNewsContent();
//            Toast.makeText(MyApp.getContext(), data.getMapResult().getData().toString(), Toast.LENGTH_SHORT).show();
            AgentWeb.with(NewsDetailsActivity.this)
                    .setAgentWebParent(mContainer, new LinearLayout.LayoutParams(-1, -1))
                    .useDefaultIndicator()
                    .createAgentWeb()
                    .ready()
                    .go(newsContent);

            mProgressDialog.dismiss();

//            NewsDetail.DataBean data1 = data.getMapResult().getData();
//            mSet.setText("滨e登 - 相关资讯");
//
//            mTitle.setText(data1.getTitle());
//            mContent.setText(data1.getNewsContent());
//
//            Glide.with(NewsDetailsActivity.this)
//                    .load(data1.getImgPath())
//                    .error(R.drawable.wphoto)
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(mImg);
        }

        @Override
        public void fail(ApiException e) {
            mProgressDialog.dismiss();

        }
    }
}
