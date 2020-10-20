package com.railwayApp.api.controller;

import com.railwayApp.api.domain.Route;
import com.railwayApp.api.domain.Station;
import com.railwayApp.api.dto.RouteDto;
import com.railwayApp.api.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
            @RequestParam(name = "from", required = false) Station departureStation,
            @RequestParam(name = "to", required = false) Station arrivalStation
    ) {
        List<RouteDto> routes = routeService.getRoutes(departureStation, arrivalStation);
        return new ResponseEntity<>(routes, HttpStatus.OK);
    }

    @GetMapping("/routes/{routeId}")
    public ResponseEntity<RouteDto> getRoute(@PathVariable Long routeId) {
        RouteDto route = routeService.getRoute(routeId);
        return new ResponseEntity<>(route, HttpStatus.OK);
    }
}
