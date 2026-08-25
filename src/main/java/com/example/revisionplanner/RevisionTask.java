package com.example.revisionplanner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RevisionTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private boolean completed;

    // Required by JPA
    public RevisionTask() {
    }

    // Constructor to create a new RevisionTask
    public RevisionTask(String title) {
        this.title = title;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    // Mark task as complete
    public void markComplete() {
        completed = true;
    }

    // Returns the title of the task
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    // Returns the completion state
    public boolean getComplete() {
        return completed;
    }
}