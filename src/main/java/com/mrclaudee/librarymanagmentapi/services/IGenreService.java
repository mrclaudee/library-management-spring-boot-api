package com.mrclaudee.librarymanagmentapi.services;


import com.mrclaudee.librarymanagmentapi.dtos.GenreDto;
import jakarta.persistence.EntityNotFoundException;

public interface IGenreService {
    GenreDto findById(String id) throws EntityNotFoundException;
    void save(GenreDto genreDto);
}
