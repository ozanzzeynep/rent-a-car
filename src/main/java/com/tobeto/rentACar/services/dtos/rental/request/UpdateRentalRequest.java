package com.tobeto.rentACar.services.dtos.rental.request;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateRentalRequest {

    private int rentalId;
    private LocalDate date;
    private LocalDate due;
    private int customerId;
    private int carId;
}
