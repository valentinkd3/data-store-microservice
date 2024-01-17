package ru.kozhevnikov.datastoremicroservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kozhevnikov.datastoremicroservice.model.Data;
import ru.kozhevnikov.datastoremicroservice.model.MeasurementType;
import ru.kozhevnikov.datastoremicroservice.model.Summary;
import ru.kozhevnikov.datastoremicroservice.model.SummaryType;
import ru.kozhevnikov.datastoremicroservice.model.exception.SensorNotFoundException;
import ru.kozhevnikov.datastoremicroservice.repository.SummaryRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService{

    private final SummaryRepository summaryRepository;

    @Override
    public Summary get(
            long sensorId,
            Set<MeasurementType> measurementTypes,
            Set<SummaryType> summaryTypes
    ) {
        return summaryRepository.findBySensorId(
                sensorId,
                measurementTypes == null ? Set.of(MeasurementType.values()) : measurementTypes,
                summaryTypes == null ? Set.of(SummaryType.values()) : summaryTypes
        )
                .orElseThrow(SensorNotFoundException::new);
    }

    @Override
    public void handle(Data data) {
        summaryRepository.handle(data);
    }
}
