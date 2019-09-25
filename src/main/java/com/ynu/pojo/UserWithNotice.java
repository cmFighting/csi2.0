package com.ynu.pojo;

import java.util.List;

public class UserWithNotice extends Userinf {

    private List<Noticeinf> noticeinfs;

    public List<Noticeinf> getNoticeinfs() {
        return noticeinfs;
    }

    public void setNoticeinfs(List<Noticeinf> noticeinfs) {
        this.noticeinfs = noticeinfs;
    }
}
