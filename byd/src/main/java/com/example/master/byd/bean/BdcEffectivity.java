package com.example.master.byd.bean;

/**
 * @author byd
 * @date 2019/6/28 15:15
 */
public class BdcEffectivity {
    /**
     * data : {"result":"success","sjjy":{"mfzghy":"1","tdxxhy_cn":"土地信息核验成功","fyxxhy_cn":"房源信息核验成功","dycfhy_cn":"抵押查封核验成功","dycfhy":"1","tdxxhy":"1","fyxxhy":"1","mfzghy_cn":"卖方资格核验成功"},"warnResultMsg":"","qlr":{"IDNUMBER":"372301199208102911","NAME":"胡振民"}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * result : success
         * sjjy : {"mfzghy":"1","tdxxhy_cn":"土地信息核验成功","fyxxhy_cn":"房源信息核验成功","dycfhy_cn":"抵押查封核验成功","dycfhy":"1","tdxxhy":"1","fyxxhy":"1","mfzghy_cn":"卖方资格核验成功"}
         * warnResultMsg :
         * qlr : {"IDNUMBER":"372301199208102911","NAME":"胡振民"}
         */

        private String result;
        private SjjyBean sjjy;
        private String warnResultMsg;
        private QlrBean qlr;

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public SjjyBean getSjjy() {
            return sjjy;
        }

        public void setSjjy(SjjyBean sjjy) {
            this.sjjy = sjjy;
        }

        public String getWarnResultMsg() {
            return warnResultMsg;
        }

        public void setWarnResultMsg(String warnResultMsg) {
            this.warnResultMsg = warnResultMsg;
        }

        public QlrBean getQlr() {
            return qlr;
        }

        public void setQlr(QlrBean qlr) {
            this.qlr = qlr;
        }

        public static class SjjyBean {
            /**
             * mfzghy : 1
             * tdxxhy_cn : 土地信息核验成功
             * fyxxhy_cn : 房源信息核验成功
             * dycfhy_cn : 抵押查封核验成功
             * dycfhy : 1
             * tdxxhy : 1
             * fyxxhy : 1
             * mfzghy_cn : 卖方资格核验成功
             */

            private String mfzghy;
            private String tdxxhy_cn;
            private String fyxxhy_cn;
            private String dycfhy_cn;
            private String dycfhy;
            private String tdxxhy;
            private String fyxxhy;
            private String mfzghy_cn;

            public String getMfzghy() {
                return mfzghy;
            }

            public void setMfzghy(String mfzghy) {
                this.mfzghy = mfzghy;
            }

            public String getTdxxhy_cn() {
                return tdxxhy_cn;
            }

            public void setTdxxhy_cn(String tdxxhy_cn) {
                this.tdxxhy_cn = tdxxhy_cn;
            }

            public String getFyxxhy_cn() {
                return fyxxhy_cn;
            }

            public void setFyxxhy_cn(String fyxxhy_cn) {
                this.fyxxhy_cn = fyxxhy_cn;
            }

            public String getDycfhy_cn() {
                return dycfhy_cn;
            }

            public void setDycfhy_cn(String dycfhy_cn) {
                this.dycfhy_cn = dycfhy_cn;
            }

            public String getDycfhy() {
                return dycfhy;
            }

            public void setDycfhy(String dycfhy) {
                this.dycfhy = dycfhy;
            }

            public String getTdxxhy() {
                return tdxxhy;
            }

            public void setTdxxhy(String tdxxhy) {
                this.tdxxhy = tdxxhy;
            }

            public String getFyxxhy() {
                return fyxxhy;
            }

            public void setFyxxhy(String fyxxhy) {
                this.fyxxhy = fyxxhy;
            }

            public String getMfzghy_cn() {
                return mfzghy_cn;
            }

            public void setMfzghy_cn(String mfzghy_cn) {
                this.mfzghy_cn = mfzghy_cn;
            }
        }

        public static class QlrBean {
            /**
             * IDNUMBER : 372301199208102911
             * NAME : 胡振民
             */

            private String IDNUMBER;
            private String NAME;

            public String getIDNUMBER() {
                return IDNUMBER;
            }

            public void setIDNUMBER(String IDNUMBER) {
                this.IDNUMBER = IDNUMBER;
            }

            public String getNAME() {
                return NAME;
            }

            public void setNAME(String NAME) {
                this.NAME = NAME;
            }
        }
    }
}
