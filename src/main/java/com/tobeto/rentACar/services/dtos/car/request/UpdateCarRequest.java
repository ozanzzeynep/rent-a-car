package com.tobeto.rentACar.services.dtos.car.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    private int carId;
    private int brandId;
    private String model;
    private int year;
    private double price;
    private boolean available;
}
