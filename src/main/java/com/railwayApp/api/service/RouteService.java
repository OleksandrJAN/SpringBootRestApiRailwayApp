package com.railwayApp.api.service;

import com.railwayApp.api.domain.Route;
import com.railwayApp.api.domain.Station;
import com.railwayApp.api.dto.RouteDto;
import com.railwayApp.api.dto.RouteSchedule;
import com.railwayApp.api.repo.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class RouteService {

    private final RouteRepo routeRepo;

    @Autowired
    public RouteService(RouteRepo routeRepo) {
        this.routeRepo = routeRepo;
    }


    public List<RouteDto> getRoutes(Station from, Station to) {
        // get all routes that pass through the stations
        Set<Route> fromRoutes = from.getRoutes();
        Set<Route> toRoutes = to.getRoutes();

        // find the intersection of routes
        fromRoutes.retainAll(toRoutes);

        // determine a direction of route
        Predicate<Route> directionFilter = route -> {
            List<Station> stations = route.getStations();
            int fromId = stations.indexOf(from);
            int toId = stations.indexOf(to);
            return fromId < toId;
        };

        return fromRoutes.stream()
                .filter(directionFilter)
                .map(route -> new RouteDto(route, from, to))
                .sorted(Comparator.comparingInt(RouteDto::getDepartureTime))
                .collect(Collectors.toList());
    }

    public RouteSchedule getRouteInfo(Long id) {
        Route route = routeRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("route with id '" + id + "' not found"));
        return new RouteSchedule(route);
    }

}
