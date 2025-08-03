package com.jwojciak.book_service.model;

import java.util.UUID;

import com.jwojciak.book_service.entity.BookEntity;

public record BookDTO(
    UUID bookId,
    String isbn,
    String title,
    String author,
    String publisher,
    int yearOfPublish,
    int availableCopies
) {
    public static BookDTO fromEntity(BookEntity b) {
        return new BookDTO(b.getBookId(), b.getIsbn(), b.getTitle(), b.getAuthor(), b.getPublisher(), b.getYearOfPublish(), b.getAvailableCopies());
    }
}
