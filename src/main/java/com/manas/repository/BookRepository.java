package com.manas.repository;

import com.manas.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("from Book b where b.owner.id = :vendorId")
    List<Book> getAllByVendorId(Long vendorId);
}
