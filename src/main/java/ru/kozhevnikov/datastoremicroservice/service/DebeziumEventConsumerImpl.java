package ru.kozhevnikov.datastoremicroservice.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.kozhevnikov.datastoremicroservice.model.Data;
import ru.kozhevnikov.datastoremicroservice.model.MeasurementType;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

@Service
@RequiredArgsConstructor
public class DebeziumEventConsumerImpl implements ChangesDataCaptureEventConsumer{

    private final SummaryService summaryService;

    @Override
    @KafkaListener(topics = "data")
    public void handle(String message) {
        try{
            JsonObject payload = JsonParser.parseString(message)
                    .getAsJsonObject()
                    .get("payload")
                    .getAsJsonObject();
            Data data = Data.builder()
                    .id(payload.get("id").getAsLong())
                    .sensorId(payload.get("sensor_id").getAsLong())
                    .measurement(payload.get("measurement").getAsDouble())
                    .measurementType(MeasurementType.valueOf(payload.get("type").getAsString()))
                    .timestamp(LocalDateTime.ofInstant(
                            Instant.ofEpochMilli(
                                    payload.get("timestamp").getAsLong()/1000
                            ),
                            TimeZone.getDefault().toZoneId()
                    ))
                    .build();
            summaryService.handle(data);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
