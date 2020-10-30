package com.railwayApp.api.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.railwayApp.api.domain.Schedule;
import com.railwayApp.api.domain.Station;
import com.railwayApp.api.dto.RouteSchedule;
import javafx.util.Pair;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.List;

@JsonComponent
public class RouteScheduleSerializer extends JsonSerializer<RouteSchedule> {
    @Override
    public void serialize(
            RouteSchedule routeSchedule,
            JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider
    ) throws IOException {
        jsonGenerator.writeStartObject();

        // serialize Train
        jsonGenerator.writeObjectField("train", routeSchedule.getTrain());

        // start serialize List<Pair<Station, Schedule>>
        jsonGenerator.writeArrayFieldStart("stationsSchedule");
        List<Pair<Station, Schedule>> stationsSchedule = routeSchedule.getStationsSchedule();
        for (Pair<Station, Schedule> stationSchedulePair : stationsSchedule) {
            // start serialize Pair<Station, Schedule>
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("station", stationSchedulePair.getKey());
            jsonGenerator.writeObjectField("schedule", stationSchedulePair.getValue());
            jsonGenerator.writeEndObject();
            // end serialize Pair<Station, Schedule>
        }
        jsonGenerator.writeEndArray();
        // end serialize List<Pair<Station, Schedule>>

        jsonGenerator.writeEndObject();
    }
}
