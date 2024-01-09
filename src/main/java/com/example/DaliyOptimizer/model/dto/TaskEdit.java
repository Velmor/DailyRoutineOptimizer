package com.example.DaliyOptimizer.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskEdit {
    private String name;
    private String description;
    private LocalDateTime dateCreated;

    public TaskEdit(String name, String description, LocalDateTime dateCreated) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
    }
}
