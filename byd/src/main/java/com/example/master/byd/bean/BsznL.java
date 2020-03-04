package com.example.master.byd.bean;

import java.util.List;

/**
 * @author byd
 * @date 2019/6/4 17:49
 */
public class BsznL {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 6
             * bdclx : f
             * ywdl : 转移类
             * ywlx : 303
             * ywlxmc : 新建商品房转移（开发商自己办证）
             * ywdlmc : 转移类
             * ywlj : xjspfzydj_ysf
             * sfqy : 1
             * sfjsbj : 1
             * sfcyyw : null
             * fwlx : 1
             * xh : 101
             * yhlx : 1
             * bsznDo : null
             */

            private String id;
            private String bdclx;
            private String ywdl;
            private String ywlx;
            private String ywlxmc;
            private String ywdlmc;
            private String ywlj;
            private String sfqy;
            private String sfjsbj;
            private Object sfcyyw;
            private String fwlx;
            private int xh;
            private String yhlx;
            private Object bsznDo;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBdclx() {
                return bdclx;
            }

            public void setBdclx(String bdclx) {
                this.bdclx = bdclx;
            }

            public String getYwdl() {
                return ywdl;
            }

            public void setYwdl(String ywdl) {
                this.ywdl = ywdl;
            }

            public String getYwlx() {
                return ywlx;
            }

            public void setYwlx(String ywlx) {
                this.ywlx = ywlx;
            }

            public String getYwlxmc() {
                return ywlxmc;
            }

            public void setYwlxmc(String ywlxmc) {
                this.ywlxmc = ywlxmc;
            }

            public String getYwdlmc() {
                return ywdlmc;
            }

            public void setYwdlmc(String ywdlmc) {
                this.ywdlmc = ywdlmc;
            }

            public String getYwlj() {
                return ywlj;
            }

            public void setYwlj(String ywlj) {
                this.ywlj = ywlj;
            }

            public String getSfqy() {
                return sfqy;
            }

            public void setSfqy(String sfqy) {
                this.sfqy = sfqy;
            }

            public String getSfjsbj() {
                return sfjsbj;
            }

            public void setSfjsbj(String sfjsbj) {
                this.sfjsbj = sfjsbj;
            }

            public Object getSfcyyw() {
                return sfcyyw;
            }

            public void setSfcyyw(Object sfcyyw) {
                this.sfcyyw = sfcyyw;
            }

            public String getFwlx() {
                return fwlx;
            }

            public void setFwlx(String fwlx) {
                this.fwlx = fwlx;
            }

            public int getXh() {
                return xh;
            }

            public void setXh(int xh) {
                this.xh = xh;
            }

            public String getYhlx() {
                return yhlx;
            }

            public void setYhlx(String yhlx) {
                this.yhlx = yhlx;
            }

            public Object getBsznDo() {
                return bsznDo;
            }

            public void setBsznDo(Object bsznDo) {
                this.bsznDo = bsznDo;
            }
        }
}
