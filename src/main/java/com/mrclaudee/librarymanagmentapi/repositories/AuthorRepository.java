package com.mrclaudee.librarymanagmentapi.repositories;

import com.mrclaudee.librarymanagmentapi.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorEntity, UUID> {
}
