package com.tobeto.rentACar.services.dtos.payment.response;

import com.tobeto.rentACar.entities.Customer;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPaymentResponse {

    private String cardNumber;
    private LocalDate date;
    private String cvv;
    private Customer customer;

}
