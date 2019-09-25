package com.ynu.serviceImpl;

import com.ynu.mapper.JobinfMapper;
import com.ynu.pojo.Jobinf;
import com.ynu.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobinfMapper jobinfMapper;

    @Override
    public List<Jobinf> getAllJobs() {
        return jobinfMapper.getAllJobinf();
    }

    @Override
    public List<Jobinf> getJobsByName(String job_name) {
        return jobinfMapper.selectJobByName(job_name);
    }

    @Override
    public Jobinf getJobById(int job_id) {
        return jobinfMapper.selectJobById(job_id);
    }

    @Override
    public boolean editJob(Jobinf jobinf) {
        jobinfMapper.updateJob(jobinf);
        Jobinf jobinf_edit = jobinfMapper.selectJobById(jobinf.getJob_id());
        if(jobinf_edit != null)
            return true;
        return false;
    }

    @Override
    public boolean deleteJobById(int job_id) {
        jobinfMapper.deleteJob(job_id);
        Jobinf jobinf_delete = jobinfMapper.selectJobById(job_id);
        if (jobinf_delete == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean addJob(Jobinf jobinf) {
        jobinfMapper.addJob(jobinf);
        return true;
    }

    @Override
    public boolean delSomeJobs(int[] list) {
        jobinfMapper.delSomeJobs(list);
        return true;
    }
}
