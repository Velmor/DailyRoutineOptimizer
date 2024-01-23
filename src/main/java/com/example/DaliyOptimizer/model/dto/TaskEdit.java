package com.example.DaliyOptimizer.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TaskEdit {
    private String name;
    private String description;
    private Date dateCreated;

    public TaskEdit(String name, String description, Date dateCreated) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
    }
}
