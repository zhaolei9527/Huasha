package com.zzcn77.CBMMART.Bean;

import java.util.List;

/**
 * Created by 赵磊 on 2017/7/17.
 */

public class OrderBean {

    /**
     * stu : 1
     * res : [{"id":"4","stu":"9","order_num":"2147483628","wc_time":"1501084800","add_time":"1499910417"}]
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
         * id : 4
         * stu : 9
         * order_num : 2147483628
         * wc_time : 1501084800
         * add_time : 1499910417
         */

        private String id;
        private String stu;
        private String order_num;
        private String wc_time;
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

        public String getWc_time() {
            return wc_time;
        }

        public void setWc_time(String wc_time) {
            this.wc_time = wc_time;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
