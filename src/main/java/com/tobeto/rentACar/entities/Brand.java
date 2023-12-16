package com.tobeto.rentACar.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "brands")
@Entity
@Data
public class Brand {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String brand_name;

    @OneToMany(mappedBy = "brand")
    private List<Car> cars;
}
