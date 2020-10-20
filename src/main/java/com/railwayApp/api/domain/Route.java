package com.railwayApp.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "routes")
@Getter
@Setter
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "route")
    @JsonBackReference
    private List<RouteStationSchedule> stationsTrainSchedules;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    private Train train;

    @JsonIgnore
    public List<Station> getStations() {
        return stationsTrainSchedules.stream()
                .map(RouteStationSchedule::getStation)
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<Schedule> getSchedule() {
        return stationsTrainSchedules.stream()
                .map(RouteStationSchedule::getSchedule)
                .collect(Collectors.toList());
    }

}
