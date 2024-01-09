package com.example.DaliyOptimizer.web.controller;

import com.example.DaliyOptimizer.model.Task;
import com.example.DaliyOptimizer.model.dto.TaskCreate;
import com.example.DaliyOptimizer.model.dto.TaskEdit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.DaliyOptimizer.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.listAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> optionalEntity = taskService.findById(Math.toIntExact(id));

        if (optionalEntity.isPresent()) {
            return ResponseEntity.ok(optionalEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/create")
    public Optional<Task> createTask(TaskCreate task)
    {
        return taskService.create(task);
    }
    @PostMapping("/update/{id}")
    public Optional<Task> updateTask(@PathVariable int id,TaskEdit task){
        return taskService.edit(id, task);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.deleteById(id);
    }
}
