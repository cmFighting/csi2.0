package com.ynu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Documentinf implements Serializable {
    private Integer document_id;
    private String title;
    private String filename;
    private String remark;
    private Date createdate;
    private Integer user_id;

    public Integer getDocument_id() {
        return document_id;
    }

    public void setDocument_id(Integer document_id) {
        this.document_id = document_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Documentinf{" +
                "documentId=" + document_id +
                ", title='" + title + '\'' +
                ", filename='" + filename + '\'' +
                ", remark='" + remark + '\'' +
                ", createdate=" + createdate +
                ", user_id=" + user_id +
                '}';
    }
}
