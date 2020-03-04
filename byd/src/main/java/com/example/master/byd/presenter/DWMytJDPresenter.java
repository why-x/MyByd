package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 单位办件进度查询
 * @author byd
 * @date 2019/5/31 17:28
 */
public class DWMytJDPresenter extends BasePresenter{
    public DWMytJDPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.getDWMyJD((String)args[0],(String)args[1],(String)args[2]);
    }
}
