package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 身份证
 *
 * @author byd
 * @date 2019/6/28 17:28
 */
public class ShenFenZPresenter extends BasePresenter {
    public ShenFenZPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);

        return anInterface.shenfenz((String) args[0], (String) args[1], (String) args[2]);
    }
}
