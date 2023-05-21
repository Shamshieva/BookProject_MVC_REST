package com.manas.service;

import com.manas.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll(Long id);

    void save(Long vendorId, Book book);

    Book findById(Long bookId);

    void update(Long bookId, Book book);

    void delete(Long bookId);

}
