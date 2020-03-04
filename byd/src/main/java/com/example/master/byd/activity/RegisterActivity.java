package com.example.master.byd.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.master.byd.R;
import com.example.master.byd.bean.Registered;
import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.SMSLoge;
import com.example.master.byd.core.BaseActivity;
import com.example.master.byd.presenter.RegisteredPresenter;
import com.example.master.byd.presenter.SMSRegPresenter;
import com.example.master.byd.uitls.CountDownTextView;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.ApiException;
import com.example.master.byd.uitls.util.RegisterUtil;
import com.example.master.byd.uitls.util.ToastUtils;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.freturn)
    ImageView mFreturn;
    @BindView(R.id.set)
    TextView mSet;
    @BindView(R.id.register2)
    TextView mRegister2;
    @BindView(R.id.agreea)
    TextView mAgreea;
    @BindView(R.id.phoneNumber)
    EditText mPhoneNumber;
    @BindView(R.id.verCode)
    EditText mVerCode;
    @BindView(R.id.realName)
    EditText mRealName;
    @BindView(R.id.idnumber)
    EditText mIdnumber;
    @BindView(R.id.gets)
    CountDownTextView mGets;
    @BindView(R.id.mswitch)
    Switch mMswitch;
    private RegisteredPresenter mRegisteredPresenter;
    private SMSRegPresenter mSmsRegPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mRegisteredPresenter = new RegisteredPresenter(new RegisteredCall());
        mSmsRegPresenter = new SMSRegPresenter(new SMSCall());
        mSet.setText("注册");

        myonclick();
    }

    private void myonclick() {
        mFreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mPhoneNumbers = mPhoneNumber.getText().toString();
                String realNames = mRealName.getText().toString();
                String idnumbers = mIdnumber.getText().toString();
                String verCodes = mVerCode.getText().toString();
                if (RegisterUtil.isMobileNO(mPhoneNumbers) && RegisterUtil.isLegalId(idnumbers) && RegisterUtil.isyzId(verCodes) && RegisterUtil.isLegalName(realNames)) {
                    if (mMswitch.isChecked()){
                        mRegisteredPresenter.reqeust(realNames, idnumbers, verCodes, mPhoneNumbers);
                    }else{
                        ToastUtils.showShort("请并同意全部协议");
                    }

                }

            }
        });
        mAgreea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent(AgreementActivity.class);
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
                        ToastUtils.showShort("短信已发送");
                        String mPhoneNumbers = mPhoneNumber.getText().toString();
                        if (RegisterUtil.isMobileNO(mPhoneNumbers)){
                            mGets.startCountDown(60);
                            mSmsRegPresenter.reqeust(mPhoneNumbers);
                        }
                    }
                });
    }

    @Override
    protected void destoryData() {

    }


    private class RegisteredCall implements DataCall<Result<Registered>> {
        @Override
        public void success(Result<Registered> data) {
            if (data.getErrorCode() == 200) {
                intent(LoginActivity.class);
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
            ToastUtils.showShort(data.getMapResult().getData().getMESSAGE_AUTH_ERRORCODE());
        }

        @Override
        public void fail(ApiException e) {

        }
    }
}
