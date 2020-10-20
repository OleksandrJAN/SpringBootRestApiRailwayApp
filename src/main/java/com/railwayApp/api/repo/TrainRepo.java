package com.railwayApp.api.repo;

import com.railwayApp.api.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepo extends JpaRepository<Train, Long> {
}
