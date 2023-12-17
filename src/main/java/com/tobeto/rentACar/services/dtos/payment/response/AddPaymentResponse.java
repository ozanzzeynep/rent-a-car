package com.tobeto.rentACar.services.dtos.payment.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentResponse {

    private int paymentId;
    private String customerFirstName;
}
