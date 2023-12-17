package com.tobeto.rentACar.services.dtos.car.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarResponse {
    private String brandName;
    private String model;
    private int year;
    private double price;
    private boolean available;

}
