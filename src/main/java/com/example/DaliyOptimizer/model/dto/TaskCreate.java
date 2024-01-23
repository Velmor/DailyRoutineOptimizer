package com.example.DaliyOptimizer.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TaskCreate {
    private String name;
    private String description;
    private Date dateCreated;
    private String priority;
    private Date deadLine;
    private boolean completed;

    public TaskCreate(String name, String description, Date dateCreated, String priority, Date deadLine, boolean completed) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.priority = priority;
        this.deadLine = deadLine;
        this.completed = completed;
    }
}
