package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 查档服务 个人  家庭
 *
 * @author byd
 * @date 2019/5/31 17:28
 */
public class WhthinGPresenter extends BasePresenter{
    public WhthinGPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.getwhthin((String) args[0]);
    }
}
