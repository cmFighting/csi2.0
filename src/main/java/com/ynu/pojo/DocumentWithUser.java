package com.ynu.pojo;

import java.io.Serializable;

public class DocumentWithUser extends Documentinf implements Serializable {

    private Userinf userinf;

    public Userinf getUserinf() {
        return userinf;
    }

    public void setUserinf(Userinf userinf) {
        this.userinf = userinf;
    }
}
