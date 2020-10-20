package com.railwayApp.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "schedule")
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "arrival_time")
    private int arrivalTime;

    @Column(name = "departure_time")
    private int departureTime;

    @Column(name = "downtime")
    private int downtime;

    @OneToMany(mappedBy = "schedule")
    @JsonBackReference
    private List<RouteStationSchedule> routesStationTrains;

}
