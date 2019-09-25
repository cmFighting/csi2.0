package com.ynu.controller;

import com.ynu.utils.MD5Util;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class TestController {

    @ApiOperation(value = "get请求测试用例", notes = "测试请求是否正确", httpMethod = "GET")
    @RequestMapping(value = "/test")
    public String index(){
        return "我的世界！";
    }

    @ApiOperation(value = "测试密码", notes = "计算密码", httpMethod = "GET")
    @RequestMapping(value = "/pwd")
    public String getPwd(@RequestParam("pwd") String pwd){
        return MD5Util.md5(pwd);
    }
}
