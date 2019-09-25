package com.ynu.mapper;

import com.ynu.pojo.Deptinf;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DeptinfMapper {
    List<Deptinf> getAllDeptinf();

    void addDept(Deptinf deptinf);

    void deleteDeptById(@Param("dept_id") int dept_id);

    void updateDept(Deptinf deptinf);

    Deptinf selectDepetById(@Param("dept_id") int dept_id);

    List<Deptinf> selectDeptByName(@Param("dept_name") String dept_name);

//    void deleteSomeDept(@Param("list") List<Integer> idList);
    void deleteSomeDept(@Param("list") int[] idList);
}
