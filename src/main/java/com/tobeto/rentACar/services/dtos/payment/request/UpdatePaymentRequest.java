package com.tobeto.rentACar.services.dtos.payment.request;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentRequest {

    private int paymentId;
    private String cardNumber;
    private LocalDate date;
    private String cvv;
    private int customerId;

}
