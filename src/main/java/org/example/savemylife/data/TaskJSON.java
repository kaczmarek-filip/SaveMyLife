package org.example.savemylife.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.example.savemylife.interfaces.JsonMethods;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskJSON implements JsonMethods<Task> {
    private static final String FILE_PATH = "task.json";
    @Getter
    private List<Task> taskList;
    private ObjectMapper objectMapper;
    private static TaskJSON instance;

    public TaskJSON() {
        this.taskList = new ArrayList<>();
        this.objectMapper = new ObjectMapper();
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

    private void loadTasks() {
        File file = new File(FILE_PATH);
        try {
            if (file.exists()) {
                taskList = objectMapper.readValue(file, new TypeReference<List<Task>>() {});
            }
        } catch (IOException e) {
            taskList = new ArrayList<>();
            e.printStackTrace();
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
