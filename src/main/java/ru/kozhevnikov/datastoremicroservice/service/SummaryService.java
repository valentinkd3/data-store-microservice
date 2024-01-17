package ru.kozhevnikov.datastoremicroservice.service;

import ru.kozhevnikov.datastoremicroservice.model.Data;
import ru.kozhevnikov.datastoremicroservice.model.MeasurementType;
import ru.kozhevnikov.datastoremicroservice.model.Summary;
import ru.kozhevnikov.datastoremicroservice.model.SummaryType;

import java.util.Set;

public interface SummaryService {

    Summary get(
            long sensorId,
            Set<MeasurementType> measurementTypes,
            Set<SummaryType> summaryTypes
    );

    void handle(Data data);
}
