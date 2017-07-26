package com.zzcn77.CBMMART.Bean;

import java.util.List;

/**
 * Created by 赵磊 on 2017/7/20.
 */

public class Order_nyBean {


    /**
     * stu : 1
     * res : {"id":"59","email":"long_ear@163.com","order_num":"1568956","stu":"9","add_time":"1501033250","kd_name":"zhongtong","kd_num":"15615615615616","dg_time":"1501119829","is_fx":"1","uid":"12","wc_time":"1501292758","good":[{"id":"192","title":"Started to produce","stu":"1","add_time":"1500998400","shuoming":"Started to produce","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_05_74305.png","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_07_59949.jpg"],"title":"Started to produce"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_13_96822.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_15_53308.jpg"],"title":"Started to produce"}]},{"id":"193","title":"Production of complete","stu":"2","add_time":"1501033284","shuoming":"Production of complete","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_34_83806.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_40_69210.jpg"],"title":"Production of complete"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_55_30137.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_57_73316.jpg"],"title":"Production of complete"}]},{"id":"194","title":"Is the packaging","stu":"3","add_time":"1501033326","shuoming":" Is the packaging","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_16_17789.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_18_99815.jpg"],"title":" Is the packaging"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_24_98118.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_26_70864.jpg"],"title":"Production of complete"}]},{"id":"195","title":"Is the container","stu":"4","add_time":"1501033354","shuoming":"Is the container","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_42_39317.png","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_48_41648.jpg"],"title":"Is the container"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_01_58164.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_03_73789.jpg"],"title":"Is the container"}]},{"id":"196","title":"The customs clearance","stu":"5","add_time":"1501119793","shuoming":"The customs clearance","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_23_50740.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_25_61915.jpg"],"title":"The customs clearance"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_31_69301.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_33_29171.jpg"],"title":"The customs clearance"}]},{"id":"197","title":"Ship by sea/to port","stu":"6","add_time":"1501119827","shuoming":"Ship by sea/to port","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_44_39_52918.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_44_41_50415.jpg"],"title":"Ship by sea/to port"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_44_47_35026.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_44_49_38083.jpg"],"title":"Ship by sea/to port"}]},{"id":"198","title":"Send the file","stu":"8","add_time":"1501119897","shuoming":" Send the file","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_45_41_85610.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_45_42_49061.jpg"],"title":" Send the file"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_45_47_29465.png","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_45_49_63250.png"],"title":" Send the file"}]}]}
     */

    private String stu;
    private ResBean res;

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public ResBean getRes() {
        return res;
    }

    public void setRes(ResBean res) {
        this.res = res;
    }

    public static class ResBean {
        /**
         * id : 59
         * email : long_ear@163.com
         * order_num : 1568956
         * stu : 9
         * add_time : 1501033250
         * kd_name : zhongtong
         * kd_num : 15615615615616
         * dg_time : 1501119829
         * is_fx : 1
         * uid : 12
         * wc_time : 1501292758
         * good : [{"id":"192","title":"Started to produce","stu":"1","add_time":"1500998400","shuoming":"Started to produce","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_05_74305.png","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_07_59949.jpg"],"title":"Started to produce"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_13_96822.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_15_53308.jpg"],"title":"Started to produce"}]},{"id":"193","title":"Production of complete","stu":"2","add_time":"1501033284","shuoming":"Production of complete","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_34_83806.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_40_69210.jpg"],"title":"Production of complete"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_55_30137.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_57_73316.jpg"],"title":"Production of complete"}]},{"id":"194","title":"Is the packaging","stu":"3","add_time":"1501033326","shuoming":" Is the packaging","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_16_17789.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_18_99815.jpg"],"title":" Is the packaging"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_24_98118.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_26_70864.jpg"],"title":"Production of complete"}]},{"id":"195","title":"Is the container","stu":"4","add_time":"1501033354","shuoming":"Is the container","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_42_39317.png","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_42_48_41648.jpg"],"title":"Is the container"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_01_58164.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_03_73789.jpg"],"title":"Is the container"}]},{"id":"196","title":"The customs clearance","stu":"5","add_time":"1501119793","shuoming":"The customs clearance","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_23_50740.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_25_61915.jpg"],"title":"The customs clearance"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_31_69301.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_43_33_29171.jpg"],"title":"The customs clearance"}]},{"id":"197","title":"Ship by sea/to port","stu":"6","add_time":"1501119827","shuoming":"Ship by sea/to port","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_44_39_52918.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_44_41_50415.jpg"],"title":"Ship by sea/to port"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_44_47_35026.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_44_49_38083.jpg"],"title":"Ship by sea/to port"}]},{"id":"198","title":"Send the file","stu":"8","add_time":"1501119897","shuoming":" Send the file","sure":"2","item":[{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_45_41_85610.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_45_42_49061.jpg"],"title":" Send the file"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_45_47_29465.png","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_45_49_63250.png"],"title":" Send the file"}]}]
         */

        private String id;
        private String email;
        private String order_num;
        private String stu;
        private String add_time;
        private String kd_name;
        private String kd_num;
        private String dg_time;
        private String is_fx;
        private String uid;
        private String wc_time;
        private List<GoodBean> good;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public String getStu() {
            return stu;
        }

        public void setStu(String stu) {
            this.stu = stu;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getKd_name() {
            return kd_name;
        }

        public void setKd_name(String kd_name) {
            this.kd_name = kd_name;
        }

        public String getKd_num() {
            return kd_num;
        }

        public void setKd_num(String kd_num) {
            this.kd_num = kd_num;
        }

        public String getDg_time() {
            return dg_time;
        }

        public void setDg_time(String dg_time) {
            this.dg_time = dg_time;
        }

        public String getIs_fx() {
            return is_fx;
        }

        public void setIs_fx(String is_fx) {
            this.is_fx = is_fx;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getWc_time() {
            return wc_time;
        }

        public void setWc_time(String wc_time) {
            this.wc_time = wc_time;
        }

        public List<GoodBean> getGood() {
            return good;
        }

        public void setGood(List<GoodBean> good) {
            this.good = good;
        }

        public static class GoodBean {
            /**
             * id : 192
             * title : Started to produce
             * stu : 1
             * add_time : 1500998400
             * shuoming : Started to produce
             * sure : 2
             * item : [{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_05_74305.png","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_07_59949.jpg"],"title":"Started to produce"},{"img":["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_13_96822.jpg","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_15_53308.jpg"],"title":"Started to produce"}]
             */

            private String id;
            private String title;
            private String stu;
            private String add_time;
            private String shuoming;
            private String sure;
            private List<ItemBean> item;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getStu() {
                return stu;
            }

            public void setStu(String stu) {
                this.stu = stu;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getShuoming() {
                return shuoming;
            }

            public void setShuoming(String shuoming) {
                this.shuoming = shuoming;
            }

            public String getSure() {
                return sure;
            }

            public void setSure(String sure) {
                this.sure = sure;
            }

            public List<ItemBean> getItem() {
                return item;
            }

            public void setItem(List<ItemBean> item) {
                this.item = item;
            }

            public static class ItemBean {
                /**
                 * img : ["/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_05_74305.png","/Public/Uploads/order_img/2017-07-26/2017_07_26_09_41_07_59949.jpg"]
                 * title : Started to produce
                 */

                private String title;
                private List<String> img;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public List<String> getImg() {
                    return img;
                }

                public void setImg(List<String> img) {
                    this.img = img;
                }
            }
        }
    }
}
