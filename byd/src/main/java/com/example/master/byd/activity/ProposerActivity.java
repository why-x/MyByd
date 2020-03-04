package com.example.master.byd.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.GsonUtils;
import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.ProposerAdapter;
import com.example.master.byd.bean.People;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.WhthinG;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.DelBdcMsrPresenter;
import com.example.master.byd.presenter.SaveBdcPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProposerActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.save)
    TextView mSave;
    @BindView(R.id.addsell)
    TextView mAddsell;
    private Dialog dialog;
    private List<People> mPeopleList=new ArrayList<>();
    private DelBdcMsrPresenter mMsrPresenter;
    private SaveBdcPresenter mBdcPresenter;
    private ProgressDialog mProgressDialog;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_proposer;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        dialog = new Dialog(this, R.style.DialogTheme);

        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("申请信息填写－房屋交易在线登记");
        mBdcPresenter = new SaveBdcPresenter(new SaveCall());
        mMsrPresenter = new DelBdcMsrPresenter(new DeleteCall());
        myonclick();
        addmai();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==200&&resultCode==300){
            mPeopleList = (List<People>) data.getExtras().getSerializable("peoplelist");
        }
    }

    private void addmai() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        ProposerAdapter proposerAdapter = new ProposerAdapter(MyApp.getContext());
        mRecyclerView.setAdapter(proposerAdapter);
        proposerAdapter.addAll(mPeopleList);
        proposerAdapter.setOnDeleListener(new ProposerAdapter.OnDeleListener() {
            @Override
            public void onDelete(String zjh) {
//                qlrid
//                mMsrPresenter.reqeust(qlrid);
            }
        });
    }
    private void myonclick() {
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = View.inflate(MyApp.getContext(), R.layout.hint2dialog, null);
                dialog.setContentView(view1);
                dialog.getWindow().setGravity(Gravity.CENTER);
                dialog.show();
                getshoud();
                //在想想
                TextView mcancle = view1.findViewById(R.id.cancle);
                mcancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                //继续
                TextView msure = view1.findViewById(R.id.sure);
                msure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mBdcPresenter.reqeust(GsonUtils.toJson(mPeopleList));
                        mProgressDialog= ProgressDialog.show(ProposerActivity.this, "提示", "Loading");
                        mProgressDialog.setCanceledOnTouchOutside(true);
                        Intent intent = new Intent(MyApp.getContext(), CompleteActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });


            }
        });
        //添加买方
        mAddsell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), AddSellActivity.class);
                startActivityForResult(intent,200);
                finish();
            }
        });

    }

    @Override
    protected void destoryData() {

    }

    private void getshoud() {
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.85); // 宽度设置为屏幕的0.65，根据实际情况调整
        p.height = (int) (d.getHeight() * 0.3);

        dialogWindow.setAttributes(p);
    }
    private class DeleteCall implements DataCall<Result> {
        @Override
        public void success(Result data) {

        }

        @Override
        public void fail(ApiException e) {

        }
    }

    private class SaveCall implements DataCall<Result<WhthinG>> {
        @Override
        public void success(Result<WhthinG> data) {

            mProgressDialog.dismiss();
        }

        @Override
        public void fail(ApiException e) {
            mProgressDialog.dismiss();

        }
    }
}
