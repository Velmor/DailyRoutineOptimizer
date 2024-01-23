package com.example.DaliyOptimizer.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public User()
    {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name, String username, String email, String password, List<Task> tasks)
    {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tasks = tasks;
    }
}
