package com.tobeto.rentACar.services.dtos.payment.request;


import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentRequest {

    private int customerId;
    private String cardNumber;
    private LocalDate date;
    private String cvv;

}
