package com.example.master.byd.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shaowen.jiang@wellcare.cn on 2019-06-27.
 */
public class ZhengshuInfoResponse {

    private  DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {


        private String dzzs;
        private List<String> dy;

        public String getDzzs() {
            return dzzs == null ? "" : dzzs;
        }

        public void setDzzs(String dzzs) {
            this.dzzs = dzzs;
        }

        public List<String> getDy() {
            if (dy == null) {
                return new ArrayList<>();
            }
            return dy;
        }

        public void setDy(List<String> dy) {
            this.dy = dy;
        }
    }
}
