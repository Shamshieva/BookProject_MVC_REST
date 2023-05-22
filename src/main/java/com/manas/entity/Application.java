package com.manas.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "applications")
@NoArgsConstructor
@AllArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_gen")
    @SequenceGenerator(name = "application_gen", sequenceName = "application_seq",allocationSize = 1, initialValue = 7)
    private Long id;

    @OneToOne(cascade = {MERGE, REFRESH, DETACH, PERSIST})
    private User user;

    private LocalDate date;
    private String phoneNumber;
    private Boolean accepted;
}