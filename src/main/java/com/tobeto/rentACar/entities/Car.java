package com.tobeto.rentACar.entities;


import jakarta.persistence.*;

//ORM : Object Relation Mapping
@Table(name = "cars")
@Entity
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "price")
    private double price;

    @Column(name = "available")
    private boolean available;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

}
