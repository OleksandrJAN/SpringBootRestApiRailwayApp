package com.railwayApp.api.repo;

import com.railwayApp.api.domain.Route;
import com.railwayApp.api.domain.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepo extends JpaRepository<Route, Long> {
}
