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
    private Station fromRouteStation;
    private Station toRouteStation;
    private Station fromUserStation;
    private Station toUserStation;
    private Integer departureTime;
    private Integer arrivalTime;

    public RouteDto(Route route, Station fromStation, Station toStation) {
        this.id = route.getId();
        this.train = route.getTrain();

        List<Station> routeStations = route.getStations();
        this.fromRouteStation = routeStations.get(0);
        this.toRouteStation = routeStations.get(routeStations.size() - 1);
        this.fromUserStation = fromStation;
        this.toUserStation = toStation;

        int fromStationIndex = routeStations.indexOf(fromStation);
        int toStationIndex = routeStations.indexOf(toStation);
        List<Schedule> routeSchedule = route.getSchedule();
        Schedule departureSchedule = routeSchedule.get(fromStationIndex);
        Schedule arrivalSchedule = routeSchedule.get(toStationIndex);
        this.departureTime = departureSchedule.getDepartureTime();
        this.arrivalTime = arrivalSchedule.getArrivalTime();
    }

}
