package com.example.rest.mapper;

import com.example.rest.dto.CarDto;
import com.example.rest.entity.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;



@Mapper(
        componentModel = "spring"
)
public interface CarMapper {
    CarEntity toEntity(CarDto dto);

    CarDto toDto(CarEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "brand", source = "brand")
    void update(@MappingTarget CarEntity entity, CarDto dto);

    List<CarDto> toDtos(List<CarEntity> all);


}
