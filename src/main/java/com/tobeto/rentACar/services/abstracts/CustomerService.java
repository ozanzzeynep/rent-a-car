package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetCustomerResponse> getAll();

    Customer getCustomerById(int id);

    void add(AddCustomerRequest request);

    void update (UpdateCustomerRequest request);

    void delete (int id);

}
