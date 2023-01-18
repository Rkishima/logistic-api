package com.rkorp.logisticapi.api.mapper;

import com.rkorp.logisticapi.api.DTO.OccurrenceDTO;
import com.rkorp.logisticapi.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurrenceMapper {

    private ModelMapper modelMapper;

    public OccurrenceDTO toModel(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrenceDTO.class);
    }

    public List<OccurrenceDTO> toCollectionModel(List<Occurrence> occurrence) {
        return occurrence.stream().map(this::toModel).collect(Collectors.toList());
    }
}
