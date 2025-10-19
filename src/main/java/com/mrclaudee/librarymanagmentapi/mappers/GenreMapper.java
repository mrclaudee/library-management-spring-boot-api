package com.mrclaudee.librarymanagmentapi.mappers;

import com.mrclaudee.librarymanagmentapi.dtos.GenreDto;
import com.mrclaudee.librarymanagmentapi.entities.GenreEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GenreMapper {
    GenreEntity toEntity(GenreDto genreDto);
    GenreDto toDto(GenreEntity genreEntity);
}
