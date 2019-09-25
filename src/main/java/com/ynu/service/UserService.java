package com.ynu.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.ynu.pojo.Userinf;

import java.util.List;

public interface UserService {

    List<Userinf> listAllUser();

    /**
     * 通过用户名查询用户信息，帮助登录
     * @param loginName
     * @return
     */
    Userinf getUserByLoginName(String loginName);

    boolean addUser(Userinf userinf);

    boolean deleteUser(int uid);

    boolean editUser(Userinf userinf);

    Userinf getUserById(int uid);

    List<Userinf> getUserBySomething(String username,int status);

    List<Userinf> getUsersExceptMe(int uid);

    boolean delSomeUers(int[] list);
}
