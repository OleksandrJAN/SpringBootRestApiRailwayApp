package com.railwayApp.api.controller;

import com.railwayApp.api.domain.Station;
import com.railwayApp.api.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StationController {

    private final StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/stations")
    public ResponseEntity<List<Station>> getStations() {
        List<Station> stations = stationService.getStations();
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }
}
