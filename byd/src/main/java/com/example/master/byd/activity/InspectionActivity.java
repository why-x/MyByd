package com.example.master.byd.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.master.byd.R;
import com.example.master.byd.adapter.MyAdapter;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.Search;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.SearchPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;

import java.util.ArrayList;

import butterknife.BindView;

public class InspectionActivity extends BaseActivity {

    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.quit)
    TextView mQuit;
    @BindView(R.id.searched)
    EditText mSearched;
    @BindView(R.id.startserarch)
    TextView mStartserarch;
    @BindView(R.id.bdcdyh)
    TextView mBdcdyh;
    @BindView(R.id.bdczh)
    TextView mBdczh;
    @BindView(R.id.qllx)
    TextView mQllx;
    @BindView(R.id.qlr)
    TextView mQlr;
    @BindView(R.id.textView14)
    TextView mTextView14;
    @BindView(R.id.qlmj)
    TextView mQlmj;
    @BindView(R.id.textView17)
    TextView mTextView17;
    @BindView(R.id.zl)
    TextView mZl;
    @BindView(R.id.searchlayout)
    LinearLayout mSearchlayout;
    private SearchPresenter mSearchPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_inspection;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("查验");
        mSearchPresenter = new SearchPresenter(new SearchCall());

        ArrayList<String> list = new ArrayList<>();
        list.add("房源核验");

        MyAdapter myAdapter = new MyAdapter(list, this);
        spinner.setAdapter(myAdapter);
        mQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        myonclick();
    }

    private void myonclick() {

        mSearched.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String search = mSearched.getText().toString();
//                search = "鲁(2019)滨州市不动产权第0001048号";
                if (TextUtils.isEmpty(mSearched.getText())) {
                    Toast.makeText(getBaseContext(), "请输入有效字符", Toast.LENGTH_SHORT).show();
                } else {
                    mSearchPresenter.reqeust(search);
                }
                return false;
            }
        });
        mStartserarch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = mSearched.getText().toString();
//                search = "鲁(2019)滨州市不动产权第0001048号";
                if (TextUtils.isEmpty(mSearched.getText())) {
                    Toast.makeText(getBaseContext(), "请输入有效字符", Toast.LENGTH_SHORT).show();
                } else {
                    mSearchPresenter.reqeust(search);
                }
            }
        });


    }

    @Override
    protected void destoryData() {

    }


    private class SearchCall implements DataCall<Result<Search>> {
        @Override
        public void success(Result<Search> data) {
//            Toast.makeText(getBaseContext(), data.getMapResult().getData().getBdcdyh(), Toast.LENGTH_SHORT).show();
            if (data.getMapResult().getData() != null) {
//            Toast.makeText(getBaseContext(), "请求成功", Toast.LENGTH_SHORT).show();
                mSearchlayout.setVisibility(View.VISIBLE);
                Search.DataBean dataBean = data.getMapResult().getData().get(0);

                mBdcdyh.setText(dataBean.getBdcdyh());
                mBdczh.setText(dataBean.getBdczh());
                mQllx.setText(dataBean.getQllx());
                mQlr.setText(dataBean.getQlr());

                mQlmj.setText(dataBean.getQlmj() + "平方米");
                mZl.setText(dataBean.getZl());
            } else {
                Toast.makeText(getBaseContext(), "请求失败,请输入正确房源核验证编号/不动产权证号", Toast.LENGTH_SHORT).show();

            }
        }

        @Override
        public void fail(ApiException e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "请求失败，请检查网络", Toast.LENGTH_SHORT).show();
        }
    }
}
