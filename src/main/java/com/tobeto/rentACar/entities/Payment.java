package com.tobeto.rentACar.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Table(name = "payments")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
