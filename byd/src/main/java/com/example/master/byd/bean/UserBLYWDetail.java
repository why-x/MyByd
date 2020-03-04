package com.example.master.byd.bean;

import java.util.List;

/**
 * @author byd
 * @date 2019/6/21 18:27
 */
public class UserBLYWDetail {
        /**
         * data : {"SJJY":{"mfzghy":"1","tdxxhy_cn":"土地信息核验成功","fyxxhy_cn":"房源信息核验成功","dycfhy_cn":"抵押查封核验成功","dycfhy":"1","tdxxhy":"1","fyxxhy":"1","mfzghy_cn":"卖方资格核验成功"},"ZL":"滨州市黄河十六路1008号老年公寓2号楼1-601","DJLX":"预告登记","CJJ":null,"BDCQZH":null,"YWLX":"预购商品房预告登记","YWR":[{"qlrid":"04292591a2c44c1a91ba14a6e9741bb7","sqbid":"070e81fd5c9740c2b6683fb66fa52fd6","qlrtype":"YWR","name":"买家","hjszd":"山东","zjlx":"身份证","zjh":"2356","lxdh":"256","dlrid":"032a76ed321148c3ba502fd7ae6e82e5","gyfelx":"单独所有","gyfe":null,"sfcz":"是","hyzk":"未婚","ctime":"2019-06-20T12:26:20.000+0000"}],"QLR":[{"qlrid":"c251e8ac0fa7435d8ee14ba393429e01","sqbid":"070e81fd5c9740c2b6683fb66fa52fd6","qlrtype":"QLR","name":"卖家","hjszd":"滨州","zjlx":"身份证","zjh":"236","lxdh":"256","dlrid":"7880ed6150624b6c80455137f20b3944","gyfelx":"单独所有","gyfe":null,"sfcz":null,"hyzk":null,"ctime":"2019-06-20T12:26:20.000+0000"}],"WSQK":{"BUYER":[],"SELLER":[]},"BDCDYH":"371602007034GB00008F00021061"}
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
             * SJJY : {"mfzghy":"1","tdxxhy_cn":"土地信息核验成功","fyxxhy_cn":"房源信息核验成功","dycfhy_cn":"抵押查封核验成功","dycfhy":"1","tdxxhy":"1","fyxxhy":"1","mfzghy_cn":"卖方资格核验成功"}
             * ZL : 滨州市黄河十六路1008号老年公寓2号楼1-601
             * DJLX : 预告登记
             * CJJ : null
             * BDCQZH : null
             * YWLX : 预购商品房预告登记
             * YWR : [{"qlrid":"04292591a2c44c1a91ba14a6e9741bb7","sqbid":"070e81fd5c9740c2b6683fb66fa52fd6","qlrtype":"YWR","name":"买家","hjszd":"山东","zjlx":"身份证","zjh":"2356","lxdh":"256","dlrid":"032a76ed321148c3ba502fd7ae6e82e5","gyfelx":"单独所有","gyfe":null,"sfcz":"是","hyzk":"未婚","ctime":"2019-06-20T12:26:20.000+0000"}]
             * QLR : [{"qlrid":"c251e8ac0fa7435d8ee14ba393429e01","sqbid":"070e81fd5c9740c2b6683fb66fa52fd6","qlrtype":"QLR","name":"卖家","hjszd":"滨州","zjlx":"身份证","zjh":"236","lxdh":"256","dlrid":"7880ed6150624b6c80455137f20b3944","gyfelx":"单独所有","gyfe":null,"sfcz":null,"hyzk":null,"ctime":"2019-06-20T12:26:20.000+0000"}]
             * WSQK : {"BUYER":[],"SELLER":[]}
             * BDCDYH : 371602007034GB00008F00021061
             */

            private SJJYBean SJJY;
            private String ZL;
            private String DJLX;
            private Object CJJ;
            private Object BDCQZH;
            private String YWLX;
            private WSQKBean WSQK;
            private String BDCDYH;
            private List<YWRBean> YWR;
            private List<QLRBean> QLR;

