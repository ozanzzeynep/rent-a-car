package com.tobeto.rentACar.services.dtos.payment.response;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentResponse {
    private String cardNumber;
    private LocalDate date;
    private String cvv;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhone;
    private String customerEmail;
}
