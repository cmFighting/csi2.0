package com.ynu.mapper;

import com.ynu.pojo.EmployeeWithDeptJob;
import com.ynu.pojo.Employeeinf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeinfMapper{

    List<Employeeinf> getAllEmployeeinfs();

    void addEmployeeinf(Employeeinf employeeinf);

    void deleteEmployeeById(@Param("employee_id") int employee_id);

    void updateEmployee(Employeeinf employeeinf);

    List<EmployeeWithDeptJob> getAllEmployeeWithDeptJob();

    EmployeeWithDeptJob seletEmployeeDetailById(@Param("employee_id") int employee_id);

    List<EmployeeWithDeptJob> selectEmployeeByEveryThing(@Param("job_name") String jobname,
                                    @Param("sex") int sex, @Param("realname") String realname,@Param("phone") String phone,
                                    @Param("card_id") String card_id, @Param("dept_name") String dept_name);

    void delSomeEmps(@Param("list") int[] list);
}
