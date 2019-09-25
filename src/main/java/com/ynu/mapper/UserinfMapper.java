package com.ynu.mapper;

import com.ynu.pojo.Userinf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserinfMapper {

    List<Userinf> getAllUser();

    void addUser(Userinf userinf);

    // 删除的时候有一个复选的操作，之后根据复选的操作进行一下改进
    void deleteUserById(@Param("uid") int uid);

    void updateUser(Userinf userinf);

    Userinf selectUserById(@Param("uid") int uid);

    //  利用用户名和状态进行联合查询
    List<Userinf> selectUserByUsernameAndStatus(@Param("username") String username, @Param("status") int status);

    Userinf selectByLoginName(@Param("loginname")String loginname);

    List<Userinf> getAllUserExceptMe(@Param("uid") int uid);

    void delSomeUsers(@Param("list") int[] list);





}
