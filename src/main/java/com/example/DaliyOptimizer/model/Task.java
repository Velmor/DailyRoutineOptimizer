package com.example.DaliyOptimizer.model;


import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name="date_created")
    private LocalDateTime dateCreated;

    public Task() {
    }

    public Task(String description, String name, LocalDateTime dateCreated) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
    }
    // Other fields, getters, and setters
}
