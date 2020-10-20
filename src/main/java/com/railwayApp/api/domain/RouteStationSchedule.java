package com.railwayApp.api.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "route_station_schedule")
@Getter
@Setter
public class RouteStationSchedule {

    @EmbeddedId
    private RouteStationScheduleKey id;

    @ManyToOne
    @MapsId("route_id")
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @MapsId("station_id")
    @JoinColumn(name = "station_id")
    private Station station;

    @ManyToOne
    @MapsId("schedule_id")
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

}
