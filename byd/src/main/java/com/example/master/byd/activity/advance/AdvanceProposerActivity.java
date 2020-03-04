package com.example.master.byd.activity.advance;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.master.byd.activity.AddSellActivity;
import com.example.master.byd.adapter.AdvProposerAdapter;
import com.example.master.byd.adapter.ProposerAdapter;
import com.example.master.byd.bean.People;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.WhthinG;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.DelBdcMsrPresenter;
import com.example.master.byd.presenter.SaveBdcPresenter;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;

import java.util.List;

import butterknife.BindView;

public class AdvanceProposerActivity extends BaseActivity {
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
    int flag = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_advance_proposer;
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
        set.setText("申请信息填写－预告登记");

        myonclick();
        addmai();
    }

    private void addmai() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        AdvProposerAdapter advProposerAdapter = new AdvProposerAdapter(MyApp.getContext(), flag);
        mRecyclerView.setAdapter(advProposerAdapter);
        advProposerAdapter.setOnDeleListener(new AdvProposerAdapter.OnDeleListener() {
            @Override
            public void onDelete(String zjh) {
//                qlrid
//                mMsrPresenter.reqeust(qlrid);
            }
        });
    }

    @Override
    protected void destoryData() {

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
                        intent(AdvHouseActivity.class);
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
                startActivity(intent);
            }
        });

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


}
