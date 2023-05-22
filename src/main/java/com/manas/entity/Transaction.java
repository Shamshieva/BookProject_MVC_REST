package com.manas.entity;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static javax.persistence.CascadeType.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    @SequenceGenerator(name = "transaction_seq", allocationSize = 1, initialValue = 7)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "buyer_id")
    private User user;

    @ManyToOne()
    private Vendor vendor;

    @OneToOne()
    private Book book;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

}