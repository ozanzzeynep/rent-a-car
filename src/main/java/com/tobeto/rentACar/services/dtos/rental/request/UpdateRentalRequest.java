package com.tobeto.rentACar.services.dtos.rental.request;


import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    private int rentalId;
    private LocalDate date;
    private LocalDate due;
    private int customerId;
    private int carId;
}
