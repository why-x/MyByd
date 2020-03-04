package com.example.master.byd;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDex;

import com.alibaba.security.rp.RPSDK;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;
 import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by shaowen.jiang@wellcare.cn on 2019/5/17.
 */
public class MyApp extends Application {

    /**
     * 主线程ID
     */
    private static int mMainThreadId = -1;
    /**
     * 主线程ID
     */
    private static Thread mMainThread;
    /**
     * 主线程Handler
     */
    private static Handler mMainThreadHandler;
    /**
     * 主线程Looper
     */
    private static Looper mMainLooper;

    /**
     * context 全局唯一的上下文
     */
    private static Context context;
    public static SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();


        context = this;
        mMainThreadId = android.os.Process.myTid();
        mMainThread = Thread.currentThread();
        mMainThreadHandler = new Handler();
        mMainLooper = getMainLooper();
        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);

        Fresco.initialize(this);
        CrashReport.initCrashReport(getApplicationContext(), "a72464006e", false);

        RPSDK.initialize(this);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("TAG",true))
                .connectTimeout(100000L, TimeUnit.MILLISECONDS)
                .readTimeout(100000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);


    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }

    public static SharedPreferences getShare() {
        return sharedPreferences;
    }


    public static Context getContext() {
        return context;
    }

    /**
     * 获取主线程ID
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 获取主线程
     */
    public static Thread getMainThread() {
        return mMainThread;
    }

    /**
     * 获取主线程的handler
     */
    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    /**
     * 获取主线程的looper
     */
    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }
}