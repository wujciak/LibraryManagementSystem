package com.jwojciak.book_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwojciak.book_service.entity.BookDetailsEntity;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookDetailsEntity, UUID> {
}
