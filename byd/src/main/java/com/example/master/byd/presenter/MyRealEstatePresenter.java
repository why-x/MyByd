package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import io.reactivex.Observable;

/**
 * 我的产权
 * @author byd
 * @date 2019/6/27 11:19
 */
public class MyRealEstatePresenter extends BasePresenter{
    public MyRealEstatePresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
        return anInterface.getMyRealEstate((String) args[0]);
    }
}
