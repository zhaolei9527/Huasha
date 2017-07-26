package com.zzcn77.CBMMART.Bean;

import java.util.List;

/**
 * Created by 赵磊 on 2017/7/17.
 */

public class OrderBean {

    /**
     * stu : 1
     * res : [{"id":"32","stu":"9","order_num":"96287011","sc_time":"1500566400","jf_time":"1504886400","add_time":"1500599243"},{"id":"31","stu":"8","order_num":"3548844456224","sc_time":"1498924800","jf_time":"1501171200","add_time":"1500545152"}]
     */

    private String stu;
    private List<ResBean> res;

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public List<ResBean> getRes() {
        return res;
    }

    public void setRes(List<ResBean> res) {
        this.res = res;
    }

    public static class ResBean {
        /**
         * id : 32
         * stu : 9
         * order_num : 96287011
         * sc_time : 1500566400
         * jf_time : 1504886400
         * add_time : 1500599243
         */

        private String id;
        private String stu;
        private String order_num;
        private String sc_time;
        private String jf_time;
        private String add_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStu() {
            return stu;
        }

        public void setStu(String stu) {
            this.stu = stu;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public String getSc_time() {
            return sc_time;
        }

        public void setSc_time(String sc_time) {
            this.sc_time = sc_time;
        }

        public String getJf_time() {
            return jf_time;
        }

        public void setJf_time(String jf_time) {
            this.jf_time = jf_time;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
