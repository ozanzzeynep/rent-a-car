package com.tobeto.rentACar.services.dtos.car.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCarResponse {
    private String brand;
    private String model;
    private int year;
    private double price;
    private boolean available;

}
