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

    public Task(String name, String from, String to) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public Task() {}
}
