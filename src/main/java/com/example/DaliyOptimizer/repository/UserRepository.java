package com.example.DaliyOptimizer.repository;

import com.example.DaliyOptimizer.model.Task;
import com.example.DaliyOptimizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>
{
}
