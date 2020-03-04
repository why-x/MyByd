package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 最新资讯详情
 * @author byd
 * @date 2019/5/31 17:28
 */
public class NewsDetailPresenter extends BasePresenter{
    public NewsDetailPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.newsDetail((String)args[0]);
    }
}
