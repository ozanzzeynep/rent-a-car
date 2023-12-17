package com.tobeto.rentACar.services.dtos.customer.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
    private int customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
