package com.example.DaliyOptimizer.model;

import lombok.Data;

import javax.persistence.*;

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

    @OneToMany
    private Task tasks;

    public User()
    {
    }

    public User(Long id,String name, String username, String email, String password,Task tasks)
    {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tasks = tasks;
    }
}
