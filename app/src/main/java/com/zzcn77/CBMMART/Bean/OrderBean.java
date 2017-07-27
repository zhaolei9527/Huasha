package com.zzcn77.CBMMART.Bean;

import java.util.List;

/**
 * Created by 赵磊 on 2017/7/17.
 */

public class OrderBean {

    /**
     * stu : 1
     * res : [{"id":"63","stu":"5","order_num":"963852741","sc_time":"1501135751","is_fx":"-1","jf_time":"1501862400","add_time":"1501135707"},{"id":"62","stu":"5","order_num":"963852","sc_time":"1501084800","is_fx":"-1","jf_time":"1501516800","add_time":"1501060728"},{"id":"61","stu":"8","order_num":"123456789","sc_time":"1500912000","is_fx":"-1","jf_time":"1501257600","add_time":"1501054950"},{"id":"60","stu":"2","order_num":"98656214555","sc_time":"1501134249","is_fx":null,"jf_time":"1501516800","add_time":"1501047799"},{"id":"59","stu":"9","order_num":"1568956","sc_time":"1500998400","is_fx":"1","jf_time":"1500998400","add_time":"1501033250"}]
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
         * id : 63
         * stu : 5
         * order_num : 963852741
         * sc_time : 1501135751
         * is_fx : -1
         * jf_time : 1501862400
         * add_time : 1501135707
         */

        private String id;
        private String stu;
        private String order_num;
        private String sc_time;
        private String is_fx;
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

        public String getIs_fx() {
            return is_fx;
        }

        public void setIs_fx(String is_fx) {
            this.is_fx = is_fx;
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
