package com.example.master.byd.presenter;

import com.example.master.byd.bean.Result;
import com.example.master.byd.bean.WhthinG;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.exceptio.CustomException;
import com.example.master.byd.uitls.exceptio.ResponseTransformer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public abstract class BasePresenter {
    private boolean running;
    private DataCall dataCall;

    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }

    protected abstract Observable<Result<WhthinG>> observable(Object... args);

    public void reqeust(Object... args) {
        if (running)
            return;
        running = true;
        observable(args)
                .compose(ResponseTransformer.handleResult())
                .compose(new ObservableTransformer() {
                    @Override
                    public ObservableSource apply(Observable upstream) {
                        return upstream.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {

                    }
                })
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        running = false;
                        //用户已登录
//                        if(result.getErrorCode()==200){
//                            SharedPreferences.Editor edit = MyApp.getShare().edit();
//                            edit.putBoolean("zai",true);
//                            edit.commit();
//                        }
                        if (dataCall != null) {
                            dataCall.success(result);
                        }
//                        mProgressDialog.dismiss();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        running = false;
                        // 处理异常
//                        UIUtils.showToastSafe("请求失败");
                        if (dataCall != null) {
                            dataCall.fail(CustomException.handleException(throwable));
                        }

//                        mProgressDialog.dismiss();
                    }
                });

    }

    public boolean isRunning() {
        return running;
    }

    public void unBind() {
        dataCall = null;
    }
}
