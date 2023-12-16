package com.tobeto.rentACar.services.dtos.customer.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerResponse {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
