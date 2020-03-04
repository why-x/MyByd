package com.example.master.byd.bean;

/**
 * Created by shaowen.jiang@wellcare.cn on 2019/5/17.
 */
public class Result<T> {
//    String status;
//    String message;
//    T result;
    /**
     * success : true
     * resultMsg : 成功
     * errorCode : 200
     * mapResult : {"data":{"zl":"滨州市黄河十六路1108号老年公寓2号楼1-601","bdczsh":"鲁(2019)滨州市不动产权第0001048号","qlr":"滨州市皓森置业有限公司","bdcdyh":"371602007034GB00008F00021061","qlmj":124.15}}
     */

    private boolean success;
    private String resultMsg;
    private int errorCode;
    private T mapResult;
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


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResultMsg() {
        return resultMsg == null ? "" : resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getMapResult() {
        return mapResult;
    }

    public void setMapResult(T mapResult) {
        this.mapResult = mapResult;
    }

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

        private String name;
        private String minz;
        private String place;
        private String sfznum;
        private String cs;
        private String sex;

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMinz() {
            return minz == null ? "" : minz;
        }

        public void setMinz(String minz) {
            this.minz = minz;
        }

        public String getPlace() {
            return place == null ? "" : place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getSfznum() {
            return sfznum == null ? "" : sfznum;
        }

        public void setSfznum(String sfznum) {
            this.sfznum = sfznum;
        }

        public String getCs() {
            return cs == null ? "" : cs;
        }

        public void setCs(String cs) {
            this.cs = cs;
        }

        public String getSex() {
            return sex == null ? "" : sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
