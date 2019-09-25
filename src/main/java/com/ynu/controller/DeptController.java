package com.ynu.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.ynu.pojo.Deptinf;
import com.ynu.service.DeptService;
import com.ynu.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @ApiOperation(value = "查询所有的部门", notes = "初始化时使用", httpMethod = "GET")
    @RequestMapping(value = "/alldepts",method = RequestMethod.GET)
    public List<Deptinf> getAllDept(){
        return deptService.getAllDepts();
    }

    @ApiOperation(value = "部门查询byName", notes = "根据部门名称模糊查询部门", httpMethod = "POST")
    @RequestMapping(value = "/deptbyname",method = RequestMethod.POST)
    public List<Deptinf> getDeptByName(@RequestParam("dept_name") String dept_name){
        return deptService.getDeptsByName(dept_name);
    }

    @ApiOperation(value = "部门查询byId",notes = "根据部门ID模糊查询部门", httpMethod = "POST")
    @RequestMapping(value = "/deptbyid",method = RequestMethod.POST)
    public Deptinf getDeptById(@RequestParam("dept_id") int dept_id){
        return deptService.getDeptById(dept_id);
    }

    @ApiOperation(value = "删除部门",notes = "管理员根据ID删除部门信息", httpMethod = "POST")
    @RequestMapping(value = "/2/deletedept",method = RequestMethod.POST)
    public Map<String,String> deltteDept(@RequestParam("dept_id") int dept_id){
        boolean flag = deptService.deleteDeptById(dept_id);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "添加部门",notes = "管理员添加新的部门", httpMethod = "POST")
    @RequestMapping(value = "/2/adddept", method = RequestMethod.POST)
    public Map<String,String> addDept(@RequestParam(value = "dept_name") String dept_name, @RequestParam("remark") String remark){
        Deptinf deptinf = new Deptinf();
        deptinf.setDept_name(dept_name);
        deptinf.setRemark(remark);
        boolean flag = deptService.addDept(deptinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "修改部门",notes = "管理员修改部门信息", httpMethod = "POST")
    @RequestMapping(value = "/2/editdept", method = RequestMethod.POST)
    public Map<String,String> editDept(@RequestParam(value = "dept_name") String dept_name,
                                       @RequestParam("remark") String remark,@RequestParam("dept_id") int dept_id){
        Deptinf deptinf = deptService.getDeptById(dept_id);
        if (dept_name != null){
            deptinf.setDept_name(dept_name);
        }
        if (remark != null){
            deptinf.setRemark(remark);
        }
        boolean flag = deptService.editDept(deptinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }


    @ApiOperation(value = "删除一些部门",notes = "管理员根据IDLIST删除部门信息", httpMethod = "POST")
    @RequestMapping(value = "/2/delsomedept",method = RequestMethod.POST)
    public Map<String,String> delSomeDept(@RequestParam("dept_list") String dept_list){
        boolean tag = deptService.delSomeDept(StringUtil.stringToInt(dept_list));
        Map<String, String> map = new HashMap<>();
        if(tag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }
}
