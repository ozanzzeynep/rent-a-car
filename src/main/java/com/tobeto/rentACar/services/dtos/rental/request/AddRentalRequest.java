package com.tobeto.rentACar.services.dtos.rental.request;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddRentalRequest {

    private LocalDate date;
    private LocalDate due;
    private int customerId;
    private int carId;
}
