package com.example.master.byd.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author byd
 * @date 2019/6/27 11:15
 */
public class MyRealEstate {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean implements Serializable {
            /**
             * zl : 滨州市渤海二十二路618号明日星城31号楼33
             * qlr : 郭娟娟
             * bdcdyh : 371602111013GB00002F00310033
             * qqh :
             * zjh : 372301198803181445
             * zs : 鲁(2019)滨州市不动产权第0007157号
             */

            private String zl;
            private String qlr;
            private String bdcdyh;
            private String qqh;
            private String zjh;
            private String zs;

            public String getZl() {
                return zl;
            }

            public void setZl(String zl) {
                this.zl = zl;
            }

            public String getQlr() {
                return qlr;
            }

            public void setQlr(String qlr) {
                this.qlr = qlr;
            }

            public String getBdcdyh() {
                return bdcdyh;
            }

            public void setBdcdyh(String bdcdyh) {
                this.bdcdyh = bdcdyh;
            }

            public String getQqh() {
                return qqh;
            }

            public void setQqh(String qqh) {
                this.qqh = qqh;
            }

            public String getZjh() {
                return zjh;
            }

            public void setZjh(String zjh) {
                this.zjh = zjh;
            }

            public String getZs() {
                return zs;
            }

            public void setZs(String zs) {
                this.zs = zs;
            }
        }
}
