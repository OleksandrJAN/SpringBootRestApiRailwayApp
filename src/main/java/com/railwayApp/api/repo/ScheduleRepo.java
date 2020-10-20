package com.railwayApp.api.repo;

import com.railwayApp.api.domain.Schedule;
import com.railwayApp.api.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
}
