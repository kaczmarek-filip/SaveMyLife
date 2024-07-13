package org.example.savemylife.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Task {
    private UUID id;
    private String name;
    private File from;
    private File to;
    private int frequency;
    private FrequencyEnum frequencyEnum;
    private String frequencyWithUtil;

    public Task(String name, File from, File to, int frequency, FrequencyEnum frequencyEnum) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.from = from;
        this.to = to;
        this.frequency = frequency;
        this.frequencyEnum = frequencyEnum;

        this.frequencyWithUtil = frequency + " " + frequencyEnum.getLabel();
    }
}
