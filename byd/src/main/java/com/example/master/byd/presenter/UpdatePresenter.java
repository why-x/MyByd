package com.example.master.byd.presenter;

import com.example.master.byd.core.Interface;
import com.example.master.byd.uitls.DataCall;
import com.example.master.byd.uitls.NetWorkManager;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * 头像或昵称更新1
 * @author byd
 * @date 2019/5/31 17:28
 */
public class UpdatePresenter extends BasePresenter{
    public UpdatePresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        Interface anInterface = NetWorkManager.getInstance().create(Interface.class);
//        return anInterface.updateUserInfoById((String)args[0],(String)args[1],(MultipartBody.Part) args[2]);
        return anInterface.updateUserInfoById((Map<String, RequestBody>) args[0],(MultipartBody.Part) args[1]);
    }
}
