package com.mrclaudee.librarymanagmentapi.controllers;

import com.mrclaudee.librarymanagmentapi.dtos.GenreDto;
import com.mrclaudee.librarymanagmentapi.services.IGenreService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class GenreController {
    private final IGenreService genreService;


    public GenreController(IGenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres/{id}")
    public ResponseEntity<GenreDto> getById(@PathVariable String id) throws EntityNotFoundException {
        return new ResponseEntity<>(genreService.findById(id), HttpStatus.OK);
    }

}
