package com.example.DaliyOptimizer.service;

import com.example.DaliyOptimizer.model.Task;
import com.example.DaliyOptimizer.model.dto.TaskCreate;
import com.example.DaliyOptimizer.model.dto.TaskEdit;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> listAll();
    Optional<Task> findById(int id);
    void deleteById(int id);
    Optional<Task> create(TaskCreate task);
    Optional<Task> edit(int id, TaskEdit task);


}
