package com.example.master.byd.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.master.byd.MyApp;
import com.example.master.byd.R;
import com.example.master.byd.bean.LoginBean;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.SMSLoge;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.LoginPresenter;
import com.example.master.byd.presenter.SMSLogPresenter;
import com.example.master.byd.uitls.CountDownTextView;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.example.master.byd.uitls.util.RegisterUtil;
import com.example.master.byd.uitls.util.ToastUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.register)
    TextView mRegister;
    @BindView(R.id.xreturn)
    ImageView mXreturn;
    @BindView(R.id.login)
    TextView mLogin;
    boolean zai;
    @BindView(R.id.phoneNumber)
    EditText mPhoneNumber;
    @BindView(R.id.notevcode)
    EditText mNotevcode;
    @BindView(R.id.gets)
    CountDownTextView mGets;
    private SharedPreferences.Editor mEdit;
    private SMSLogPresenter mSmsLogPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        final LoginPresenter loginPresenter = new LoginPresenter(new LoginCall());
        mSmsLogPresenter = new SMSLogPresenter(new SMSCall());
        SharedPreferences share = MyApp.getShare();
        mEdit = share.edit();


        myonclick(loginPresenter);

        mEdit.putBoolean("zai", zai);
        mEdit.commit();
//        edit.putString("phone",trim);
//        edit.putString("pass",trim1);
//        edit.putInt("userid",data.getResult().getUserId());
//        edit.putString("sessionid",data.getResult().getSessionId());

    }

    private void myonclick(final LoginPresenter loginPresenter) {
        mXreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyApp.getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mPhonenums = mPhoneNumber.getText().toString();
                String notevcodes = mNotevcode.getText().toString();
                if (RegisterUtil.isMobileNO(mPhonenums) && RegisterUtil.isyzId(notevcodes)) {
                    loginPresenter.reqeust(mPhonenums, notevcodes);
                }

            }
        });
        count();
    }

    private void count() {
        mGets.setNormalText("获取验证码")
                .setCountDownText("", "s")
                .setCloseKeepCountDown(false)//关闭页面保持倒计时开关
                .setCountDownClickable(false)//倒计时期间点击事件是否生效开关
                .setShowFormatTime(false)//是否格式化时间
                .setIntervalUnit(TimeUnit.SECONDS)
                .setOnCountDownStartListener(new CountDownTextView.OnCountDownStartListener() {
                    @Override
                    public void onStart() {
//                        Toast.makeText(MainActivity.this, "开始计时", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnCountDownTickListener(new CountDownTextView.OnCountDownTickListener() {
                    @Override
                    public void onTick(long untilFinished) {
                        Log.e("------", "onTick: " + untilFinished);
                    }
                })
                .setOnCountDownFinishListener(new CountDownTextView.OnCountDownFinishListener() {
                    @Override
                    public void onFinish() {
                        mGets.setNormalText("重新获取");
//                        Toast.makeText(MainActivity.this, "倒计时完毕", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String mPhonenums = mPhoneNumber.getText().toString();
                        if (RegisterUtil.isMobileNO(mPhonenums)) {
                            mSmsLogPresenter.reqeust(mPhonenums);
                        }

                    }
                });
    }

    @Override
    protected void destoryData() {

    }


    private class LoginCall implements DataCall<Result<LoginBean>> {
        @Override
        public void success(Result<LoginBean> data) {

            if (data.getErrorCode() == 200) {
                zai = true;
                LoginBean.DataBean data1 = data.getMapResult().getData();
                String realName = data1.getRealName();
                String nc = data1.getNc();
                mEdit.putBoolean("zai", zai);
                mEdit.putBoolean("yi", true);
                mEdit.putString("id", data1.getId());//id
                mEdit.putString("realName", realName);//姓名
                mEdit.putString("loginName", data1.getLoginName());//手机号
                mEdit.putString("tx", data1.getTx());//头像
                mEdit.putString("nc", nc);//昵称
                mEdit.putString("sfzhm", data1.getSfzhm());//身份证号
                mEdit.putString("sfsmrz", data1.getSfsmrz());//身份证号

                mEdit.commit();
                finish();

            } else {
                ToastUtils.showShort(data.getResultMsg());

            }

        }

        @Override
        public void fail(ApiException e) {

        }
    }

    private class SMSCall implements DataCall<Result<SMSLoge>> {
        @Override
        public void success(Result<SMSLoge> data) {
//            ToastUtils.showShort(data.getMapResult().getData().getMESSAGE_AUTH_ERRORCODE());
            if (data.isSuccess()) {
                ToastUtils.showShort("短信已发送");
                mGets.startCountDown(60);
            }
        }

        @Override
        public void fail(ApiException e) {

        }
    }
}
