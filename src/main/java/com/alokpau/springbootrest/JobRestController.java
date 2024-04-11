package com.alokpau.springbootrest;

import com.alokpau.springbootrest.model.JobPost;
import com.alokpau.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("keyword/{keyword}")
    public List<JobPost> searchInPost(@PathVariable("keyword") String keyword) {
        return service.search(keyword);
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost) {
        System.out.println(jobPost);
        service.addJob(jobPost);
    }

//    @GetMapping("load")
//    public String loadData() {
//        return service.loadData();
//    }

}
