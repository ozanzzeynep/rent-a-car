package com.tobeto.rentACar.services.dtos.rental.response;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Customer;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRentalResponse {

    private LocalDate date;
    private LocalDate due;
    private Customer customer;
    private Car car;
}
