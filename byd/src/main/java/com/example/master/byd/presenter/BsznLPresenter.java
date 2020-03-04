package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 查询所有办事指南列表
 * @author byd
 * @date 2019/5/31 17:28
 */
public class BsznLPresenter extends BasePresenter{
    public BsznLPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.getBszns((String) args[0]);
    }
}
