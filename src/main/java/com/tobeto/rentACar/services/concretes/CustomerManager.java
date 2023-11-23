package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.entities.Customer;
import com.tobeto.rentACar.services.abstracts.CustomerService;
import com.tobeto.rentACar.services.dtos.customer.request.AddCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.request.UpdateCustomerRequest;
import com.tobeto.rentACar.services.dtos.customer.response.GetCustomerResponse;

import java.util.List;

public class CustomerManager implements CustomerService {


    @Override
    public List<GetCustomerResponse> getAll() {
        return null;
    }

    @Override
    public Customer getCustomerById(int id) {
        return null;
    }

    @Override
    public void add(AddCustomerRequest request) {

    }

    @Override
    public void update(UpdateCustomerRequest request) {

    }

    @Override
    public void delete(int id) {

    }
}
