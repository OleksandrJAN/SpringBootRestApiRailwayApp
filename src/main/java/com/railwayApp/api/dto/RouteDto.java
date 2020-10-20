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
    private Integer travelTime;


    public RouteDto(Route route) {
        this.id = route.getId();
        this.train = route.getTrain();

        List<Station> routeStations = route.getStations();
        Station fromStation = routeStations.get(0);
        Station toStation = routeStations.get(routeStations.size() - 1);
        this.fromRouteStation = fromStation;
        this.toRouteStation = toStation;
        this.fromUserStation = fromStation;
        this.toUserStation = toStation;

        List<Schedule> routeSchedule = route.getSchedule();
        Schedule departureSchedule = routeSchedule.get(0);
        Schedule arrivalSchedule = routeSchedule.get(routeSchedule.size() - 1);
        this.departureTime = departureSchedule.getDepartureTime();
        this.arrivalTime = arrivalSchedule.getArrivalTime();
        this.travelTime = arrivalTime - departureTime;
    }

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
        this.travelTime = arrivalTime - departureTime;
    }

}
