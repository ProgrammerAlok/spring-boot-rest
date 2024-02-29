package com.alokpau.springbootrest.repo;

import com.alokpau.springbootrest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
       new JobPost(1, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf"))),
       new JobPost(2, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf"))),
       new JobPost(3, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf"))),
       new JobPost(4, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf"))),
       new JobPost(5, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf")))
    ));

    public void addJob(JobPost jobPost) {
        jobs.add(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobs;
    }

    public JobPost getJob(int postId) {
        for(JobPost job : jobs){
            if(job.getPostId() == postId) {
                return job;
            }
        }
        return null;
    }
}
