package org.example.savemylife.logs;

import org.example.savemylife.data.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private final LocalDateTime logTime;
    private final String logMessage;
    private final Task task;
    private StringBuilder stringBuilder = new StringBuilder();

    public Log(Task task, String logMessage) {
        this.task = task;
        this.logTime = LocalDateTime.now();
        this.logMessage = logMessage;

        stringBuilder
                .append("[")
                .append(formatDate(logTime))
                .append("] ")
                .append("[")
                .append(task.getName())
                .append("] ")
                .append(logMessage);
    }

    public void show() {
        System.out.println(stringBuilder);
    }
    public void err() {
        System.err.println(stringBuilder);
    }

    private String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }
}
