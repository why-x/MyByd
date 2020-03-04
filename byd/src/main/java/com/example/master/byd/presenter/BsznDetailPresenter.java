package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 查看某个业务的办事指南
 * @author byd
 * @date 2019/5/31 17:28
 */
public class BsznDetailPresenter extends BasePresenter{
    public BsznDetailPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.getBsznDetail((String)args[0]);
    }
}
