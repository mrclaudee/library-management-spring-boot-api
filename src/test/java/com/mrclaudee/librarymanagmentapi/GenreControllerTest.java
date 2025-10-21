package com.mrclaudee.librarymanagmentapi;

import com.mrclaudee.librarymanagmentapi.controllers.GenreController;
import com.mrclaudee.librarymanagmentapi.dtos.GenreDto;
import com.mrclaudee.librarymanagmentapi.services.IGenreService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GenreController.class)
class GenreControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IGenreService genreService;

    @Test
    void shouldReturnGenreById() throws Exception {
        String genreId = "07cb0150-2524-4ea2-a2bb-cc171da3c5e5";
        GenreDto genre = new GenreDto(genreId, "Horror");
        when(genreService.findById(genreId)).thenReturn(genre);

        mockMvc.perform(get("/api/genres/{id}", genreId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(genreId))
                .andExpect(jsonPath("$.name").value("Horror"));

        verify(genreService, times(1)).findById(genreId);
    }

    @Test
    void shouldReturn404WhenGenreNotFound() throws Exception {
        String nonExistentId = "08cb0150-2524-3lk3-a2bb-cc171da3c5c3";
        when(genreService.findById(nonExistentId))
                .thenThrow(new EntityNotFoundException("Genre with id " + nonExistentId + " not found."));

        mockMvc.perform(get("/api/genres/{id}", nonExistentId))
                .andExpect(status().isNotFound());
    }
}