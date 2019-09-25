package com.ynu.controller;

import com.ynu.mapper.EmployeeinfMapper;
import com.ynu.pojo.EmployeeWithDeptJob;
import com.ynu.pojo.Employeeinf;
import com.ynu.service.EmployeeService;
import com.ynu.utils.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "员工查询all", notes = "查询所有的员工信息", httpMethod = "GET")
    @RequestMapping(value = "/employeesall",method = RequestMethod.GET)
    public List<EmployeeWithDeptJob> getAllEmp(){
        return employeeService.getAllEmployinf();
    }

    @ApiOperation(value = "员工查询Id", notes = "通过ID查找员工信息", httpMethod = "POST")
    @RequestMapping(value = "/employeeById",method = RequestMethod.POST)
    public EmployeeWithDeptJob getEmpById(@RequestParam("employee_id") int employee_id){
        return employeeService.getEmployById(employee_id);

    }

    @ApiOperation(value = "员工模糊查询", notes = "通过职位、职位、姓名、性别、身份证查询员工信息", httpMethod = "POST")
    @RequestMapping(value = "/searchemp",method = RequestMethod.POST)
    public List<EmployeeWithDeptJob> getEmpBySomething(@RequestParam(value = "job_name",required = false) String job_name, @RequestParam(value = "sex",required = false)int sex,
                                                       @RequestParam(value = "realname",required = false) String realname,@RequestParam(value = "phone",required = false) String phone,@RequestParam(value = "card_id",required = false) String card_id,@RequestParam(value = "dept_name",required = false) String dept_name){
        return employeeService.getEmployeeBySomething(job_name,sex,realname,phone,card_id,dept_name);

    }

    @ApiOperation(value = "增加员工", notes = "新增员工信息", httpMethod = "POST")
    @RequestMapping(value = "/2/addemp",method = RequestMethod.POST)
    public Map<String, String> addEmp(@RequestParam(value = "dept_id") int dept_id, @RequestParam(value = "job_id") int job_id, @RequestParam(value = "realname") String realname, @RequestParam(value = "card_id") int card_id,
                                      @RequestParam(value = "address") String address, @RequestParam(value = "postcode") String postcode, @RequestParam(value = "tel") String tel, @RequestParam(value = "phone") String phone,
                                      @RequestParam(value = "qqnum") String qqnum, @RequestParam(value = "email") String email, @RequestParam(value = "sex") int sex, @RequestParam(value = "party") String party,
                                      @RequestParam(value = "birthday") String birthday, @RequestParam(value = "race")String race, @RequestParam(value = "education")String education, @RequestParam(value = "speciality")String speciality,
                                      @RequestParam(value = "hobby")String hobby, @RequestParam(value = "remark")String remark){
//        Employeeinf employeeinf = new Employeeinf(dept_id, job_id, realname, card_id, address, postcode, tel, phone, qqnum, email, sex, party, birthday, race, education, speciality, hobby, remark);
        Employeeinf employeeinf = new Employeeinf();
//        dept_id job_id real_name card_id address postcode tel phone qqnum email sex party birthday race education speciality hobby remark
        employeeinf.setDept_id(dept_id);
        employeeinf.setJob_id(job_id);
        employeeinf.setRealname(realname);
        employeeinf.setCard_id(card_id);
        employeeinf.setAddress(address);
        employeeinf.setPostcode(postcode);
        employeeinf.setTel(tel);
        employeeinf.setPhone(phone);
        employeeinf.setQqnum(qqnum);
        employeeinf.setEmail(email);
        employeeinf.setSex(sex);
        employeeinf.setParty(party);
        employeeinf.setBirthday(birthday);
        employeeinf.setRace(race);
        employeeinf.setEducation(education);
        employeeinf.setSpeciality(speciality);
        employeeinf.setHobby(hobby);
        employeeinf.setRemark(remark);
        boolean flag = employeeService.addEmployee(employeeinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "删除员工", notes = "通过ID删除员工信息", httpMethod = "POST")
    @RequestMapping(value = "/2/delemp",method = RequestMethod.POST)
    public Map<String, String> deleteById(@RequestParam("employee_id") int employee_id){
        boolean flag = employeeService.deleteEmployee(employee_id);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "修改员工信息", notes = "修改员工的各种信息(暂时不可用)", httpMethod = "POST")
    @RequestMapping(value = "/2/editemp",method = RequestMethod.POST)
    public Map<String, String> editEmployee(@RequestParam(value = "employee_id") int employee_id, @RequestParam(value = "dept_id",required = false) int dept_id, @RequestParam(value = "job_id",required = false) int job_id, @RequestParam(value = "realname",required = false) String realname, @RequestParam(value = "card_id",required = false) int card_id,
                                            @RequestParam(value = "address",required = false) String address, @RequestParam(value = "postcode",required = false) String postcode, @RequestParam(value = "tel",required = false) String tel, @RequestParam(value = "phone",required = false) String phone,
                                            @RequestParam(value = "qqnum",required = false) String qqnum, @RequestParam(value = "email",required = false) String email, @RequestParam(value = "sex",required = false) int sex, @RequestParam(value = "party",required = false) String party,
                                            @RequestParam(value = "birthday",required = false) String birthday, @RequestParam(value = "race",required = false)String race, @RequestParam(value = "education",required = false)String education, @RequestParam(value = "speciality",required = false)String speciality,
                                            @RequestParam(value = "hobby",required = false)String hobby, @RequestParam(value = "remark",required = false)String remark){
        Employeeinf employeeinf  = employeeService.getEmployById(employee_id);
        // 写超级长一串判断语句
        if(dept_id != 0)
            employeeinf.setDept_id(dept_id);
        if(job_id!= 0)
            employeeinf.setJob_id(job_id);
        if (realname != null)
            employeeinf.setRealname(realname);
        if (card_id != 0)
            employeeinf.setCard_id(card_id);
        if(address != null)
            employeeinf.setAddress(address);
        if (postcode != null)
            employeeinf.setPostcode(postcode);
        if (tel != null)
            employeeinf.setTel(tel);
        if (phone != null)
            employeeinf.setTel(tel);
        if (qqnum != null)
            employeeinf.setQqnum(qqnum);
        // sex party, birthday race education speciality hobby remark
        if (email != null)
            employeeinf.setRemark(remark);
        if (sex != 0)
            employeeinf.setSex(sex);
        if(party != null)
            employeeinf.setParty(party);
        if (birthday != null)
            employeeinf.setBirthday(birthday);
        if(race != null)
            employeeinf.setRace(race);
        if (education != null)
            employeeinf.setEducation(education);
        if (speciality != null)
            employeeinf.setSpeciality(speciality);
        if (hobby != null)
            employeeinf.setHobby(hobby);
        if (remark != null)
            employeeinf.setRemark(remark);
        boolean flag = employeeService.editEmployee(employeeinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "删除员工信息", notes = "多选删除", httpMethod = "POST")
    @RequestMapping(value = "/2/delsomeemps",method = RequestMethod.POST)
    public Map<String,String> delSomeEmps(@RequestParam("emp_list") String list){
        boolean flag = employeeService.delSomeEmps(StringUtil.stringToInt(list));
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
