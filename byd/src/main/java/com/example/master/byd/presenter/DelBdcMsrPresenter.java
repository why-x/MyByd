package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 删除买方人员信息
 * @author byd
 * @date 2019/5/31 17:28
 */
public class DelBdcMsrPresenter extends BasePresenter{
    public DelBdcMsrPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.delBdcMsr((String)args[0]);
    }
}
