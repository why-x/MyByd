package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 提交给买\卖方认证
 * @author byd
 * @date 2019/5/31 17:28
 */
public class SendCheckPresenter extends BasePresenter{
    public SendCheckPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.sendCheck((String)args[0],(String)args[1]);
    }
}
