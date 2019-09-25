package com.ynu.serviceImpl;

import com.ynu.mapper.EmployeeinfMapper;
import com.ynu.pojo.EmployeeWithDeptJob;
import com.ynu.pojo.Employeeinf;
import com.ynu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeinfMapper employeeinfMapper;

    @Override
    public List<EmployeeWithDeptJob> getAllEmployinf() {
        return employeeinfMapper.getAllEmployeeWithDeptJob();
    }

    @Override
    public EmployeeWithDeptJob getEmployById(int employee_id) {
        return employeeinfMapper.seletEmployeeDetailById(employee_id);
    }

    @Override
    public List<EmployeeWithDeptJob> getEmployeeBySomething(String job_name, int sex, String realname, String phone, String card_id, String dept_name) {
        return employeeinfMapper.selectEmployeeByEveryThing(job_name,sex,realname,phone,card_id,dept_name);
    }

    @Override
    public boolean addEmployee(Employeeinf employeeinf) {
        employeeinfMapper.addEmployeeinf(employeeinf);
        return true;
    }

    @Override
    public boolean deleteEmployee(int employee_id) {
        employeeinfMapper.deleteEmployeeById(employee_id);
        return true;
    }

    @Override
    public boolean editEmployee(Employeeinf employeeinf) {
        employeeinfMapper.updateEmployee(employeeinf);
        return true;
    }

    @Override
    public boolean delSomeEmps(int[] list) {
        employeeinfMapper.delSomeEmps(list);
        return true;
    }
}
