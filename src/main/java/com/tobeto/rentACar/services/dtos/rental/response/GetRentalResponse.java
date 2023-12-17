package com.tobeto.rentACar.services.dtos.rental.response;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Customer;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRentalResponse {
    private LocalDate date;
    private LocalDate due;
    private String customerFirstName;
    private String customerLastName;
    private String carModel;
    private double carPrice;
}
