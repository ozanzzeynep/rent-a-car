package com.tobeto.rentACar.services.dtos.car.response;

import com.tobeto.rentACar.entities.Brand;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCarResponse {

    private String brand;
    private String model;
    private int year;
    private double price;
    private boolean available;
}
