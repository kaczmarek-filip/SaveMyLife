package org.example.savemylife.data;

import lombok.Getter;

@Getter
public enum FrequencyEnum {
    MINUTES("Minutes"),
    HOURS("Hours"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months");


    private final String label;

    FrequencyEnum(String label) {
        this.label = label;
    }

    public static FrequencyEnum fromString(String text) {
        for (FrequencyEnum frequency : FrequencyEnum.values()) {
            if (frequency.label.equalsIgnoreCase(text)) {
                return frequency;
            }
        }
        return null;
    }

}
