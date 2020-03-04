package com.example.master.byd.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author byd
 * @date 2019/6/27 18:32
 */
public class WhthinG  implements Serializable{
        /**
         * data : {"bdc":[{"zl":"滨州市黄河十路以南，渤海十一路以东泰和家园","qlr":"杨阳","bdcdyh":"371602009009GB00002F00072032","zs":"2010050251+20090311000400042","zjh":"372301198510263818"},{"zl":"滨州市黄河十路以南，渤海十一路以东泰和家园","qlr":"杨阳","bdcdyh":"371602009009GB00002F00070008","zs":"2010050251+20090311000400012","zjh":"372301198510263818"},{"zl":"开发区黄河八路以南丽景新园52号楼2单元","qlr":"杨阳/张燕","bdcdyh":"371602009011GB00001F00522032","zs":"鲁(2016)滨州市不动产权第0000288号","zjh":"372301198510263818/371202198512076629"}],"cdr":[{"idnumber":"372301198510263818","name":"杨阳"}],"cxh":"2019062736439","cxsj":"2019-06-27 06:31:23","jym":"20190627VT899"}
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
             * bdc : [{"zl":"滨州市黄河十路以南，渤海十一路以东泰和家园","qlr":"杨阳","bdcdyh":"371602009009GB00002F00072032","zs":"2010050251+20090311000400042","zjh":"372301198510263818"},{"zl":"滨州市黄河十路以南，渤海十一路以东泰和家园","qlr":"杨阳","bdcdyh":"371602009009GB00002F00070008","zs":"2010050251+20090311000400012","zjh":"372301198510263818"},{"zl":"开发区黄河八路以南丽景新园52号楼2单元","qlr":"杨阳/张燕","bdcdyh":"371602009011GB00001F00522032","zs":"鲁(2016)滨州市不动产权第0000288号","zjh":"372301198510263818/371202198512076629"}]
             * cdr : [{"idnumber":"372301198510263818","name":"杨阳"}]
             * cxh : 2019062736439
             * cxsj : 2019-06-27 06:31:23
             * jym : 20190627VT899
             */

            private String cxh;
            private String cxsj;
            private String jym;
            private List<BdcBean> bdc;
            private List<CdrBean> cdr;

            public String getCxh() {
                return cxh;
            }

            public void setCxh(String cxh) {
                this.cxh = cxh;
            }

            public String getCxsj() {
                return cxsj;
            }

            public void setCxsj(String cxsj) {
                this.cxsj = cxsj;
            }

            public String getJym() {
                return jym;
            }

            public void setJym(String jym) {
                this.jym = jym;
            }

            public List<BdcBean> getBdc() {
                return bdc;
            }

            public void setBdc(List<BdcBean> bdc) {
                this.bdc = bdc;
            }

            public List<CdrBean> getCdr() {
                return cdr;
            }

            public void setCdr(List<CdrBean> cdr) {
                this.cdr = cdr;
            }

            public static class BdcBean implements Serializable{
                /**
                 * zl : 滨州市黄河十路以南，渤海十一路以东泰和家园
                 * qlr : 杨阳
                 * bdcdyh : 371602009009GB00002F00072032
                 * zs : 2010050251+20090311000400042
                 * zjh : 372301198510263818
                 */

                private String zl;
                private String qlr;
                private String bdcdyh;
                private String zs;
                private String zjh;

                public String getZl() {
                    return zl;
                }

                public void setZl(String zl) {
                    this.zl = zl;
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

                public String getZs() {
                    return zs;
                }

                public void setZs(String zs) {
                    this.zs = zs;
                }

                public String getZjh() {
                    return zjh;
                }

                public void setZjh(String zjh) {
                    this.zjh = zjh;
                }
            }

            public static class CdrBean implements Serializable{
                /**
                 * idnumber : 372301198510263818
                 * name : 杨阳
                 */

                private String idnumber;
                private String name;

                public String getIdnumber() {
                    return idnumber;
                }

                public void setIdnumber(String idnumber) {
                    this.idnumber = idnumber;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
}
