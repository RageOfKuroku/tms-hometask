package com.example.demo.mapper;

import com.example.demo.domain.FilmEntity;
import com.example.demo.dto.FilmDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(
        componentModel = "spring"
)
public interface FilmMapper {
    @Mapping(target = "title", source = "title")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "rating", source = "rating")
    FilmEntity toEntity(FilmDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "rating", source = "rating")
    FilmDto toDto(FilmEntity entity);

    List<FilmEntity> toListEntity(List<FilmDto> dtos);

    List<FilmDto> toListDto(List<FilmEntity> entities);
}
