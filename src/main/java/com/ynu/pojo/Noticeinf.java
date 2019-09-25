package com.ynu.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 这个时候，为了方便，我们采用的是自定义结果集的映射，你把这一堆东西形成一个新的东西，不要对应在实体中
 */
public class Noticeinf implements Serializable {
    private Integer notice_id;
    private String title;
    private String content;
    private Date createdate;
    private Integer user_id;

    public Integer getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(Integer notice_id) {
        this.notice_id = notice_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        return "Noticeinf{" +
                "noticeId=" + notice_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", datetime=" + createdate +
                ", user_id=" + user_id +
                '}';
    }
}
