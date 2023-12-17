package com.tobeto.rentACar.services.dtos.car.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarResponse {

    private String brandName;
    private String model;
    private int year;
    private double price;
    private boolean available;
}
