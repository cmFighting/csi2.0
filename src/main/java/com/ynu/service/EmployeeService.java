package com.ynu.service;


import com.ynu.pojo.EmployeeWithDeptJob;
import com.ynu.pojo.Employeeinf;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface EmployeeService {
    List<EmployeeWithDeptJob> getAllEmployinf();

    EmployeeWithDeptJob getEmployById(int employee_id);

    List<EmployeeWithDeptJob> getEmployeeBySomething(String jobname, int sex,
                                                     String realname, String phone,String card_id,String dept_name);

    boolean addEmployee(Employeeinf employeeinf);

    boolean deleteEmployee(int employee_id);

    boolean editEmployee(Employeeinf employeeinf);

    boolean delSomeEmps(int[] list);


}
