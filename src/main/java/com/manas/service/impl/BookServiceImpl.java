package com.manas.service.impl;

import com.manas.entity.Book;
import com.manas.entity.Vendor;
import com.manas.repository.BookRepository;
import com.manas.repository.VendorRepository;
import com.manas.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final VendorRepository vendorRepository;

    @Override
    public List<Book> getAll(Long vendorId) {
        return bookRepository.getAllByVendorId(vendorId);
    }

    @Override
    public void save(Long vendorId, Book book) {
        Vendor vendor = vendorRepository.findById(vendorId).orElseThrow(
                () -> new NoSuchElementException("Vendor by id " + vendorId + " is not found!"));
        vendor.addBook(book);
        book.setOwner(vendor);
        bookRepository.save(book);
    }

    @Override
    public Book findById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(()-> new NoSuchElementException("Book by id " + bookId + " not found"));
    }

    @Override
    public void update(Long bookId, Book book) {
        Book book1 = bookRepository.findById(bookId).orElseThrow(
                () -> new NoSuchElementException("Book by id " + bookId + " is not found!"));
        book1.setAuthor(book.getAuthor());
        book1.setPrice(book.getPrice());
        book1.setTitle(book.getTitle());
        book1.setDescription(book.getDescription());
    }

    @Override
    public void delete(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
