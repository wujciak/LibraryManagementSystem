package com.jwojciak.book_service.service.interfaces;

import java.util.List;
import java.util.UUID;

import com.jwojciak.book_service.entity.BookEntity;
import com.jwojciak.book_service.model.CreateBookDTO;

public interface IBookService {

    List<BookEntity> getAll();
    BookEntity getBook(UUID bookId);
    BookEntity createBook(CreateBookDTO dto);
    void deleteBook(UUID bookId);
    List<BookEntity> getBookByTitle(String title);
    //update and patch
}
