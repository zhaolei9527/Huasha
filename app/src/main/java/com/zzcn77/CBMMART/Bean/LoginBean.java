package com.zzcn77.CBMMART.Bean;

/**
 * Created by 赵磊 on 2017/7/13.
 */

public class LoginBean {


    /**
     * stu : 1
     * msg : 登陆成功！
     * res : {"id":"12","username":"77qiao","email":"long_ear@163.com","password":"ecedb0fca407dd691c0c85e0398bfe32","add_time":"1499736100","status":"1","rand":"5121","is_del":"1","last_login_time":"1501056507","ping_url":"http://www.baidu.com"}
     */

    private String stu;
    private String msg;
    private ResBean res;

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResBean getRes() {
        return res;
    }

    public void setRes(ResBean res) {
        this.res = res;
    }

    public static class ResBean {
        /**
         * id : 12
         * username : 77qiao
         * email : long_ear@163.com
         * password : ecedb0fca407dd691c0c85e0398bfe32
         * add_time : 1499736100
         * status : 1
         * rand : 5121
         * is_del : 1
         * last_login_time : 1501056507
         * ping_url : http://www.baidu.com
         */

        private String id;
        private String username;
        private String email;
        private String password;
        private String add_time;
        private String status;
        private String rand;
        private String is_del;
        private String last_login_time;
        private String ping_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRand() {
            return rand;
        }

        public void setRand(String rand) {
            this.rand = rand;
        }

        public String getIs_del() {
            return is_del;
        }

        public void setIs_del(String is_del) {
            this.is_del = is_del;
        }

        public String getLast_login_time() {
            return last_login_time;
        }

        public void setLast_login_time(String last_login_time) {
            this.last_login_time = last_login_time;
        }

        public String getPing_url() {
            return ping_url;
        }

        public void setPing_url(String ping_url) {
            this.ping_url = ping_url;
        }
    }
}
