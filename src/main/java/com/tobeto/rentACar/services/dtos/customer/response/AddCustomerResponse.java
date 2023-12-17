package com.tobeto.rentACar.services.dtos.customer.response;

import com.tobeto.rentACar.entities.Customer;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCustomerResponse {

    private Customer customer;
}
