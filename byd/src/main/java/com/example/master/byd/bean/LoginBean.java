package com.example.master.byd.bean;

/**
 * @author byd
 * @date 2019/6/18 14:40
 */
public class LoginBean {
        /**
         * data : {"id":"2466a250e4ab4247accc3b43eb2b2f87","loginName":"13382406330","realName":"test","password":null,"confirmPassword":null,"newPassword":null,"confirmNewPassword":null,"parentId":null,"organizationId":null,"organizationName":null,"phoneNumber":"13382406330","state":0,"createTime":"2019-06-17 17:35:25","updateTime":null,"createUserId":null,"sfzhm":"123","sfsmrz":null,"rzjg":null,"updateUserId":null,"lastLoginTime":"2019-06-18 14:39:16","remark":null,"nc":null,"txSta":null,"tx":null,"email":null}
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
             * id : 2466a250e4ab4247accc3b43eb2b2f87
             * loginName : 13382406330
             * realName : test
             * password : null
             * confirmPassword : null
             * newPassword : null
             * confirmNewPassword : null
             * parentId : null
             * organizationId : null
             * organizationName : null
             * phoneNumber : 13382406330
             * state : 0
             * createTime : 2019-06-17 17:35:25
             * updateTime : null
             * createUserId : null
             * sfzhm : 123  身份证号
             * sfsmrz : null  是否实名认证
             * rzjg : null  认证结果
             * updateUserId : null
             * lastLoginTime : 2019-06-18 14:39:16
             * remark : null
             * nc : null
             * txSta : null
             * tx : null
             * email : null
             */

            private String id;
            private String loginName;
            private String realName;
            private String password;
            private String confirmPassword;
            private String newPassword;
            private String confirmNewPassword;
            private String parentId;
            private String organizationId;
            private String organizationName;
            private String phoneNumber;
            private int state;
            private String createTime;
            private String updateTime;
            private String createUserId;
            private String sfzhm;
            private String sfsmrz;
            private String rzjg;
            private String updateUserId;
            private String lastLoginTime;
            private String remark;
            private String nc;
            private String txSta;
            private String tx;
            private String email;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLoginName() {
                return loginName;
            }

            public void setLoginName(String loginName) {
                this.loginName = loginName;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getConfirmPassword() {
                return confirmPassword;
            }

            public void setConfirmPassword(String confirmPassword) {
                this.confirmPassword = confirmPassword;
            }

            public String getNewPassword() {
                return newPassword;
            }

            public void setNewPassword(String newPassword) {
                this.newPassword = newPassword;
            }

            public String getConfirmNewPassword() {
                return confirmNewPassword;
            }

            public void setConfirmNewPassword(String confirmNewPassword) {
                this.confirmNewPassword = confirmNewPassword;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getOrganizationId() {
                return organizationId;
            }

            public void setOrganizationId(String organizationId) {
                this.organizationId = organizationId;
            }

            public String getOrganizationName() {
                return organizationName;
            }

            public void setOrganizationName(String organizationName) {
                this.organizationName = organizationName;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(String createUserId) {
                this.createUserId = createUserId;
            }

            public String getSfzhm() {
                return sfzhm;
            }

            public void setSfzhm(String sfzhm) {
                this.sfzhm = sfzhm;
            }

            public String getSfsmrz() {
                return sfsmrz;
            }

            public void setSfsmrz(String sfsmrz) {
                this.sfsmrz = sfsmrz;
            }

            public String getRzjg() {
                return rzjg;
            }

            public void setRzjg(String rzjg) {
                this.rzjg = rzjg;
            }

            public String getUpdateUserId() {
                return updateUserId;
            }

            public void setUpdateUserId(String updateUserId) {
                this.updateUserId = updateUserId;
            }

            public String getLastLoginTime() {
                return lastLoginTime;
            }

            public void setLastLoginTime(String lastLoginTime) {
                this.lastLoginTime = lastLoginTime;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getNc() {
                return nc;
            }

            public void setNc(String nc) {
                this.nc = nc;
            }

            public String getTxSta() {
                return txSta;
            }

            public void setTxSta(String txSta) {
                this.txSta = txSta;
            }

            public String getTx() {
                return tx;
            }

            public void setTx(String tx) {
                this.tx = tx;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }
        }
}
