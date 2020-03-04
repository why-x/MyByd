package com.example.master.byd.uitls.util;

import android.text.TextUtils;

/**
 * @author byd
 * @date 2019/6/18 10:30
 */
public class RegisterUtil {
    public static boolean isMobileNO(String mobileNums) {
        /**
         * 判断字符串是否符合手机号码格式
         * 移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
         * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
         * 电信号段: 133,149,153,170,173,177,180,181,189
         * @param str
         * @return 待检测的字符串
         */
        String telRegex = "^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums)) {
            ToastUtils.showShort("手机号不能为空");
            return false;
        } else {
            boolean matches = mobileNums.matches(telRegex);
            if (matches) {
                return true;
            } else {
                ToastUtils.showShort("请输入正确的手机号");

                return false;
            }
//            return mobileNums.matches(telRegex);
//            if (mobileNums.matches(telRegex)){
//
//            }
        }
    }

    public static boolean isLegalId(String id) {
//        if (id.toUpperCase().matches("(^\\d{15}$)|(^\\d{17}([0-9]|X)$)")) {
////            ToastUtils.showShort("身份证号不能为空");
//
//            return true;
//        } else {
//            ToastUtils.showShort("请输入正确的身份证号");
//
//            return false;
//        }
        if (TextUtils.isEmpty(id)) {
            ToastUtils.showShort("身份证号不能为空");

            return false;
        } else {
            boolean matches = id.toUpperCase().matches("(^\\d{15}$)|(^\\d{17}([0-9]|X)$)");
            if (matches) {
                return true;
            } else {
                ToastUtils.showShort("请输入正确的身份证号");

                return false;
            }

        }
    }

    public static boolean isyzId(String id) {
        if (TextUtils.isEmpty(id)) {
            ToastUtils.showShort("验证码不能为空");

            return false;
        } else {
            if (id.length() >= 3) {
                return true;
            } else {
                ToastUtils.showShort("请输入正确的验证码");

                return false;
            }

        }
    }


    public static boolean isLegalName(String name) {
        if (name.contains("·") || name.contains("•")) {
            if (name.matches("^[\\u4e00-\\u9fa5]+[·•][\\u4e00-\\u9fa5]+$")) {
                return true;
            } else {
                ToastUtils.showShort("duima");
                return false;
            }
        } else {
            if (name.matches("^[\\u4e00-\\u9fa5]+$")&&name.length()>=2) {
                return true;
            } else {
                ToastUtils.showShort("请输入正确的姓名");
                return false;
            }
        }
    }
}
