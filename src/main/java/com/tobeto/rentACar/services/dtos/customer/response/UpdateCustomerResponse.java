package com.tobeto.rentACar.services.dtos.customer.response;

import com.tobeto.rentACar.entities.Customer;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerResponse {
    private Customer customer;
}
