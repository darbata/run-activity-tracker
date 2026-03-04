package io.darbata.runactivitytracker.tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class RunActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float distance;
    private float averagePace;
    private int averageHeartRate;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public RunActivity() {}

    public RunActivity(long id, float distance, float averagePace, int averageHeartRate,
                       LocalDateTime createdAt, LocalDateTime updatedAt
    ) {
        this.id = id;
        this.distance = distance;
        this.averagePace = averagePace;
        this.averageHeartRate = averageHeartRate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getAveragePace() {
        return averagePace;
    }

    public void setAveragePace(float averagePace) {
        this.averagePace = averagePace;
    }

    public int getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(int averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}