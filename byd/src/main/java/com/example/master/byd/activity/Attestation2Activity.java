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
import android.widget.Toast;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.adapter.Attestation2Adapter;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class Attestation2Activity extends BaseActivity {

    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.save)
    TextView mSave;
    @BindView(R.id.sure)
    TextView mSure;
    @BindView(R.id.nosure)
    TextView mNosure;
    private Dialog dialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_attestation2;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        set.setText("认证信息");
        dialog = new Dialog(this, R.style.DialogTheme);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyApp.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        Attestation2Adapter attestation2Adapter = new Attestation2Adapter(MyApp.getContext());
        mRecyclerView.setAdapter(attestation2Adapter);

        myonclick();
    }

    private void myonclick() {

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = View.inflate(MyApp.getContext(), R.layout.hin4tdialog, null);

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
                        dialog.dismiss();
                        View view1 = View.inflate(MyApp.getContext(), R.layout.hin5tdialog, null);

                        dialog.setContentView(view1);
                        dialog.getWindow().setGravity(Gravity.CENTER);
                        dialog.show();
                        getshoud(2);
                        //确定
                        TextView sure = view1.findViewById(R.id.sure);
                        sure.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                Toast.makeText(MyApp.getContext(), "业务提交中，请稍候", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Attestation2Activity.this,PayFActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });

        mSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mNosure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        if (bottom == 1) {
            p.height = (int) (d.getHeight() * 0.25);
        } else {
            p.height = (int) (d.getHeight() * 0.22);

        }
        dialogWindow.setAttributes(p);
    }
}
