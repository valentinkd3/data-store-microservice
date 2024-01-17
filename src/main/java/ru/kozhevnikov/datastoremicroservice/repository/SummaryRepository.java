package ru.kozhevnikov.datastoremicroservice.repository;

import ru.kozhevnikov.datastoremicroservice.model.Data;
import ru.kozhevnikov.datastoremicroservice.model.MeasurementType;
import ru.kozhevnikov.datastoremicroservice.model.Summary;
import ru.kozhevnikov.datastoremicroservice.model.SummaryType;

import java.util.Optional;
import java.util.Set;

public interface SummaryRepository {

    Optional<Summary> findBySensorId(
            long sensorId,
            Set<MeasurementType> measurementTypes,
            Set<SummaryType> summaryTypes
    );

    void handle(Data data);
}
