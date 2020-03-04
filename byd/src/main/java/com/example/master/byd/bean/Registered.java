package com.example.master.byd.bean;

/**
 * @author byd
 * @date 2019/6/18 14:49
 */
public class Registered {
    /**
     * data : {"id":"669d354eee6541d3a74061995503a8e4","loginName":"13505143940","realName":"ssss","password":"385D04E7683A033FCC6C6654529EB7E9","confirmPassword":null,"newPassword":null,"confirmNewPassword":null,"parentId":null,"organizationId":null,"organizationName":null,"phoneNumber":"13505143940","state":0,"createTime":"2019-05-22 14:56:05","updateTime":null,"createUserId":null,"sfzhm":"320321199701140416","sfsmrz":"null（是否认证）","rzjg":null,"updateUserId":null,"lastLoginTime":"2019-05-28 10:35:58","remark":null,"nc":null,"tx":null}
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
         * id : 669d354eee6541d3a74061995503a8e4
         * loginName : 13505143940
         * realName : ssss
         * password : 385D04E7683A033FCC6C6654529EB7E9
         * confirmPassword : null
         * newPassword : null
         * confirmNewPassword : null
         * parentId : null
         * organizationId : null
         * organizationName : null
         * phoneNumber : 13505143940
         * state : 0
         * createTime : 2019-05-22 14:56:05
         * updateTime : null
         * createUserId : null
         * sfzhm : 320321199701140416
         * sfsmrz : null（是否认证）
         * rzjg : null
         * updateUserId : null
         * lastLoginTime : 2019-05-28 10:35:58
         * remark : null
         * nc : null
         * tx : null
         */

        private String id;
        private String loginName;
        private String realName;
        private String password;
        private Object confirmPassword;
        private Object newPassword;
        private Object confirmNewPassword;
        private Object parentId;
        private Object organizationId;
        private Object organizationName;
        private String phoneNumber;
        private int state;
        private String createTime;
        private Object updateTime;
        private Object createUserId;
        private String sfzhm;
        private String sfsmrz;
        private Object rzjg;
        private Object updateUserId;
        private String lastLoginTime;
        private Object remark;
        private Object nc;
        private Object tx;

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

        public Object getConfirmPassword() {
            return confirmPassword;
        }

        public void setConfirmPassword(Object confirmPassword) {
            this.confirmPassword = confirmPassword;
        }

        public Object getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(Object newPassword) {
            this.newPassword = newPassword;
        }

        public Object getConfirmNewPassword() {
            return confirmNewPassword;
        }

        public void setConfirmNewPassword(Object confirmNewPassword) {
            this.confirmNewPassword = confirmNewPassword;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public Object getOrganizationId() {
            return organizationId;
        }

        public void setOrganizationId(Object organizationId) {
            this.organizationId = organizationId;
        }

        public Object getOrganizationName() {
            return organizationName;
        }

        public void setOrganizationName(Object organizationName) {
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

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(Object createUserId) {
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

        public Object getRzjg() {
            return rzjg;
        }

        public void setRzjg(Object rzjg) {
            this.rzjg = rzjg;
        }

        public Object getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(Object updateUserId) {
            this.updateUserId = updateUserId;
        }

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getNc() {
            return nc;
        }

        public void setNc(Object nc) {
            this.nc = nc;
        }

        public Object getTx() {
            return tx;
        }

        public void setTx(Object tx) {
            this.tx = tx;
        }
    }
}
