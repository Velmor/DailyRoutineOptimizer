package com.example.DaliyOptimizer.model;


import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "priority")
    private String priority;
    @Column(name ="name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name="date_created")
    private Date dateCreated;
    private Date deadLine;
    private boolean completed;

    public Task() {
    }

    public Task(String description, String name, Date dateCreated,String priority,Date deadLine,boolean completed) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.priority = priority;
        this.deadLine = deadLine;
        this.completed = completed;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    // Other fields, getters, and setters
}
