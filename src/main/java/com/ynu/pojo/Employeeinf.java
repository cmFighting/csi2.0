package com.ynu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Employeeinf implements Serializable {
    private Integer employee_id;
    private Integer dept_id;
    private Integer job_id;
    private String realname;
    private Integer card_id;
    private String address;
    private String postcode;
    private String tel;
    private String phone;
    private String qqnum;
    private String email;
    private Integer sex;
    private String party;
    private String birthday;
    private String race;
    private String education;
    private String speciality;
    private String hobby;
    private String remark;
    private Date createdate;

//    public Employeeinf(Integer dept_id, Integer job_id, String realname, Integer card_id, String address, String postcode, String tel, String phone, String qqnum, String email, Integer sex, String party, String birthday, String race, String education, String speciality, String hobby, String remark) {
//        this.dept_id = dept_id;
//        this.job_id = job_id;
//        this.realname = realname;
//        this.card_id = card_id;
//        this.address = address;
//        this.postcode = postcode;
//        this.tel = tel;
//        this.phone = phone;
//        this.qqnum = qqnum;
//        this.email = email;
//        this.sex = sex;
//        this.party = party;
//        this.birthday = birthday;
//        this.race = race;
//        this.education = education;
//        this.speciality = speciality;
//        this.hobby = hobby;
//        this.remark = remark;
//    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getJob_id() {
        return job_id;
    }

    public void setJob_id(Integer job_id) {
        this.job_id = job_id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQqnum() {
        return qqnum;
    }

    public void setQqnum(String qqnum) {
        this.qqnum = qqnum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
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

    @Override
    public String toString() {
        return "Employeeinf{" +
                "employee_id=" + employee_id +
                ", dept_id=" + dept_id +
                ", job_id=" + job_id +
                ", realname='" + realname + '\'' +
                ", card_id=" + card_id +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", tel='" + tel + '\'' +
                ", phone='" + phone + '\'' +
                ", qqnum='" + qqnum + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", party='" + party + '\'' +
                ", birthday='" + birthday + '\'' +
                ", race='" + race + '\'' +
                ", education='" + education + '\'' +
                ", speciality='" + speciality + '\'' +
                ", hobby='" + hobby + '\'' +
                ", remark='" + remark + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}
