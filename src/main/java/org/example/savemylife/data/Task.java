package org.example.savemylife.data;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Task {
    private UUID id;
    private String name;
    private String from;
    private String to;
    private int frequency;

    public Task(String name, String from, String to, int frequency) {
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
