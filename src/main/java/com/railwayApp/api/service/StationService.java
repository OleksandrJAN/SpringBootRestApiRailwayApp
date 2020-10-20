package com.railwayApp.api.service;

import com.railwayApp.api.domain.Station;
import com.railwayApp.api.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final StationRepo stationRepo;

    @Autowired
    public StationService(StationRepo stationRepo) {
        this.stationRepo = stationRepo;
    }

    public List<Station> getStations() {
        return stationRepo.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
