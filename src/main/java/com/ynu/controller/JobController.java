package com.ynu.controller;

import com.ynu.pojo.Jobinf;
import com.ynu.service.JobService;
import com.ynu.utils.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @ApiOperation(value = "查询所有的职位", notes = "初始化时使用", httpMethod = "GET")
    @RequestMapping(value = "/alljobs",method = RequestMethod.GET)
    public List<Jobinf> getAlljob(){
        return jobService.getAllJobs();
    }

    @ApiOperation(value = "职位查询Name", notes = "根据职位名称查询职位", httpMethod = "POST")
    @RequestMapping(value = "/jobbyname",method = RequestMethod.POST)
    public List<Jobinf> getJobByName(@RequestParam("job_name") String job_name){
        return jobService.getJobsByName(job_name);
    }

    @ApiOperation(value = "职位查询Id", notes = "根据职位ID查询职位信息", httpMethod = "POST")
    @RequestMapping(value = "/jobbyid",method = RequestMethod.POST)
    public Jobinf getJobById(@RequestParam("job_id") int job_id){
        return jobService.getJobById(job_id);
    }

    @ApiOperation(value = "新增职位", notes = "添加职位信息", httpMethod = "POST")
    @RequestMapping(value = "/2/addjob",method = RequestMethod.POST)
    public Map<String, String> addJob(@RequestParam("job_name") String job_name, @RequestParam("remark") String remark){
        Jobinf jobinf = new Jobinf();
        jobinf.setRemark(remark);
        jobinf.setJob_name(job_name);
        boolean flag =  jobService.addJob(jobinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }

    }

    @ApiOperation(value = "删除职位Id", notes = "通过ID删除职位信息", httpMethod = "POST")
    @RequestMapping(value = "/2/deletejob",method = RequestMethod.POST)
    public Map<String, String> deleteJob(@RequestParam("job_id") int job_id){
        boolean flag = jobService.deleteJobById(job_id);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }


    @ApiOperation(value = "修改职位", notes = "修改职位信息", httpMethod = "POST")
    @RequestMapping(value = "/2/editjob",method = RequestMethod.POST)
    public Map<String, String> editJob(@RequestParam(value = "job_name",required = false) String job_name, @RequestParam("job_id") int job_id, @RequestParam(value = "remark",required = false) String remark){
        Jobinf jobinf = jobService.getJobById(job_id);
        if(job_name != null){
            jobinf.setJob_name(job_name);
        }
        if (remark != null){
            jobinf.setRemark(remark);
        }

        boolean flag = jobService.editJob(jobinf);
        Map<String, String> map = new HashMap<>();
        if(flag){
            map.put("result", "success");
            return map;
        }else{
            map.put("result", "fail");
            return map;
        }
    }

    @ApiOperation(value = "删除职位信息", notes = "多选修改职位信息", httpMethod = "POST")
    @RequestMapping(value = "/2/delsomejobs",method = RequestMethod.POST)
    public Map<String, String> delSomeJobs(@RequestParam("job_list") String list){
        boolean flag = jobService.delSomeJobs(StringUtil.stringToInt(list));
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