            public SJJYBean getSJJY() {
                return SJJY;
            }

            public void setSJJY(SJJYBean SJJY) {
                this.SJJY = SJJY;
            }

            public String getZL() {
                return ZL;
            }

            public void setZL(String ZL) {
                this.ZL = ZL;
            }

            public String getDJLX() {
                return DJLX;
            }

            public void setDJLX(String DJLX) {
                this.DJLX = DJLX;
            }

            public Object getCJJ() {
                return CJJ;
            }

            public void setCJJ(Object CJJ) {
                this.CJJ = CJJ;
            }

            public Object getBDCQZH() {
                return BDCQZH;
            }

            public void setBDCQZH(Object BDCQZH) {
                this.BDCQZH = BDCQZH;
            }

            public String getYWLX() {
                return YWLX;
            }

            public void setYWLX(String YWLX) {
                this.YWLX = YWLX;
            }

            public WSQKBean getWSQK() {
                return WSQK;
            }

            public void setWSQK(WSQKBean WSQK) {
                this.WSQK = WSQK;
            }

            public String getBDCDYH() {
                return BDCDYH;
            }

            public void setBDCDYH(String BDCDYH) {
                this.BDCDYH = BDCDYH;
            }

            public List<YWRBean> getYWR() {
                return YWR;
            }

            public void setYWR(List<YWRBean> YWR) {
                this.YWR = YWR;
            }

            public List<QLRBean> getQLR() {
                return QLR;
            }

            public void setQLR(List<QLRBean> QLR) {
                this.QLR = QLR;
            }

            public static class SJJYBean {
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

            public static class WSQKBean {
                private List<?> BUYER;
                private List<?> SELLER;

                public List<?> getBUYER() {
                    return BUYER;
                }

                public void setBUYER(List<?> BUYER) {
                    this.BUYER = BUYER;
                }

                public List<?> getSELLER() {
                    return SELLER;
                }

                public void setSELLER(List<?> SELLER) {
                    this.SELLER = SELLER;
                }
            }

            public static class YWRBean {
                /**
                 * qlrid : 04292591a2c44c1a91ba14a6e9741bb7
                 * sqbid : 070e81fd5c9740c2b6683fb66fa52fd6
                 * qlrtype : YWR
                 * name : 买家
                 * hjszd : 山东
                 * zjlx : 身份证
                 * zjh : 2356
                 * lxdh : 256
                 * dlrid : 032a76ed321148c3ba502fd7ae6e82e5
                 * gyfelx : 单独所有
                 * gyfe : null
                 * sfcz : 是
                 * hyzk : 未婚
                 * ctime : 2019-06-20T12:26:20.000+0000
                 */

                private String qlrid;
                private String sqbid;
                private String qlrtype;
                private String name;
                private String hjszd;
                private String zjlx;
                private String zjh;
                private String lxdh;
                private String dlrid;
                private String gyfelx;
                private Object gyfe;
                private String sfcz;
                private String hyzk;
                private String ctime;

                public String getQlrid() {
                    return qlrid;
                }

                public void setQlrid(String qlrid) {
                    this.qlrid = qlrid;
                }

                public String getSqbid() {
                    return sqbid;
                }

                public void setSqbid(String sqbid) {
                    this.sqbid = sqbid;
                }

                public String getQlrtype() {
                    return qlrtype;
                }

