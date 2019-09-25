package com.ynu.controller;

import com.ynu.pojo.Userinf;
import com.ynu.service.UserService;
import com.ynu.utils.MD5Util;
import com.ynu.utils.StringUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录", notes = "通过登录写入Session", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "loginname",value = "登录名",paramType = "User", dataType = "String", required = true),
//            @ApiImplicitParam(name = "password",value = "密码" ,paramType = "form",dataType = "String",required = true)
//    })
    @ApiImplicitParam(name = "对象",value = "登录名",paramType = "Userinf",required = true)
    public Userinf login(HttpSession session, Userinf userinf){
//        Userinf user = userService.getUserByLoginName(loginname);
        Userinf user = userService.getUserByLoginName(userinf.getLoginname());
        String rawPassword = userinf.getPassword();
        System.out.println(user.getUsername());
        String rightPassword = user.getPassword();
        System.out.println(rightPassword);
        if (MD5Util.verify(rawPassword, rightPassword)){
            // 写入session 用户的id和用户的权限
            session.setAttribute("user", user);
//            System.out.println("登录成功！");
            return user;
        }
        else{
            Userinf user_not = new Userinf();
            user_not.setStatus(-1);
            user_not.setUsername("notfound");
            user_not.setLoginname("notfound");
            return user_not;
        }
    }

    @ApiOperation(value = "获取所有的用户信息", notes = "获取全部的用户信息", httpMethod = "GET")
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<Userinf> getAllUser(){
        return userService.listAllUser();
    }

    @ApiOperation(value = "获取所有的用户信息(除了我自己)", notes = "登录成功之后获取用户信息使用", httpMethod = "POST")
    @RequestMapping(value = "/usersnotme",method = RequestMethod.POST)
    public List<Userinf> getAllUserExceptMe(@RequestParam("uid") int uid){
        return userService.getUsersExceptMe(uid);
    }

    @ApiOperation(value = "查询用户信息", notes = "通过用户名或者状态来查询用户信息", httpMethod = "POST")
    @RequestMapping(value = "/userbysomething",method = RequestMethod.POST)
    public List<Userinf> userBySomething(@RequestParam("username") String username, @RequestParam("status") int status){
        return userService.getUserBySomething(username,status);
    }

    /**
     * 用于添加用户，添加成功返回success，添加失败返回fail
     * @param loginname
     * @param username
     * @param rawPassword
     * @param status
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "增加新的用户信息", httpMethod = "POST")
    @RequestMapping(value = "/2/adduser", method = RequestMethod.POST)
    public Map<String, String> addUser(@RequestParam("loginname") String loginname, @RequestParam("username") String username,
                                       @RequestParam("password") String rawPassword, @RequestParam("status") int status){
        String password = MD5Util.md5(rawPassword);
        Userinf userinf = new Userinf();
        userinf.setUsername(username);
        userinf.setLoginname(loginname);
        userinf.setStatus(status);
        userinf.setPassword(password);
        boolean flag = userService.addUser(userinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "删除用户", notes = "通过ID删除用户信息", httpMethod = "POST")
    @RequestMapping(value = "/2/deleteuser",method = RequestMethod.POST)
    public Map<String, String> deleteUser(@RequestParam("uid") int uid){
        boolean flag = userService.deleteUser(uid);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "修改用户信息", notes = "修改用户的信息", httpMethod = "POST")
    @RequestMapping(value = "/2/edituser",method = RequestMethod.POST)
    public Map<String, String> editUser(@RequestParam("loginname") String loginname, @RequestParam("username") String username,
                                        @RequestParam("uid") int uid, @RequestParam("status") int status){
        Userinf userinf = userService.getUserById(uid);
        if (!loginname.equals("")){
            userinf.setLoginname(loginname);
        }
        if(!username.equals("")){
            userinf.setUsername(username);
        }
        userinf.setStatus(status);
        userinf.setUid(uid);
        boolean flag = userService.editUser(userinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "用户退出", notes = "将Session信息清空", httpMethod = "POST")
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public void logout(HttpSession session){
        session.removeAttribute("user");
    }

    @ApiOperation(value = "测试拦截器", notes = "测试1", httpMethod = "GET")
    @RequestMapping("/lanjie")
    public String lanjie(){
        return "拦截";
    }

    @ApiOperation(value = "测试拦截器", notes = "测试2", httpMethod = "GET")
    @RequestMapping("/bulanjie")
    public String bulanjie(){
        return "不拦截";
    }

//    @ApiOperation(value = "测试拦截器", notes = "测试2", httpMethod = "GET")
//    @RequestMapping("/bulanjie")

    @ApiOperation(value = "密码修改", notes = "根据用户ID修改密码", httpMethod = "POST")
    @RequestMapping(value = "/editpassword",method = RequestMethod.POST)
    public Map<String, String> editPassword(@RequestParam("oldpassword") String oldPassword, @RequestParam("newpassword") String newPassword,@RequestParam("uid") int user_id){
        Userinf userinf = userService.getUserById(user_id);
        String passwordDatabase = userinf.getPassword();
        boolean flag = MD5Util.verify(oldPassword, passwordDatabase);
        Map<String, String> map = new HashMap<>();
        if (flag){
            String password = MD5Util.md5(newPassword);
            userinf.setPassword(password);
            userService.editUser(userinf);
            map.put("result", "success");
            return map;
        }
        map.put("result", "fail");
        return map;
    }

    @ApiOperation(value = "删除用户", notes = "多选删除用户", httpMethod = "POST")
    @RequestMapping(value = "/2/delsomeuser",method = RequestMethod.POST)
    public Map<String,String> delSomeUser(@RequestParam("uid_list") String list){
        boolean flag = userService.delSomeUers(StringUtil.stringToInt(list));
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }
}
