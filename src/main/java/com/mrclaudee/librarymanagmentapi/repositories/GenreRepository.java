package com.mrclaudee.librarymanagmentapi.repositories;

import com.mrclaudee.librarymanagmentapi.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, UUID> {
}
