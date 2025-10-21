package com.mrclaudee.librarymanagmentapi.controllers;

import com.mrclaudee.librarymanagmentapi.dtos.GenreDto;
import com.mrclaudee.librarymanagmentapi.services.IGenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/genres")
@Tag(name = "Genre Management", description = "API for genre management")
public class GenreController {
    private final IGenreService genreService;


    public GenreController(IGenreService genreService) {
        this.genreService = genreService;
    }

    @Operation(summary = "Get genre by id", description = "Return the Genre as Dto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<GenreDto> getById(@PathVariable String id) throws EntityNotFoundException {
        return new ResponseEntity<>(genreService.findById(id), HttpStatus.OK);
    }

}
