package com.example.revisionplanner;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionTaskRepository extends JpaRepository<RevisionTask, Integer> {

}