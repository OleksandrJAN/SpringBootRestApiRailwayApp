package com.railwayApp.api.service;

import com.railwayApp.api.domain.Route;
import com.railwayApp.api.domain.Station;
import com.railwayApp.api.dto.RouteDto;
import com.railwayApp.api.repo.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RouteService {

    private final RouteRepo routeRepo;

    @Autowired
    public RouteService(RouteRepo routeRepo) {
        this.routeRepo = routeRepo;
    }


    public List<RouteDto> getRoutes(Station from, Station to) {
        Set<Route> fromRoutes = from.getRoutes();
        Set<Route> toRoutes = to.getRoutes();
        fromRoutes.retainAll(toRoutes);

        return fromRoutes.stream()
                .map(RouteDto::new)
                .collect(Collectors.toList());
    }

    public List<RouteDto> getRoutes() {
        return routeRepo.findAll()
                .stream()
                .map(RouteDto::new)
                .collect(Collectors.toList());
    }

    public RouteDto getRoute(Long id) {
        Route route = routeRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("route with id = '" + id + "' not found"));
        return new RouteDto(route);
    }

}
