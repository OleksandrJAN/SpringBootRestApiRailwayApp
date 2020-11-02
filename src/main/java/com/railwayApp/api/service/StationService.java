package com.railwayApp.api.service;

import com.railwayApp.api.domain.Station;
import com.railwayApp.api.repo.StationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {

    private final StationRepo stationRepo;

    @Autowired
    public StationService(StationRepo stationRepo) {
        this.stationRepo = stationRepo;
    }

    public List<String> getStationsNames() {
        return stationRepo.findAll()
                .stream()
                .map(Station::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    public Station getStationByName(String name) {
        Station station = stationRepo
                .findByName(name)
                .orElseThrow(() -> new RuntimeException("Station with name '" + name + "' not found"));
        return station;
    }
}
