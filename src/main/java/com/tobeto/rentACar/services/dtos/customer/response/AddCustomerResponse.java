package com.tobeto.rentACar.services.dtos.customer.response;

import com.tobeto.rentACar.entities.Customer;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerResponse {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
