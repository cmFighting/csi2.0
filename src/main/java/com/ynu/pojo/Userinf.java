package com.ynu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Userinf implements Serializable {
    private Integer uid;
    private String loginname;
    private String password;
    private Integer status;
    private Date createdate;
    private String username;
    private String faceurl;
    private String facepath;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFaceurl() {
        return faceurl;
    }

    public void setFaceurl(String faceurl) {
        this.faceurl = faceurl;
    }

    public String getFacepath() {
        return facepath;
    }

    public void setFacepath(String facepath) {
        this.facepath = facepath;
    }

    @Override
    public String toString() {
        return "Userinf{" +
                "uid=" + uid +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createdate=" + createdate +
                ", username='" + username + '\'' +
                ", faceurl='" + faceurl + '\'' +
                ", facepath='" + facepath + '\'' +
                '}';
    }
}
