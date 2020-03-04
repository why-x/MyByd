package com.example.master.byd.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.bean.MyJDBean;
import com.example.master.byd.bean.Result;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.DWMytJDPresenter;
import com.example.master.byd.presenter.MytJDPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.example.master.byd.uitls.util.ToastUtils;

import butterknife.BindView;

public class ProgressActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.personage)
    LinearLayout mPersonage;
    @BindView(R.id.unit)
    LinearLayout mUnit;
    @BindView(R.id.personage2)
    EditText mPersonage2;
    @BindView(R.id.unit2)
    EditText mUnit2;
    @BindView(R.id.bnum)
    EditText mBnum;
    @BindView(R.id.search)
    TextView mSearch;
    private Dialog dialog;
    String cxlx="1";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_progress;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("进度查询");
        myonclick();
        dialog = new Dialog(ProgressActivity.this, R.style.DialogTheme);
        mPersonage.setBackground(getResources().getDrawable(R.drawable.blueback));
        mUnit.setBackgroundColor(Color.WHITE);
    }

    private void myonclick() {
        mPersonage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cxlx="1";
                mPersonage.setBackground(getResources().getDrawable(R.drawable.blueback));
                mUnit.setBackgroundColor(Color.WHITE);
                mPersonage2.setVisibility(View.VISIBLE);
                mUnit2.setVisibility(View.GONE);
            }
        });
        mUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cxlx="2";
                mUnit.setBackground(getResources().getDrawable(R.drawable.blueback));
                mPersonage.setBackgroundColor(Color.WHITE);
                mPersonage2.setVisibility(View.GONE);
                mUnit2.setVisibility(View.VISIBLE);

            }
        });
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bnumText = mBnum.getText().toString();
                String mmPersonage2 = mPersonage2.getText().toString();
                String mmUnit2 = mUnit2.getText().toString();

                MytJDPresenter mytJDPresenter = new MytJDPresenter(new MytJDCall());
                DWMytJDPresenter dwMytJDPresenter=new DWMytJDPresenter(new MytJDCall());
                if (cxlx.equals("1")){
                   mytJDPresenter.reqeust(cxlx, mmPersonage2, bnumText);
//                mytJDPresenter.reqeust("1", "37230120040427381X", "201600006553");
                }else{
                    dwMytJDPresenter.reqeust(cxlx, bnumText, mmUnit2);
//                    dwMytJDPresenter.reqeust(cxlx, "201600007371", "中国工商银行股份有限公司滨州滨城支行");
                }
            }
        });


    }



    @Override
    protected void destoryData() {

    }


    private class MytJDCall implements DataCall<Result<MyJDBean>> {
        @Override
        public void success(Result<MyJDBean> data) {
            ToastUtils.showShort(data.getResultMsg());

            MyJDBean.DataBean data1 = data.getMapResult().getData();

            if (data1 != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("progress", data1);
                bundle.putString("cxlx",cxlx);

                intent(Progress3Activity.class, bundle);

            } else {
                intent(Progress2Activity.class);
            }
        }

        @Override
        public void fail(ApiException e) {
            intent(Progress2Activity.class);

        }
    }
}
