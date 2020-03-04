package com.example.master.byd.bean;

import java.util.List;

/**
 * @author byd
 * @date 2019/6/5 17:01
 */
public class MyYwlx {

        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * list : [{"id":"6","bdclx":"t","ywdl":"首次登记","ywlx":"17","ywlxmc":"在建建筑物抵押权首次登记（土地）","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":201,"yhlx":"1","bsznDo":null},{"id":"8","bdclx":"t","ywdl":"首次登记","ywlx":"28","ywlxmc":"土地使用权抵押权首次登记（含林地）","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":203,"yhlx":"1","bsznDo":null},{"id":"9","bdclx":"t","ywdl":"首次登记","ywlx":"22","ywlxmc":"宅基地使用权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":204,"yhlx":"1","bsznDo":null},{"id":"10","bdclx":"f","ywdl":"首次登记","ywlx":"29","ywlxmc":"国有建设用地使用权及房屋所有权抵押权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":205,"yhlx":"1","bsznDo":null},{"id":"11","bdclx":"h","ywdl":"首次登记","ywlx":"18","ywlxmc":"海域使用权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":206,"yhlx":"1","bsznDo":null},{"id":"12","bdclx":"t","ywdl":"首次登记","ywlx":"25","ywlxmc":"地役权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":207,"yhlx":"1","bsznDo":null},{"id":"13","bdclx":"f","ywdl":"首次登记","ywlx":"68","ywlxmc":"多幢房屋首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"0","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":208,"yhlx":"1","bsznDo":null},{"id":"14","bdclx":"f","ywdl":"首次登记","ywlx":"26","ywlxmc":"国有建设用地使用权及房屋所有权首次登记","ywdlmc":"首次登记","ywlj":"xjspfzydj_ysf","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":209,"yhlx":"1","bsznDo":null},{"id":"15","bdclx":"t","ywdl":"首次登记","ywlx":"16","ywlxmc":"国有建设用地使用权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":210,"yhlx":"1","bsznDo":null},{"id":"16","bdclx":"t","ywdl":"首次登记","ywlx":"7","ywlxmc":"土地承包经营权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":211,"yhlx":"1","bsznDo":null},{"id":"17","bdclx":"f","ywdl":"首次登记","ywlx":"12","ywlxmc":"集体建设用地使用权及房屋所有权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"0","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":212,"yhlx":"1","bsznDo":null},{"id":"18","bdclx":"t","ywdl":"首次登记","ywlx":"2","ywlxmc":"集体土地所有权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":213,"yhlx":"1","bsznDo":null},{"id":"19","bdclx":"f","ywdl":"首次登记","ywlx":"119","ywlxmc":"商品房抵押首次登记（银行）","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":214,"yhlx":"1","bsznDo":null},{"id":"20","bdclx":"f","ywdl":"首次登记","ywlx":"67","ywlxmc":"在建建筑物抵押权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":215,"yhlx":"1","bsznDo":null},{"id":"21","bdclx":"l","ywdl":"首次登记","ywlx":"85","ywlxmc":"林权抵押登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":216,"yhlx":"1","bsznDo":null},{"id":"22","bdclx":"f","ywdl":"首次登记","ywlx":"95","ywlxmc":"不动产确权首次登记（企业/办公楼）","ywdlmc":"首次登记","ywlj":"","sfqy":"0","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":217,"yhlx":"1","bsznDo":null},{"id":"23","bdclx":"t","ywdl":"首次登记","ywlx":"104","ywlxmc":"土地承包经营权/森林、林木所有权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":218,"yhlx":"1","bsznDo":null},{"id":"24","bdclx":"f","ywdl":"首次登记","ywlx":"24","ywlxmc":"宅基地使用权及房屋所有权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"0","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":219,"yhlx":"1","bsznDo":null},{"id":"25","bdclx":"f","ywdl":"首次登记","ywlx":"27","ywlxmc":"独幢首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"0","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":220,"yhlx":"1","bsznDo":null},{"id":"26","bdclx":"t","ywdl":"首次登记","ywlx":"21","ywlxmc":"集体建设用地使用权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":221,"yhlx":"1","bsznDo":null},{"id":"27","bdclx":"f","ywdl":"首次登记","ywlx":"71","ywlxmc":"预告抵押权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":222,"yhlx":"1","bsznDo":null},{"id":"28","bdclx":"t","ywdl":"首次登记","ywlx":"107","ywlxmc":"林地使用权/森林、林木使用权首次登记","ywdlmc":"首次登记","ywlj":"","sfqy":"1","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":223,"yhlx":"1","bsznDo":null},{"id":"29","bdclx":"f","ywdl":"首次登记","ywlx":"89","ywlxmc":"国有建设用地使用权及房屋所有权抵押首次登记(幢)_停","ywdlmc":"首次登记","ywlj":"","sfqy":"0","sfjsbj":"1","sfcyyw":"","fwlx":"1","xh":224,"yhlx":"1","bsznDo":null}]
             * ywdl : 首次登记
             */

            private String ywdl;
            private List<ListBean> list;

            public String getYwdl() {
                return ywdl;
            }

            public void setYwdl(String ywdl) {
                this.ywdl = ywdl;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * id : 6
                 * bdclx : t
                 * ywdl : 首次登记
                 * ywlx : 17
                 * ywlxmc : 在建建筑物抵押权首次登记（土地）
                 * ywdlmc : 首次登记
                 * ywlj :
                 * sfqy : 1
                 * sfjsbj : 1
                 * sfcyyw :
                 * fwlx : 1
                 * xh : 201
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
                private String sfcyyw;
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

                public String getSfcyyw() {
                    return sfcyyw;
                }

                public void setSfcyyw(String sfcyyw) {
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
}
