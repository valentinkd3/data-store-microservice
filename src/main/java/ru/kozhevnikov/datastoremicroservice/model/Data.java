package ru.kozhevnikov.datastoremicroservice.model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Data {

    private Long id;

    private Long sensorId;

    private LocalDateTime timestamp;

    private double measurement;

    private MeasurementType measurementType;
}