package io.darbata.runactivitytracker.tracker;

public record RunActivityDto(
        long id,
        float distance,
        float averagePace,
        int averageHeartRate,
        String createdAt,
        String updatedAt
) {}