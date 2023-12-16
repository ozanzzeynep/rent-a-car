package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.AddCustomerResponse;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerResponse;
import com.tobeto.rentACar.services.dtos.customer.response.UpdateCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetCustomerResponse> getAll();

    GetCustomerResponse getCustomerById(int id) throws  Throwable;


    AddCustomerResponse add(AddCustomerRequest request) throws Exception;

    UpdateCustomerResponse update (UpdateCustomerRequest request) throws Throwable;

    void delete (int id);

}
