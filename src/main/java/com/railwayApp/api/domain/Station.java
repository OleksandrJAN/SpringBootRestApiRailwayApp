package com.railwayApp.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "stations")
@Getter
@Setter
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @OneToMany(mappedBy = "station")
    @JsonBackReference
    private List<RouteStationSchedule> routesTrainSchedules;

    @JsonIgnore
    public Set<Route> getRoutes() {
        return routesTrainSchedules.stream()
                .map(RouteStationSchedule::getRoute)
                .collect(Collectors.toSet());
    }

}
