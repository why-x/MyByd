package com.example.master.byd.activity;

import android.app.Dialog;
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

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.Proposer3Adapter;
import com.example.master.byd.adapter.ProposerAdapter;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class Complete2Activity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.save)
    TextView mSave;
    private Dialog dialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_complete2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("完税－房屋交易在线登记");
        dialog = new Dialog(this, R.style.DialogTheme);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        Proposer3Adapter proposerAdapter = new Proposer3Adapter(MyApp.getContext());
        mRecyclerView.setAdapter(proposerAdapter);
        myonclick();


    }

    private void myonclick() {
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = View.inflate(MyApp.getContext(), R.layout.hint3dialog, null);

                dialog.setContentView(view1);
                dialog.getWindow().setGravity(Gravity.CENTER);
                dialog.show();
                getshoud(1);
                //取消
                TextView mcancle = view1.findViewById(R.id.cancle);
                mcancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                //确定
                TextView msure = view1.findViewById(R.id.sure);
                msure.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MyApp.getContext(), AttestationActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
            }
        });

    }

    @Override
    protected void destoryData() {

    }
    private void getshoud(int bottom) {
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.85); // 宽度设置为屏幕的0.65，根据实际情况调整
        if (bottom==1){
            p.height = (int) (d.getHeight() * 0.4);
        }else {
            p.height = (int) (d.getHeight() * 0.22);

        }
        dialogWindow.setAttributes(p);
    }
}
