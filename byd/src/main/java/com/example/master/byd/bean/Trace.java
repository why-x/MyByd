package com.example.master.byd.bean;

/**
 * 实时追踪物流
 * 作者： 周旭 on 2017/5/15/0015.
 * 邮箱：374952705@qq.com
 * 博客：http://www.jianshu.com/u/56db5d78044d
 */

public class Trace {
    private int type; //类型，0：当前位置（最新的一条物流信息），1：历史记录
    private String acceptData; //接收时间
    private String acceptTime; //接收时间
    private String statu; //状态

    private String acceptStation; //接收站点和描述
    public Trace() {

    }

    public Trace(int type, String acceptData, String acceptTime, String statu, String acceptStation) {
        this.type = type;
        this.acceptData = acceptData;
        this.acceptTime = acceptTime;
        this.statu = statu;
        this.acceptStation = acceptStation;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAcceptData() {
        return acceptData == null ? "" : acceptData;
    }

    public void setAcceptData(String acceptData) {
        this.acceptData = acceptData;
    }

    public String getAcceptTime() {
        return acceptTime == null ? "" : acceptTime;
    }

    public void setAcceptTime(String acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getStatu() {
        return statu == null ? "" : statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getAcceptStation() {
        return acceptStation == null ? "" : acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation;
    }
}
