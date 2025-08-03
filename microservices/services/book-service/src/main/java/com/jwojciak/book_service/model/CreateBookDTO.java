package com.jwojciak.book_service.model;

import com.jwojciak.book_service.entity.BookEntity;

public record CreateBookDTO(
    String isbn,
    String title,
    String author,
    String publisher,
    int yearOfPublish,
    int availableCopies
) {
    public BookEntity toEntity() {
        BookEntity book = new BookEntity();
        book.setIsbn(this.isbn);
        book.setTitle(this.title);
        book.setAuthor(this.author);
        book.setPublisher(this.publisher);
        book.setYearOfPublish(this.yearOfPublish);
        book.setAvailableCopies(this.availableCopies);
        return book;
    } 
}
