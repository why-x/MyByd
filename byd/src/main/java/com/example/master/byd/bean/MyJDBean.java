package com.example.master.byd.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author byd
 * @date 2019/6/19 18:23
 */
public class MyJDBean implements Serializable {
        /**
         * data : {"qlr":"杨阳/张燕","ywlxmc":"转移登记","slbh":"201600006553","spgc":[{"jdms":"","blzt":49,"bljd":"审批","blsj":"2016-10-31 08:41:15"},{"jdms":"","blzt":49,"bljd":"收费","blsj":"2016-11-03 16:25:41"},{"jdms":"","blzt":49,"bljd":"发证","blsj":"2016-11-03 17:11:14"},{"jdms":"","blzt":49,"bljd":"缮证","blsj":"2016-11-03 16:02:57"},{"jdms":"","blzt":49,"bljd":"受理、初审","blsj":"2016-10-27 17:06:20"},{"jdms":"","blzt":49,"bljd":"复审","blsj":"2016-10-31 08:36:05"},{"jdms":"","blzt":49,"bljd":"归档","blsj":"2017-07-25 08:57:53"}]}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean implements Serializable {
            /**
             * qlr : 杨阳/张燕
             * ywlxmc : 转移登记
             * slbh : 201600006553
             * spgc : [{"jdms":"","blzt":49,"bljd":"审批","blsj":"2016-10-31 08:41:15"},{"jdms":"","blzt":49,"bljd":"收费","blsj":"2016-11-03 16:25:41"},{"jdms":"","blzt":49,"bljd":"发证","blsj":"2016-11-03 17:11:14"},{"jdms":"","blzt":49,"bljd":"缮证","blsj":"2016-11-03 16:02:57"},{"jdms":"","blzt":49,"bljd":"受理、初审","blsj":"2016-10-27 17:06:20"},{"jdms":"","blzt":49,"bljd":"复审","blsj":"2016-10-31 08:36:05"},{"jdms":"","blzt":49,"bljd":"归档","blsj":"2017-07-25 08:57:53"}]
             */

            private String qlr;
            private String ywlxmc;
            private String slbh;
            private List<SpgcBean> spgc;

            public String getQlr() {
                return qlr;
            }

            public void setQlr(String qlr) {
                this.qlr = qlr;
            }

            public String getYwlxmc() {
                return ywlxmc;
            }

            public void setYwlxmc(String ywlxmc) {
                this.ywlxmc = ywlxmc;
            }

            public String getSlbh() {
                return slbh;
            }

            public void setSlbh(String slbh) {
                this.slbh = slbh;
            }

            public List<SpgcBean> getSpgc() {
                return spgc;
            }

            public void setSpgc(List<SpgcBean> spgc) {
                this.spgc = spgc;
            }

            public static class SpgcBean  implements Serializable {
                /**
                 * jdms :
                 * blzt : 49
                 * bljd : 审批
                 * blsj : 2016-10-31 08:41:15
                 */

                private String jdms;
                private int blzt;
                private String bljd;
                private String blsj;

                public String getJdms() {
                    return jdms;
                }

                public void setJdms(String jdms) {
                    this.jdms = jdms;
                }

                public int getBlzt() {
                    return blzt;
                }

                public void setBlzt(int blzt) {
                    this.blzt = blzt;
                }

                public String getBljd() {
                    return bljd;
                }

                public void setBljd(String bljd) {
                    this.bljd = bljd;
                }

                public String getBlsj() {
                    return blsj;
                }

                public void setBlsj(String blsj) {
                    this.blsj = blsj;
                }
            }


                    /**
                     * qlr : 中国工商银行股份有限公司滨州滨城支行
                     * ywlxmc : 预告登记
                     * slbh : 201600007371
                     * SPGC : [{"jdms":"","blzt":8,"bljd":"归档","blsj":"2017-01-24 15:03:02"},{"jdms":"","blzt":49,"bljd":"发证","blsj":"2016-12-15 10:10:48"},{"jdms":"","blzt":49,"bljd":"收费","blsj":"2016-11-10 16:49:08"},{"jdms":"","blzt":49,"bljd":"缮证","blsj":"2016-11-10 16:20:46"},{"jdms":"","blzt":49,"bljd":"审批","blsj":"2016-11-07 16:08:24"},{"jdms":"","blzt":49,"bljd":"复审","blsj":"2016-11-07 15:01:50"},{"jdms":"","blzt":49,"bljd":"受理、初审","blsj":"2016-11-02 13:37:23"}]
                     */

                    private List<SpgcBean> SPGC;

                    public List<SpgcBean> getSPGC() {
                        return SPGC;
                    }

                    public void setSPGC(List<SpgcBean> SPGC) {
                        this.SPGC = SPGC;
                    }

        }
}
