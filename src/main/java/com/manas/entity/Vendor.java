package com.manas.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@Entity
@Table(name = "vendor")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_gen")
    @SequenceGenerator(name = "vendor_gen", sequenceName = "vendor_seq", allocationSize = 1,initialValue = 7)
    private Long id;
    private String firstName;
    private String lastName;

    private String phoneNumber;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "created_at")
    private LocalDate createdAt;

    private String image;
    private String description;

    @OneToMany(cascade = ALL, mappedBy = "vendor")
    private List<Transaction> transactions;

    @OneToMany(cascade = ALL, mappedBy = "owner")
    private List<Book> books;

    public void addBook(Book book){
        if (books == null){
            books = new ArrayList<>();
        }
        books.add(book);
    }
}