package org.example.savemylife.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Task {
    private UUID id;
    private String name;
    private File source;
    private File target;
    private int frequency;
    private FrequencyEnum frequencyEnum;
    private long frequencyInSeconds;
    private String frequencyWithUtil;
    private LocalDateTime startTime;

    public Task(String name, File source, File target, int frequency, FrequencyEnum frequencyEnum, LocalDateTime startTime) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.source = source;
        this.target = target;
        this.frequency = frequency;
        this.frequencyEnum = frequencyEnum;
        this.frequencyInSeconds = convertToSeconds(frequency, frequencyEnum);
        this.startTime = startTime;

        this.frequencyWithUtil = frequency + " " + frequencyEnum.getLabel();
    }

    public static long convertToSeconds(int frequency, FrequencyEnum frequencyEnum) {
        Duration duration = null;
        switch (frequencyEnum) {
            case MINUTES -> duration = Duration.ofMinutes(frequency);
            case HOURS -> duration = Duration.ofHours(frequency);
            case DAYS -> duration = Duration.ofDays(frequency);
            case WEEKS -> duration = Duration.ofDays(frequency * 7L);
            case MONTHS -> duration = Duration.ofDays(frequency * 30L);
        }

        return duration.toSeconds();
    }
}
