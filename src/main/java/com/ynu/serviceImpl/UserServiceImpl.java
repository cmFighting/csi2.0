package com.ynu.serviceImpl;

import com.ynu.mapper.UserinfMapper;
import com.ynu.pojo.Userinf;
import com.ynu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 最好的话是添加事务的管理，要将mapper装载进来
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserinfMapper userinfMapper;

    @Override
    public List<Userinf> listAllUser() {
        return userinfMapper.getAllUser();
    }

    @Override
    public Userinf getUserByLoginName(String loginName) {

        //返回情况有两种，一种是null，一种是一个值
        return userinfMapper.selectByLoginName(loginName);
    }

    @Override
    public boolean addUser(Userinf userinf) {
        userinfMapper.addUser(userinf);
        Userinf userinfAdd = userinfMapper.selectByLoginName(userinf.getLoginname());
        if(userinfAdd != null){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean deleteUser(int uid) {
        userinfMapper.deleteUserById(uid);
        Userinf userinf = userinfMapper.selectUserById(uid);
        if(userinf == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean editUser(Userinf userinf) {
        userinfMapper.updateUser(userinf);
        Userinf userinfEdit = userinfMapper.selectByLoginName(userinf.getLoginname());
        if(userinfEdit != null){
            return true;
        }
        return false;
    }

    @Override
    public Userinf getUserById(int uid) {
        return userinfMapper.selectUserById(uid);
    }

    @Override
    public List<Userinf> getUserBySomething(String username, int status) {
        return userinfMapper.selectUserByUsernameAndStatus(username,status);
    }

    @Override
    public List<Userinf> getUsersExceptMe(int uid) {
        return userinfMapper.getAllUserExceptMe(uid);
    }

    @Override
    public boolean delSomeUers(int[] list) {
        userinfMapper.delSomeUsers(list);
        return true;
    }


}
