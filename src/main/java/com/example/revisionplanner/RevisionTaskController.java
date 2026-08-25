package com.example.revisionplanner;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class RevisionTaskController {

    private final RevisionTaskRepository repository;

    public RevisionTaskController(RevisionTaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<RevisionTask> getTasks() {
        return repository.findAll();
    }

    @PostMapping
    public RevisionTask addTask(@RequestBody RevisionTask task) {
        return repository.save(task);
    }

    @PutMapping("/{id}")
    public RevisionTask updateTask(
            @PathVariable int id,
            @RequestBody RevisionTask updatedTask) {

        RevisionTask task = repository.findById(id)
                .orElseThrow();

        task.setTitle(updatedTask.getTitle());

        return repository.save(task);
    }
    
    @PutMapping("/{id}/complete")
    public RevisionTask completeTask(@PathVariable int id) {

        RevisionTask task = repository.findById(id)
                .orElseThrow();

        task.markComplete();

        return repository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        repository.deleteById(id);
    }
}