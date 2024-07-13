package org.example.savemylife.data;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.UUID;

@Getter
@Setter
public class Task {
    private UUID id;
    private String name;
    private File from;
    private File to;
    private int frequency;

    public Task(String name, File from, File to, int frequency) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.from = from;
        this.to = to;
        this.frequency = frequency;
    }

    public Task() {
        this.id = UUID.randomUUID();
    }
}
