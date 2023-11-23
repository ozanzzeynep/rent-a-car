package com.tobeto.rentACar.services.dtos.car.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    private String brand;
    private int id;
    private String model;
    private int year;
    private double price;
    private boolean available;
}
