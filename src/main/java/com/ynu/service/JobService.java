package com.ynu.service;

import com.ynu.pojo.Jobinf;

import java.util.List;

public interface JobService {

    List<Jobinf> getAllJobs();

    List<Jobinf> getJobsByName(String job_name);

    Jobinf getJobById(int job_id);

    boolean editJob(Jobinf jobinf);

    boolean deleteJobById(int job_id);

    boolean addJob(Jobinf jobinf);

    boolean delSomeJobs(int[] list);
}