                public void setQlrtype(String qlrtype) {
                    this.qlrtype = qlrtype;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getHjszd() {
                    return hjszd;
                }

                public void setHjszd(String hjszd) {
                    this.hjszd = hjszd;
                }

                public String getZjlx() {
                    return zjlx;
                }

                public void setZjlx(String zjlx) {
                    this.zjlx = zjlx;
                }

                public String getZjh() {
                    return zjh;
                }

                public void setZjh(String zjh) {
                    this.zjh = zjh;
                }

                public String getLxdh() {
                    return lxdh;
                }

                public void setLxdh(String lxdh) {
                    this.lxdh = lxdh;
                }

                public String getDlrid() {
                    return dlrid;
                }

                public void setDlrid(String dlrid) {
                    this.dlrid = dlrid;
                }

                public String getGyfelx() {
                    return gyfelx;
                }

                public void setGyfelx(String gyfelx) {
                    this.gyfelx = gyfelx;
                }

                public Object getGyfe() {
                    return gyfe;
                }

                public void setGyfe(Object gyfe) {
                    this.gyfe = gyfe;
                }

                public String getSfcz() {
                    return sfcz;
                }

                public void setSfcz(String sfcz) {
                    this.sfcz = sfcz;
                }

                public String getHyzk() {
                    return hyzk;
                }

                public void setHyzk(String hyzk) {
                    this.hyzk = hyzk;
                }

                public String getCtime() {
                    return ctime;
                }

                public void setCtime(String ctime) {
                    this.ctime = ctime;
                }
            }

            public static class QLRBean {
                /**
                 * qlrid : c251e8ac0fa7435d8ee14ba393429e01
                 * sqbid : 070e81fd5c9740c2b6683fb66fa52fd6
                 * qlrtype : QLR
                 * name : 卖家
                 * hjszd : 滨州
                 * zjlx : 身份证
                 * zjh : 236
                 * lxdh : 256
                 * dlrid : 7880ed6150624b6c80455137f20b3944
                 * gyfelx : 单独所有
                 * gyfe : null
                 * sfcz : null
                 * hyzk : null
                 * ctime : 2019-06-20T12:26:20.000+0000
                 */

                private String qlrid;
                private String sqbid;
                private String qlrtype;
                private String name;
                private String hjszd;
                private String zjlx;
                private String zjh;
                private String lxdh;
                private String dlrid;
                private String gyfelx;
                private Object gyfe;
                private Object sfcz;
                private Object hyzk;
                private String ctime;

                public String getQlrid() {
                    return qlrid;
                }

                public void setQlrid(String qlrid) {
                    this.qlrid = qlrid;
                }

                public String getSqbid() {
                    return sqbid;
                }

                public void setSqbid(String sqbid) {
                    this.sqbid = sqbid;
                }

                public String getQlrtype() {
                    return qlrtype;
                }

                public void setQlrtype(String qlrtype) {
                    this.qlrtype = qlrtype;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getHjszd() {
                    return hjszd;
                }

                public void setHjszd(String hjszd) {
                    this.hjszd = hjszd;
                }

                public String getZjlx() {
                    return zjlx;
                }

                public void setZjlx(String zjlx) {
                    this.zjlx = zjlx;
                }

                public String getZjh() {
                    return zjh;
                }

                public void setZjh(String zjh) {
                    this.zjh = zjh;
                }

                public String getLxdh() {
                    return lxdh;
                }

                public void setLxdh(String lxdh) {
                    this.lxdh = lxdh;
                }

                public String getDlrid() {
                    return dlrid;
                }

                public void setDlrid(String dlrid) {
                    this.dlrid = dlrid;
                }

                public String getGyfelx() {
                    return gyfelx;
                }

                public void setGyfelx(String gyfelx) {
                    this.gyfelx = gyfelx;
                }

                public Object getGyfe() {
                    return gyfe;
                }

                public void setGyfe(Object gyfe) {
                    this.gyfe = gyfe;
                }

                public Object getSfcz() {
                    return sfcz;
                }

                public void setSfcz(Object sfcz) {
                    this.sfcz = sfcz;
                }

                public Object getHyzk() {
                    return hyzk;
                }

                public void setHyzk(Object hyzk) {
                    this.hyzk = hyzk;
                }

                public String getCtime() {
                    return ctime;
                }

                public void setCtime(String ctime) {
                    this.ctime = ctime;
                }
            }
        }
}
