package com.ynu.pojo;

import java.io.Serializable;

/**
 * 每一条公告都携带这一个详细的客户信息
 */
public class NoticeWithUser extends Noticeinf implements Serializable {
    private Userinf userinf;


    public Userinf getUserinf() {
        return userinf;
    }

    public void setUserinf(Userinf userinf) {
        this.userinf = userinf;
    }
}
