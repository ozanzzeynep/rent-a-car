package com.tobeto.rentACar.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Table(name = "payment")
@Entity
@Getter
@Setter
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

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
