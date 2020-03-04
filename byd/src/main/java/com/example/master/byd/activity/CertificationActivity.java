package com.example.master.byd.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.core.BaseActivity;

import butterknife.BindView;

public class CertificationActivity extends BaseActivity {
    @BindView(R.id.freturn)
    ImageView freturn;
    @BindView(R.id.set)
    TextView set;
    @BindView(R.id.agreea)
    TextView mAgreea;
    @BindView(R.id.start)
    TextView mStart;
    private Dialog dialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_certification;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        set.setText("用户信息认证");
        dialog = new Dialog(this, R.style.DialogTheme);

        myonclick();

    }

    private void myonclick() {
        freturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mAgreea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), AgreementActivity.class);
                startActivity(intent);
            }
        });
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = View.inflate(MyApp.getContext(), R.layout.noticedialog, null);
                dialog.setContentView(view1);
                dialog.getWindow().setGravity(Gravity.CENTER);
                dialog.show();
                getshoud();
                //我知道了
                TextView mcancle = view1.findViewById(R.id.cancle);
                mcancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //todo 跳转认证页面 人脸识别
                        dialog.dismiss();
                    }
                });
            }
        });

    }
    private void getshoud() {
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.width = (int) (d.getWidth() * 0.85); // 宽度设置为屏幕的0.65，根据实际情况调整
        p.height = (int) (d.getHeight() * 0.47);

        dialogWindow.setAttributes(p);
    }
    @Override
    protected void destoryData() {

    }


}
