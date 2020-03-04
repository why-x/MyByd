package com.example.myapplication.util;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;

public class TextViewTimeCountUtil extends CountDownTimer {


    private OnRemindTimeEndListener mOnRemindTimeEndListener;

    // 在这个构造方法里需要传入三个参数，一个是Activity，一个是总的时间millisInFuture，一个是countDownInterval，然后就是你在哪个按钮上做这个是，就把这个按钮传过来就可以了


    public TextViewTimeCountUtil(long millisInFuture, long countDownInterval, OnRemindTimeEndListener mTimeEndListener) {

        super(millisInFuture, countDownInterval);

        this.mOnRemindTimeEndListener = mTimeEndListener;

    }


    @SuppressLint("NewApi")


    @Override


    public void onTick(long millisUntilFinished) {

        if (null != mOnRemindTimeEndListener) {

            mOnRemindTimeEndListener.onTick(millisUntilFinished);

        }

    }


    @SuppressLint("NewApi")


    @Override


    public void onFinish() {

        if (null != mOnRemindTimeEndListener) {

            mOnRemindTimeEndListener.remindTimeEnd(1);

        }

    }


    public interface OnRemindTimeEndListener {


        void remindTimeEnd(int timeEnd);


        void onTick(long time);


    }

}
