package com.example.master.byd.bean;

import java.util.List;

/**
 * @author byd
 * @date 2019/6/5 10:54
 */
public class Banners {
        private List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * IMG_PATH : http://localhost:8080/banner/1.png
             */

            private String IMG_PATH;

            public String getIMG_PATH() {
                return IMG_PATH;
            }

            public void setIMG_PATH(String IMG_PATH) {
                this.IMG_PATH = IMG_PATH;
            }
        }
}
