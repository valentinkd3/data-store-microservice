package ru.kozhevnikov.datastoremicroservice.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.kozhevnikov.datastoremicroservice.model.MeasurementType;
import ru.kozhevnikov.datastoremicroservice.model.Summary;


import java.util.List;
import java.util.Map;

import static ru.kozhevnikov.datastoremicroservice.model.Summary.*;

@Getter
@Setter
@ToString
public class SummaryDto {

    private long sensorId;

    private Map<MeasurementType, List<SummaryEntry>> values;
}
