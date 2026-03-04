package io.darbata.runactivitytracker.tracker;

import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ActivityTrackerService {

    private final RunActivityRepository repository;

    public ActivityTrackerService(RunActivityRepository repository) {
        this.repository = repository;
    }

    public List<RunActivityDto> findAllRunActivities() {
        List<RunActivity> runActivities = repository.findAll();
        return mapRunActivitiesToDto(runActivities);
    }

    public RunActivity saveRunActivity(float distance, float averagePace, int averageHeartRate ) {
        RunActivity activity = new RunActivity(0, distance, averagePace, averageHeartRate, null, null);
        return repository.save(activity);
    }

    private RunActivityDto mapRunActivityToDto(RunActivity runActivity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return new RunActivityDto(
                runActivity.getId(),
                runActivity.getDistance(),
                runActivity.getAveragePace(),
                runActivity.getAverageHeartRate(),
                runActivity.getCreatedAt().format(formatter),
                runActivity.getUpdatedAt().format(formatter)
        );
    }

    private List<RunActivityDto> mapRunActivitiesToDto(List<RunActivity> runActivities) {
        return runActivities.stream().map(this::mapRunActivityToDto).toList();
    }

    public void deleteRunActivity(long runId) {
        repository.deleteById(runId);
    }
}
