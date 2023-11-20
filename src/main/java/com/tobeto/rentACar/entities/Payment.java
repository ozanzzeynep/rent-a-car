package com.tobeto.rentACar.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "payment")
@Entity
public class Payment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name= "expire_date")
    private LocalDate date;

    @Column(name = "cvv")
    private String cvv;

    @OneToMany(mappedBy = "payment")
    private List<Customer> customers;





}
