package com.example.master.byd.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.adapter.MyAdapter;
import com.example.master.byd.bean.BdcEffectivity;
import com.example.master.byd.bean.Result;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.BdcEffectivityPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.example.master.byd.uitls.util.ToastUtils;

import java.util.ArrayList;

import butterknife.BindView;

public class SellActivity extends BaseActivity {

    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.spinner1)
    Spinner spinner1;
    @BindView(R.id.spinner2)
    Spinner spinner2;

    @BindView(R.id.starsearch)
    TextView mStarsearch;

    @BindView(R.id.time)
    EditText mTime;
    @BindView(R.id.number)
    EditText mNumber;
    @BindView(R.id.namenum)
    TextView mNamenum;
    @BindView(R.id.fyxxhy)
    TextView mFyxxhy;
    @BindView(R.id.tdxxhy)
    TextView mTdxxhy;
    @BindView(R.id.dycfhy)
    TextView mDycfhy;
    @BindView(R.id.mfzghy)
    TextView mMfzghy;
    private BdcEffectivityPresenter mEffectivityPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sell;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("卖方数据校验－房屋交易在线登记");
        mEffectivityPresenter = new BdcEffectivityPresenter(new EffectivityCall());
        ArrayList<String> list = new ArrayList<>();
        list.add("不动产权证");

        MyAdapter myAdapter = new MyAdapter(list, this);
        spinner1.setAdapter(myAdapter);
        spinner2.setAdapter(myAdapter);
        myonclick();


    }

    private void myonclick() {
        //开始查询
        mStarsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time = mTime.getText().toString();
                String number = mNumber.getText().toString();
                String text = "鲁(" + time + ")滨州市不动产权第" + number + "号";
                mEffectivityPresenter.reqeust(text);

            }
        });
    }

    @Override
    protected void destoryData() {

    }

    private class EffectivityCall implements DataCall<Result<BdcEffectivity>> {
        @Override
        public void success(Result<BdcEffectivity> data) {
            BdcEffectivity.DataBean data1 = data.getMapResult().getData();
            if (data1.equals("")){
                ToastUtils.showShort("无数据");
            }else{
                mNamenum.setText(data1.getQlr().getNAME() + "(" + data1.getQlr().getIDNUMBER() + ")");
                //数据校验
                BdcEffectivity.DataBean.SjjyBean sjjy = data1.getSjjy();
                if (sjjy.getMfzghy().equals("1")) {
                    mMfzghy.setText("✔通过");
                } else {
                    mMfzghy.setText("✖不通过");

                }
                if (sjjy.getDycfhy().equals("1")) {
                    mDycfhy.setText("✔通过");
                } else {
                    mDycfhy.setText("✖不通过");

                }
                if (sjjy.getTdxxhy().equals("1")) {
                    mTdxxhy.setText("✔通过");
                } else {
                    mTdxxhy.setText("✖不通过");

                }
                if (sjjy.getFyxxhy().equals("1")) {
                    mFyxxhy.setText("✔通过");
                } else {
                    mFyxxhy.setText("✖不通过");

                }
                intent(ProposerActivity.class);
            }


        }

        @Override
        public void fail(ApiException e) {

        }
    }
}
