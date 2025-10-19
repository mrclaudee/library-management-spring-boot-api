package com.mrclaudee.librarymanagmentapi.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    @Id
    private UUID id;

    private String name;

    private String lastName;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;
}
