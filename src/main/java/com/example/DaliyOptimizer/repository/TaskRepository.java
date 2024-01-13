package com.example.DaliyOptimizer.repository;

import com.example.DaliyOptimizer.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByPriority(String priority);
    List<Task> findByDeadlineAfter(Date currentDate);
    List<Task> findByDeadlineBetween(Date startDate, Date endDate);
}
