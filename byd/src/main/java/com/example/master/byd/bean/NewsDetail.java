package com.example.master.byd.bean;

/**
 * @author byd
 * @date 2019/6/5 10:55
 */
public class NewsDetail {

        /**
         * data : {"id":"00004","title":"小说","sendOrganizationName":null,"sendUserId":null,"sendUserName":null,"businessType":0,"type":"书籍 ","newsContent":null,"state":0,"deleteState":null,"createTime":"2019-06-04 00:00:00","sendTime":null,"offtime":null,"imgPath":"C:\\Users\\Public\\Pictures\\Sample Pictures\\1.png"}
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
             * id : 00004
             * title : 小说
             * sendOrganizationName : null
             * sendUserId : null
             * sendUserName : null
             * businessType : 0
             * type : 书籍
             * newsContent : null
             * state : 0
             * deleteState : null
             * createTime : 2019-06-04 00:00:00
             * sendTime : null
             * offtime : null
             * imgPath : C:\Users\Public\Pictures\Sample Pictures\1.png
             */

            private String id;
            private String title;
            private Object sendOrganizationName;
            private Object sendUserId;
            private Object sendUserName;
            private int businessType;
            private String type;
            private String newsContent;
            private int state;
            private Object deleteState;
            private String createTime;
            private Object sendTime;
            private Object offtime;
            private String imgPath;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getSendOrganizationName() {
                return sendOrganizationName;
            }

            public void setSendOrganizationName(Object sendOrganizationName) {
                this.sendOrganizationName = sendOrganizationName;
            }

            public Object getSendUserId() {
                return sendUserId;
            }

            public void setSendUserId(Object sendUserId) {
                this.sendUserId = sendUserId;
            }

            public Object getSendUserName() {
                return sendUserName;
            }

            public void setSendUserName(Object sendUserName) {
                this.sendUserName = sendUserName;
            }

            public int getBusinessType() {
                return businessType;
            }

            public void setBusinessType(int businessType) {
                this.businessType = businessType;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNewsContent() {
                return newsContent;
            }

            public void setNewsContent(String newsContent) {
                this.newsContent = newsContent;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public Object getDeleteState() {
                return deleteState;
            }

            public void setDeleteState(Object deleteState) {
                this.deleteState = deleteState;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getSendTime() {
                return sendTime;
            }

            public void setSendTime(Object sendTime) {
                this.sendTime = sendTime;
            }

            public Object getOfftime() {
                return offtime;
            }

            public void setOfftime(Object offtime) {
                this.offtime = offtime;
            }

            public String getImgPath() {
                return imgPath;
            }

            public void setImgPath(String imgPath) {
                this.imgPath = imgPath;
            }
        }
}
