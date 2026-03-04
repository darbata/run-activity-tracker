package io.darbata.runactivitytracker.tracker;

public record RunActivityPostRequest(
        float distance,
        float averagePace,
        int averageHeartRate
) { }