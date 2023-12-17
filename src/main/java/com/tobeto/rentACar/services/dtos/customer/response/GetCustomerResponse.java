package com.tobeto.rentACar.services.dtos.customer.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerResponse {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
