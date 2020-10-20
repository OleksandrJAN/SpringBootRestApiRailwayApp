package com.railwayApp.api.dto;

import com.railwayApp.api.domain.Route;
import com.railwayApp.api.domain.Schedule;
import com.railwayApp.api.domain.Station;
import com.railwayApp.api.domain.Train;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteDto {

    private Long id;
    private Train train;
    private Station arrivalStation;
    private Station departureStation;
    private int arrivalTime;
    private int departureTime;
    private int travelTime;


    public RouteDto(Route route) {
        this.id = route.getId();
        this.train = route.getTrain();

        List<Station> routeStations = route.getStations();
        this.arrivalStation = routeStations.get(0);
        this.departureStation = routeStations.get(routeStations.size() - 1);

        List<Schedule> routeSchedule = route.getSchedule();
        this.departureTime = routeSchedule.get(0).getDepartureTime();
        this.arrivalTime = routeSchedule.get(routeSchedule.size() - 1).getArrivalTime();

    }

}
