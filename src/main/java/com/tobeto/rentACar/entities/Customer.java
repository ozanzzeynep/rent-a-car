package com.tobeto.rentACar.entities;

import jakarta.persistence.*;

@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;


    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;


    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

}
