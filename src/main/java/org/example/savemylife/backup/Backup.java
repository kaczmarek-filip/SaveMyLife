package org.example.savemylife.backup;

import org.example.savemylife.data.Task;
import org.example.savemylife.data.TaskJSON;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Backup {

    public static void main(String[] args) {

        for (Task task : TaskJSON.getInstance().getTaskList()) {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

            LocalDateTime savedDate = task.getStartTime();

            long initialDelay = calculateInitialDelay(savedDate, Duration.ofSeconds(task.getFrequencyInSeconds()));

            executorService.scheduleAtFixedRate(() -> {
                new Copy(task).copy();
            }, initialDelay, task.getFrequencyInSeconds(), TimeUnit.SECONDS);
        }

    }
    private static long calculateInitialDelay(LocalDateTime savedDate, Duration frequency) {
        LocalDateTime now = LocalDateTime.now();
        long secondsBetween = ChronoUnit.SECONDS.between(savedDate, now);
        long frequencySeconds = frequency.getSeconds();


        long initialDelay = frequencySeconds - (secondsBetween % frequencySeconds);
        return initialDelay;
    }
}
