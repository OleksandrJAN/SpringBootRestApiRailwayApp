package com.railwayApp.api.converter;

import com.railwayApp.api.domain.Station;
import com.railwayApp.api.service.StationService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StationConverter implements Converter<String, Station> {

    private final StationService stationService;

    public StationConverter(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public Station convert(String s) {
        Station station = stationService.getStationByName(s);
        return station;
    }
}
