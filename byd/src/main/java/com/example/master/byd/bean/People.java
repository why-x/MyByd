package com.example.master.byd.bean;

import java.io.Serializable;

/**
 * @author byd
 * @date 2019/6/29 15:21
 */
public class People implements Serializable {
    private String name;
    private String sfznum;
    private String place;
    private String phonenum;

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSfznum() {
        return sfznum == null ? "" : sfznum;
    }

    public void setSfznum(String sfznum) {
        this.sfznum = sfznum;
    }

    public String getPlace() {
        return place == null ? "" : place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhonenum() {
        return phonenum == null ? "" : phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public People(String name, String sfznum, String place, String phonenum) {
        this.name = name;
        this.sfznum = sfznum;
        this.place = place;
        this.phonenum = phonenum;
    }
}
