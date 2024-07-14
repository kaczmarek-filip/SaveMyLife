package org.example.savemylife.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.example.savemylife.interfaces.JsonMethods;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskJSON implements JsonMethods<Task> {
    private static final String FILE_PATH = "task.json";
    @Getter
    private List<Task> taskList;
    private ObjectMapper objectMapper;
    private static TaskJSON instance;

    private TaskJSON() {
        this.taskList = new ArrayList<>();
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        loadTasks();
        instance = this;
    }

    @Override
    public void add(Task task) {
        taskList.add(task);
        saveTasks();
    }

    @Override
    public void delete(Task task) {
        taskList.remove(task);
        saveTasks();
    }

    @Override
    public void update(Task task) {
        int index = taskList.indexOf(task);
        if (index >= 0) {
            taskList.set(index, task);
            saveTasks();
        }
    }

    public void update(UUID uuid, Task updatedTask) {
        updatedTask.setId(uuid);
        for (Task task : taskList) {
            if (task.getId().equals(uuid)) {
                int index = taskList.indexOf(task);
                taskList.set(index, updatedTask);
                saveTasks();
                return;
            }
        }

        System.err.println("Task not found");
    }

    private void loadTasks() {
        File file = new File(FILE_PATH);
        try {
            if (file.exists()) {
                taskList = objectMapper.readValue(file, new TypeReference<List<Task>>() {
                });
            }
        } catch (IOException e) {
            taskList = new ArrayList<>();
            System.err.println("Error loading task list");
            e.printStackTrace();
            //tODO: Co w przypadku braku pliku
        }
    }

    private void saveTasks() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), taskList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TaskJSON getInstance() {
        if (instance == null) {
            instance = new TaskJSON();
        }
        return instance;
    }
}
