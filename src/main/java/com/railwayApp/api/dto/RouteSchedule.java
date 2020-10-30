package com.railwayApp.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.railwayApp.api.domain.Route;
import com.railwayApp.api.domain.Schedule;
import com.railwayApp.api.domain.Station;
import com.railwayApp.api.domain.Train;
import com.railwayApp.api.serializer.RouteScheduleSerializer;
import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@JsonSerialize(using = RouteScheduleSerializer.class)
public class RouteSchedule {

    private Train train;
    private List<Pair<Station, Schedule>> stationsSchedule;

    public RouteSchedule(Route route) {
        this.train = route.getTrain();

        this.stationsSchedule = route.getStationsTrainSchedules().stream()
                .map(routeStationSchedule -> {
                    Station station = routeStationSchedule.getStation();
                    Schedule schedule = routeStationSchedule.getSchedule();
                    return new Pair<>(station, schedule);
                })
                .collect(Collectors.toList());
    }
}
