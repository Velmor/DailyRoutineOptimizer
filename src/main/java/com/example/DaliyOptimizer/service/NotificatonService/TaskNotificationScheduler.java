package com.example.DaliyOptimizer.service.NotificatonService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationScheduler
{
    private final NotificationTaskService notificationTaskService;

    public TaskNotificationScheduler(NotificationTaskService notificationTaskService) {
        this.notificationTaskService = notificationTaskService;
    }

    @Scheduled(fixedRate = 60000) // Run every minute (adjust as needed)
    public void sendTaskNotifications() {
        notificationTaskService.sendTaskNotifications();
    }
}
