package com.example.master.byd.bean;

import java.util.List;

/**
 * @author byd
 * @date 2019/6/4 16:49
 */
public class About {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1
             * dwmc : test
             * dwdz : test
             * x : 1
             * y : 1
             * email : adsf
             * lxdh : test
             * sfqy : 0
             */

            private String id;
            private String dwmc;
            private String dwdz;
            private String x;
            private String y;
            private String email;
            private String lxdh;
            private String sfqy;

            public String getId() {
                return id == null ? "" : id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getDwmc() {
                return dwmc == null ? "" : dwmc;
            }

            public void setDwmc(String dwmc) {
                this.dwmc = dwmc;
            }

            public String getDwdz() {
                return dwdz == null ? "" : dwdz;
            }

            public void setDwdz(String dwdz) {
                this.dwdz = dwdz;
            }

            public String getX() {
                return x == null ? "" : x;
            }

            public void setX(String x) {
                this.x = x;
            }

            public String getY() {
                return y == null ? "" : y;
            }

            public void setY(String y) {
                this.y = y;
            }

            public String getEmail() {
                return email == null ? "" : email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getLxdh() {
                return lxdh == null ? "" : lxdh;
            }

            public void setLxdh(String lxdh) {
                this.lxdh = lxdh;
            }

            public String getSfqy() {
                return sfqy == null ? "" : sfqy;
            }

            public void setSfqy(String sfqy) {
                this.sfqy = sfqy;
            }
        }
}
