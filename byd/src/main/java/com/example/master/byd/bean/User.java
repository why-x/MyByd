package com.example.master.byd.bean;

/**
 * @author byd
 * @date 2019/6/27 20:00
 */
public class User {
    String name;
    String idnumber;

    public User(String name, String idnumber) {
        this.name = name;
        this.idnumber = idnumber;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdnumber() {
        return idnumber == null ? "" : idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }
}
