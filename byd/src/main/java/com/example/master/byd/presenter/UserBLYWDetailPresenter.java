package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 业务列表
 *
 * @author byd
 * @date 2019/5/31 17:28
 */
public class UserBLYWDetailPresenter extends BasePresenter {
    public UserBLYWDetailPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.getUserBLYWDetail((String) args[0]);
    }
}
