package com.ynu.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.ynu.pojo.Deptinf;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {

    List<Deptinf> getAllDepts();

    List<Deptinf> getDeptsByName(String dept_name);

    Deptinf getDeptById(int dept_id);

    boolean editDept(Deptinf deptinf);

    boolean deleteDeptById(int dept_id);

    boolean addDept(Deptinf deptinf);

    boolean delSomeDept(int[] dept_list);
}
