package com.mrclaudee.librarymanagmentapi.repositories;

import com.mrclaudee.librarymanagmentapi.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {
}
