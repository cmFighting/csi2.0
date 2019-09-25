package com.ynu.mapper;

import com.ynu.pojo.Jobinf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobinfMapper {
    List<Jobinf> getAllJobinf();

    void addJob(Jobinf jobinf);

    void deleteJob(@Param("job_id") int job_id);

    void updateJob(Jobinf jobinf);

    List<Jobinf> selectJobByName(@Param("job_name") String job_name);

    Jobinf selectJobById(@Param("job_id") int job_id);

    void delSomeJobs(@Param("list") int[] list);
}
