package com.example.master.byd.bean;

/**
 * @author byd
 * @date 2019/6/27 18:40
 */
public class GetTokenResponse {


    private String ticketId;
    private String biz;
    private String token;

    public String getTicketId() {
        return ticketId == null ? "" : ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getBiz() {
        return biz == null ? "" : biz;
    }

    public void setBiz(String biz) {
        this.biz = biz;
    }

    public String getToken() {
        return token == null ? "" : token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
