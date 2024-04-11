package com.alokpau.springbootrest.repo;

import com.alokpau.springbootrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
    List<JobPost> searchJobPostByPostProfileContainsOrPostDescContains(String postProfile, String postDesc);
}
