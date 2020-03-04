package com.example.master.byd.bean;

/**
 * @author byd
 * @date 2019/6/17 15:51
 */
public class UserInfo {

    /**
     * data : {"id":"d295b5f7-3e1f-11e9-94c1-0242ac110002","loginName":"admin","realName":"管理员","password":"e10adc3949ba59abbe56e057f20f883e","confirmPassword":null,"newPassword":null,"confirmNewPassword":null,"parentId":null,"organizationId":null,"organizationName":null,"phoneNumber":"2323232323","state":0,"createTime":"2019-03-04 00:00:00","updateTime":"2019-03-06 00:00:00","createUserId":"d295b5f7-3e1f-11e9-94c1-0242ac110002","sfzhm":"370922197608116953","sfsmrz":null,"rzjg":null,"updateUserId":"d295b5f7-3e1f-11e9-94c1-0242ac110002","lastLoginTime":null,"remark":"系统初始化","nc":"大龙","txSta":"1","tx":"http://47.110.150.232:9999//tx/d295b5f7-3e1f-11e9-94c1-0242ac110002","email":"2323232323"}
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
         * id : d295b5f7-3e1f-11e9-94c1-0242ac110002
         * loginName : admin
         * realName : 管理员
         * password : e10adc3949ba59abbe56e057f20f883e
         * confirmPassword : null
         * newPassword : null
         * confirmNewPassword : null
         * parentId : null
         * organizationId : null
         * organizationName : null
         * phoneNumber : 2323232323
         * state : 0
         * createTime : 2019-03-04 00:00:00
         * updateTime : 2019-03-06 00:00:00
         * createUserId : d295b5f7-3e1f-11e9-94c1-0242ac110002
         * sfzhm : 370922197608116953
         * sfsmrz : null
         * rzjg : null
         * updateUserId : d295b5f7-3e1f-11e9-94c1-0242ac110002
         * lastLoginTime : null
         * remark : 系统初始化
         * nc : 大龙
         * txSta : 1
         * tx : http://47.110.150.232:9999//tx/d295b5f7-3e1f-11e9-94c1-0242ac110002
         * email : 2323232323
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
