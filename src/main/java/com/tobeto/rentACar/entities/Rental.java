package com.tobeto.rentACar.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Table(name = "rental")
@Entity
public class Rental {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "date")
    private LocalDate date;

    @Column(name = "due")
    private LocalDate due;

    @OneToMany(mappedBy = "rental")
    private List<Customer> customers;

    @OneToMany(mappedBy = "rental")
    private List<Car> cars;
}
