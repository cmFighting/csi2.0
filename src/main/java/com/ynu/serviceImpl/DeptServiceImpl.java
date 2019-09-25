package com.ynu.serviceImpl;

import com.ynu.mapper.DeptinfMapper;
import com.ynu.pojo.Deptinf;
import com.ynu.pojo.Userinf;
import com.ynu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptinfMapper deptinfMapper;


    @Override
    public List<Deptinf> getAllDepts() {
        return deptinfMapper.getAllDeptinf();
    }

    @Override
    public List<Deptinf> getDeptsByName(String dept_name) {
        return deptinfMapper.selectDeptByName(dept_name);
    }

    @Override
    public Deptinf getDeptById(int dept_id) {
        return deptinfMapper.selectDepetById(dept_id);
    }

    @Override
    public boolean editDept(Deptinf deptinf) {
        deptinfMapper.updateDept(deptinf);
        Deptinf deptEdit = deptinfMapper.selectDepetById(deptinf.getDept_id());
        if(deptinf != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteDeptById(int dept_id) {
        deptinfMapper.deleteDeptById(dept_id);
        Deptinf deptDelete = deptinfMapper.selectDepetById(dept_id);
        if (deptDelete == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean addDept(Deptinf deptinf) {
        deptinfMapper.addDept(deptinf);
        return true;
//        Deptinf deptAdd = deptinfMapper.selectDeptByName(deptinf.getDept_name());
//        if (deptAdd != null){
//            return true;
//        }
//        return false;
    }

    @Override
    public boolean delSomeDept(int[] dept_list) {
//        List<Integer> list = Arrays.stream(dept_list).boxed().collect(Collectors.toList());
        deptinfMapper.deleteSomeDept(dept_list);
        return true;
    }
}
