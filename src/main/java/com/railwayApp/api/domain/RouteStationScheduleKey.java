package com.railwayApp.api.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class RouteStationScheduleKey implements Serializable {

    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "station_id")
    private Long stationId;

    @Column(name = "schedule_id")
    private Long scheduleId;

}
