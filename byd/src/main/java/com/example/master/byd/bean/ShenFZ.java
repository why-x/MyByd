package com.example.master.byd.bean;

/**
 * @author byd
 * @date 2019/6/28 19:04
 */
public class ShenFZ {

    /**
     * code : 200
     * msg : 成功
     * data : {"姓名":"王三","民族":"汉","住址":"江西省九江市彭泽县*****七组","公民身份号码":"36043019930606****","出生":"19930606","性别":"男"}
     * ordersign : 20181221164111953170572382923913
     */

    private int code;
    private String msg;
    private DataBean data;
    private String ordersign;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getOrdersign() {
        return ordersign;
    }

    public void setOrdersign(String ordersign) {
        this.ordersign = ordersign;
    }

    public static class DataBean {
        /**
         * 姓名 : 王三
         * 民族 : 汉
         * 住址 : 江西省九江市彭泽县*****七组
         * 公民身份号码 : 36043019930606****
         * 出生 : 19930606
         * 性别 : 男
         */

        private String 姓名;
        private String 民族;
        private String 住址;
        private String 公民身份号码;
        private String 出生;
        private String 性别;

        public String get姓名() {
            return 姓名;
        }

        public void set姓名(String 姓名) {
            this.姓名 = 姓名;
        }

        public String get民族() {
            return 民族;
        }

        public void set民族(String 民族) {
            this.民族 = 民族;
        }

        public String get住址() {
            return 住址;
        }

        public void set住址(String 住址) {
            this.住址 = 住址;
        }

        public String get公民身份号码() {
            return 公民身份号码;
        }

        public void set公民身份号码(String 公民身份号码) {
            this.公民身份号码 = 公民身份号码;
        }

        public String get出生() {
            return 出生;
        }

        public void set出生(String 出生) {
            this.出生 = 出生;
        }

        public String get性别() {
            return 性别;
        }

        public void set性别(String 性别) {
            this.性别 = 性别;
        }
    }
}
