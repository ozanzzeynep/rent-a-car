package com.tobeto.rentACar.services.dtos.rental.response;

import com.tobeto.rentACar.entities.Car;
import com.tobeto.rentACar.entities.Customer;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateRentalResponse {

    private LocalDate date;
    private LocalDate due;
    private int customerId;
    private int carId;
}
