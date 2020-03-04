package com.example.master.byd.bean;

/**
 * @author byd
 * @date 2019/6/18 15:18
 */
public class SMSLoge {

        /**
         * data : {"MESSAGE_AUTH_ERRORCODE":"短信获取成功"}
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
             * MESSAGE_AUTH_ERRORCODE : 短信获取成功
             */

            private String MESSAGE_AUTH_ERRORCODE;

            public String getMESSAGE_AUTH_ERRORCODE() {
                return MESSAGE_AUTH_ERRORCODE;
            }

            public void setMESSAGE_AUTH_ERRORCODE(String MESSAGE_AUTH_ERRORCODE) {
                this.MESSAGE_AUTH_ERRORCODE = MESSAGE_AUTH_ERRORCODE;
            }
        }
}
