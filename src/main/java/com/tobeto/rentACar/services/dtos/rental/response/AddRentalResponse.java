package com.tobeto.rentACar.services.dtos.rental.response;


import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddRentalResponse {

    private LocalDate date;
    private LocalDate due;
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String carModel;
    private String carBrand;

}
