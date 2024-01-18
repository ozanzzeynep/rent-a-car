package com.tobeto.rentACar.services.dtos.car.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {

    private int id;
    private String brandName;
    private String model;
    private int year;
    private double price;
    private boolean available;


}
