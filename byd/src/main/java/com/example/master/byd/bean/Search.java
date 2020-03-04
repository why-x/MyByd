package com.example.master.byd.bean;

import java.util.List;

/**
 * @author byd
 * @date 2019/5/31 17:09
 */
public class Search {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * ff : [{"zl":"滨州市渤海二十二路618号明日星城31号楼33","hruse":"储藏室","bdcdyh":"371602111013GB00002F00310033","qlmj":8.22}]
             * zl : 滨州市渤海二十二路618号明日星城31号楼1-1603
             * qllx : 国有建设用地使用权;房屋所有权
             * qlr : 郭娟娟
             * bdcdyh : 371602111013GB00002F00311163
             * bdczh : 鲁(2019)滨州市不动产权第0007157号
             * qlmj : 90.7
             */

            private String zl;
            private String qllx;
            private String qlr;
            private String bdcdyh;
            private String bdczh;
            private double qlmj;
            private List<FfBean> ff;

            public String getZl() {
                return zl;
            }

            public void setZl(String zl) {
                this.zl = zl;
            }

            public String getQllx() {
                return qllx;
            }

            public void setQllx(String qllx) {
                this.qllx = qllx;
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

            public String getBdczh() {
                return bdczh;
            }

            public void setBdczh(String bdczh) {
                this.bdczh = bdczh;
            }

            public double getQlmj() {
                return qlmj;
            }

            public void setQlmj(double qlmj) {
                this.qlmj = qlmj;
            }

            public List<FfBean> getFf() {
                return ff;
            }

            public void setFf(List<FfBean> ff) {
                this.ff = ff;
            }

            public static class FfBean {
                /**
                 * zl : 滨州市渤海二十二路618号明日星城31号楼33
                 * hruse : 储藏室
                 * bdcdyh : 371602111013GB00002F00310033
                 * qlmj : 8.22
                 */

                private String zl;
                private String hruse;
                private String bdcdyh;
                private double qlmj;

                public String getZl() {
                    return zl;
                }

                public void setZl(String zl) {
                    this.zl = zl;
                }

                public String getHruse() {
                    return hruse;
                }

                public void setHruse(String hruse) {
                    this.hruse = hruse;
                }

                public String getBdcdyh() {
                    return bdcdyh;
                }

                public void setBdcdyh(String bdcdyh) {
                    this.bdcdyh = bdcdyh;
                }

                public double getQlmj() {
                    return qlmj;
                }

                public void setQlmj(double qlmj) {
                    this.qlmj = qlmj;
                }
            }
        }
}
