package com.tobeto.rentACar.services.dtos.car.request;

import com.tobeto.rentACar.entities.Brand;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    private String name;
    private String model;
    private int year;
    private double price;
    private boolean available;

}
