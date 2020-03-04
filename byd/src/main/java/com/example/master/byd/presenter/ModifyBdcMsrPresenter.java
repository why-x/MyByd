package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 修改买方人员信息
 * @author byd
 * @date 2019/5/31 17:28
 */
public class ModifyBdcMsrPresenter extends BasePresenter{
    public ModifyBdcMsrPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.modifyBdcMsr((String)args[0],(String)args[1],(String)args[2]);
    }
}
