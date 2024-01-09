package com.example.DaliyOptimizer.service.impl;

import com.example.DaliyOptimizer.model.Task;
import com.example.DaliyOptimizer.model.dto.TaskCreate;
import com.example.DaliyOptimizer.model.dto.TaskEdit;
import com.example.DaliyOptimizer.service.TaskService;
import org.springframework.stereotype.Service;
import com.example.DaliyOptimizer.repository.TaskRepository;

import java.util.List;
import java.util.Optional;
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listAll() {
        return this.taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(int id) {
        return this.taskRepository.findById((long) id);
    }

    @Override
    public void deleteById(int id) {
        this.taskRepository.deleteById((long) id);
    }

    @Override
    public Optional<Task> create(TaskCreate task) {
        Task t = new Task(task.getName(), task.getDescription(),task.getDateCreated());
        this.taskRepository.save(t);
        return Optional.of(t);
    }

    @Override
    public Optional<Task> edit(int id, TaskEdit task) {
        Task t = this.taskRepository.getById((long) id);
        t.setName(task.getName());
        t.setDescription(task.getDescription());
        t.setDateCreated(task.getDateCreated());
        this.taskRepository.save(t);
        return Optional.of(t);
    }

}
