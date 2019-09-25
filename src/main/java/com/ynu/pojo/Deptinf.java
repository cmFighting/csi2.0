package com.ynu.pojo;

import java.io.Serializable;

public class Deptinf implements Serializable {
    private Integer dept_id;
    private String dept_name;
    private String remark;

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Deptinf{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
