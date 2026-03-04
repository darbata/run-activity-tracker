package io.darbata.runactivitytracker.tracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RunActivityRepository extends JpaRepository<RunActivity, Long> {}