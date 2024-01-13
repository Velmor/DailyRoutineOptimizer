package com.example.DaliyOptimizer.service.NotificatonService;

import com.example.DaliyOptimizer.model.Task;
import com.example.DaliyOptimizer.model.User;
import com.example.DaliyOptimizer.repository.TaskRepository;
import com.example.DaliyOptimizer.service.NotificatonService.NotificationService;
import com.example.DaliyOptimizer.service.TaskService;
import com.example.DaliyOptimizer.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class NotificationTaskService {

    @Autowired
    private TaskServiceImpl taskServiceImpl;

    private final TaskRepository taskRepository; // Inject your TaskRepository here
    private final NotificationService notificationService; // Inject your NotificationService here

    @Autowired
    public NotificationTaskService(TaskRepository taskRepository, NotificationService notificationService) {
        this.taskRepository = taskRepository;
        this.notificationService = notificationService;
    }

    // Schedule the task to run every hour (adjust the cron expression as needed)
    @Scheduled(cron = "0 0 * * * *")
    public void sendTaskReminders(User user) {
        List<Task> upcomingTasks = user.getTasks();

        for (Task task : upcomingTasks) {
            String recipientEmail = user.getEmail(); // Assuming user has an email
            String subject = "Task Reminder: " + task.getName();
            String message = "You have an upcoming task: " + task.getName() + " due on " + task.getDeadline();
            notificationService.sendEmailNotification(recipientEmail, subject, message);
        } }

        public void sendTaskNotifications() {
            // Get the current date
            Date currentDate = new Date();

            // Retrieve upcoming tasks with deadlines within a specific time frame (e.g., within the next day)
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);
            calendar.add(Calendar.DAY_OF_MONTH, 1); // Adjust the time frame as needed
            Date tomorrowDate = calendar.getTime();

            List<Task> upcomingTasks = taskRepository.findByDeadlineBetween(currentDate, tomorrowDate);

            // Iterate through the upcoming tasks and send notifications
            for (Task task : upcomingTasks) {
                // Check if the task is not completed
                if (!task.isCompleted()) {
                    // Customize the notification message based on your requirements
                    String recipientEmail = task.getUser().getEmail(); // Assuming User has an email property
                    String subject = "Task Reminder: " + task.getName();
                    String message = "You have an upcoming task: " + task.getName() + " due on " + task.getDeadline();

                    // Send the notification (you can use your notification service here)
                    notificationService.sendEmailNotification(recipientEmail, subject, message);

                    // You can add additional logic for other types of notifications (e.g., push notifications)
                }
            }
        }

 }
