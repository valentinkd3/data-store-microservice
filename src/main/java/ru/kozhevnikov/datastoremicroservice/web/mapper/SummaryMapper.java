package ru.kozhevnikov.datastoremicroservice.web.mapper;

import org.mapstruct.Mapper;
import ru.kozhevnikov.datastoremicroservice.model.Summary;
import ru.kozhevnikov.datastoremicroservice.web.dto.SummaryDto;

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappable<Summary, SummaryDto> {
}
