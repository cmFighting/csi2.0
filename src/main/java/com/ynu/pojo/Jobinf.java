package com.ynu.pojo;

import java.io.Serializable;

/**
 * 工作模块的功能
 * 1. 查找所有的职位
 * 2. 通过职位的名称进行查询，查询这边有变化，根据名称进行查询
 * 3. 对职位进行编辑（jobid）
 * 4. 删除职位
 */
public class Jobinf implements Serializable {
    private Integer job_id;
    private String job_name;
    private String remark;

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Jobinf{" +
                "job_id=" + job_id +
                ", job_name='" + job_name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
