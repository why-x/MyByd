package com.example.master.byd.uitls;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.SPUtils;
import com.example.master.byd.bean.UserInfo;

/**
 * @author byd
 * @date 2019/6/28 11:15
 */
public class UserInfoManager {


    public static void setUserInfo(UserInfo userInfo) {

        SPUtils.getInstance().put("userinfo", GsonUtils.toJson(userInfo));

    }


    public static UserInfo getUserInfo() {

        return GsonUtils.fromJson(SPUtils.getInstance().getString("userinfo", GsonUtils.toJson(new UserInfo())), UserInfo.class);

    }


}
