package com.alokpau.springbootrest.service;

import com.alokpau.springbootrest.model.JobPost;
import com.alokpau.springbootrest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(null);
    }

    public String loadData() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf"))),
                new JobPost(2, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf"))),
                new JobPost(3, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf"))),
                new JobPost(4, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf"))),
                new JobPost(5, "java", "java dev", 2, new ArrayList<>(Arrays.asList("fdsafsa", "sdfsafsaf")))
        ));

        repo.saveAll(jobs);

        return "success";
    }

    public List<JobPost> search(String keyword) {
        return repo.searchJobPostByPostProfileContainsOrPostDescContains(keyword, keyword);
    }
}
