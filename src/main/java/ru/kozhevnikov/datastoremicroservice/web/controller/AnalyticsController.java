package ru.kozhevnikov.datastoremicroservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kozhevnikov.datastoremicroservice.model.MeasurementType;
import ru.kozhevnikov.datastoremicroservice.model.Summary;
import ru.kozhevnikov.datastoremicroservice.model.SummaryType;
import ru.kozhevnikov.datastoremicroservice.service.SummaryService;
import ru.kozhevnikov.datastoremicroservice.web.dto.SummaryDto;
import ru.kozhevnikov.datastoremicroservice.web.mapper.SummaryMapper;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final SummaryService summaryService;

    private final SummaryMapper summaryMapper;

    @GetMapping("/summary/{sensorId}")
    public SummaryDto getSummary(
            @PathVariable long sensorId,
            @RequestParam(value = "mt", required = false)
            Set<MeasurementType> measurementTypes,
            @RequestParam(value = "st", required = false)
            Set<SummaryType> summaryTypes
    ){
        Summary summary = summaryService.get(
                sensorId,
                measurementTypes,
                summaryTypes
        );
        return summaryMapper.toDto(summary);
    }
}
