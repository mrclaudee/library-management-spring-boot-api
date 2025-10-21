package com.mrclaudee.librarymanagmentapi.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(description = "Genre Dto")
@Data
@AllArgsConstructor
public class GenreDto {
    @Schema(description = "unique id identifier", example = "07cb0150-2524-4ea2-a2bb-cc171da3c5e5")
    private String id;

    @Schema(description = "name of the genre", example = "Horror", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;
}
