package com.tobeto.rentACar.services.dtos.payment.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPaymentResponse {

    private int paymentId;
    private String customerName;
    private String customerSurname;
    private String customerPhone;
    private String customerEmail;

}
