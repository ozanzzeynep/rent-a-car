package com.tobeto.rentACar.services.dtos.payment.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPaymentResponse {

    private int paymentId;
    private String customerFirstName;
    private String customerLastName;
    private String customerPhone;
    private String customerEmail;

}
