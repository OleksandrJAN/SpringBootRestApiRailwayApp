package com.railwayApp.api.controller;

import com.railwayApp.api.domain.Station;
import com.railwayApp.api.dto.RouteDto;
import com.railwayApp.api.dto.RouteSchedule;
import com.railwayApp.api.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }


    @GetMapping("/routes")
    public ResponseEntity<List<RouteDto>> getRoutes(
            @RequestParam(name = "from") Station departureStation,
            @RequestParam(name = "to") Station arrivalStation
    ) {
        List<RouteDto> routes = routeService.getRoutes(departureStation, arrivalStation);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("/routes/{routeId}")
    public ResponseEntity<RouteSchedule> getRoute(@PathVariable Long routeId) {
        RouteSchedule route = routeService.getRouteInfo(routeId);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }
}
