package com.ynu.pojo;

import java.io.Serializable;

public class Facekeyinf implements Serializable {
    private Integer face_id;
    private Integer app_id;
    private String secrekey;
    private String threshold;

    public Integer getFace_id() {
        return face_id;
    }

    public void setFace_id(Integer face_id) {
        this.face_id = face_id;
    }

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public String getSecrekey() {
        return secrekey;
    }

    public void setSecrekey(String secrekey) {
        this.secrekey = secrekey;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    @Override
    public String toString() {
        return "Facekeyinf{" +
                "faceId=" + face_id +
                ", appId=" + app_id +
                ", secrekey='" + secrekey + '\'' +
                ", threshold='" + threshold + '\'' +
                '}';
    }
}
