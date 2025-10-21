package com.mrclaudee.librarymanagmentapi.services;

import com.mrclaudee.librarymanagmentapi.dtos.GenreDto;
import com.mrclaudee.librarymanagmentapi.entities.GenreEntity;
import com.mrclaudee.librarymanagmentapi.mappers.GenreMapper;
import com.mrclaudee.librarymanagmentapi.repositories.GenreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class GenreService implements IGenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenreService(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public GenreDto findById(String id) throws EntityNotFoundException {
         GenreEntity entity = genreRepository
                 .findById(UUID.fromString(id))
                 .orElseThrow(() -> new EntityNotFoundException("Genre with id " + id + " not found."));

         return genreMapper.toDto(entity);
    }

    @Override
    public void save(GenreDto genreDto) {
        genreRepository.save(genreMapper.toEntity(genreDto));
    }
}
