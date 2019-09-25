package com.ynu.pojo;

import java.io.Serializable;

public class EmployeeWithDeptJob extends Employeeinf implements Serializable {
    private Deptinf deptinf;
    private Jobinf jobinf;


//    public EmployeeWithDeptJob(Integer dept_id, Integer job_id, String realname, Integer card_id, String address, String postcode, String tel, String phone, String qqnum, String email, Integer sex, String party, String birthday, String race, String education, String speciality, String hobby, String remark, Deptinf deptinf, Jobinf jobinf) {
//        super(dept_id, job_id, realname, card_id, address, postcode, tel, phone, qqnum, email, sex, party, birthday, race, education, speciality, hobby, remark);
//        this.deptinf = deptinf;
//        this.jobinf = jobinf;
//    }

    public Deptinf getDeptinf() {
        return deptinf;
    }

    public void setDeptinf(Deptinf deptinf) {
        this.deptinf = deptinf;
    }

    public Jobinf getJobinf() {
        return jobinf;
    }

    public void setJobinf(Jobinf jobinf) {
        this.jobinf = jobinf;
    }
}
