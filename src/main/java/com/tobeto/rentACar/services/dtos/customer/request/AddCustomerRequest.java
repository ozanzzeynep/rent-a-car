package com.tobeto.rentACar.services.dtos.customer.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
