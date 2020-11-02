package com.railwayApp.api.repo;

import com.railwayApp.api.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepo extends JpaRepository<Station, Long> {
    Optional<Station> findByName(String name);
}
