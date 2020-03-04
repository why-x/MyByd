package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 业务办理 - 查询我能办理的业务列表（即时办结  1）（现场办结    2）
 * @author byd
 * @date 2019/5/31 17:28
 */
public class AllowMyYwlxPresenter extends BasePresenter{
    public AllowMyYwlxPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.getAllowMyYwlx((String)args[0],(String)args[1]);
    }
}
