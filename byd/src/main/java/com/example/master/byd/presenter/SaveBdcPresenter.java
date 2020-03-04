package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 接收外网申请  申请信息填写保存
 * @author byd
 * @date 2019/5/31 17:28
 */
public class SaveBdcPresenter extends BasePresenter{
    public SaveBdcPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.saveBdcSqxx((String)args[0]);
    }
}
