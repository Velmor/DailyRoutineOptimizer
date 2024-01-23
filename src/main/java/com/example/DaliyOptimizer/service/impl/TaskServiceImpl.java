package com.example.DaliyOptimizer.service.impl;

import com.example.DaliyOptimizer.model.Task;
import com.example.DaliyOptimizer.model.dto.TaskCreate;
import com.example.DaliyOptimizer.model.dto.TaskEdit;
import com.example.DaliyOptimizer.service.TaskService;
import org.springframework.stereotype.Service;
import com.example.DaliyOptimizer.repository.TaskRepository;

import java.util.Date;
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
    public Optional<Task> create(TaskCreate taskCreate) {
        // Extract properties from taskCreate DTO (Data Transfer Object)
        String name = taskCreate.getName();
        String description = taskCreate.getDescription();
        Date dateCreated = taskCreate.getDateCreated();
        String priority = taskCreate.getPriority();
        Date deadline = taskCreate.getDeadLine();
        boolean completed = taskCreate.isCompleted(); // Assuming a boolean property for completion status

        // Create a new Task entity
        Task task = new Task(name, description, dateCreated, priority, deadline, completed);

        // Save the task to the database
        task = taskRepository.save(task);

        // Return the saved task as an Optional
        return Optional.ofNullable(task);
    }

    @Override
    public Optional<Task> edit(int id, TaskEdit taskEdit) {
        // Check if a task with the given ID exists
        if (!taskRepository.existsById((long) id)) {
            return Optional.empty(); // Task with the given ID does not exist
        }

        // Retrieve the task by ID
        Task existingTask = taskRepository.getById((long) id);

        // Update the task properties based on taskEdit DTO
        existingTask.setName(taskEdit.getName());
        existingTask.setDescription(taskEdit.getDescription());
        existingTask.setDateCreated(taskEdit.getDateCreated());

        // Save the updated task to the database
        Task updatedTask = taskRepository.save(existingTask);

        // Return the updated task as an Optional
        return Optional.of(updatedTask);
    }

    @Override
    public List<Task> findByPriority(String priority) {
        // Using the taskRepository to find tasks by priority
        return taskRepository.findByPriority(priority);
    }

    @Override
    public List<Task> findByDeadlineAfter(Date startDate)
    {
        Date endDate = new Date(Long.MAX_VALUE); // Set a default end date
        return taskRepository.findByDeadLineBetween(startDate, endDate);
    }

    public List<Task> getUpcomingTasks() {
        // Get the current date
        Date currentDate = new Date();

        // Use the repository method to retrieve upcoming tasks
        return taskRepository.findByDeadLineAfter(currentDate);
    }

}
